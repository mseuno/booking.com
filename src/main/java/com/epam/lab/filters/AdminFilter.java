package com.epam.lab.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.model.Admin;
import com.epam.lab.utils.Location;

public class AdminFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		session.setAttribute("redirect_url", req.getRequestURI());
		if (session.getAttribute("user") == null
				|| !(session.getAttribute("user") instanceof Admin)) {
			resp.sendRedirect("adminlogin");
			return;
		}
		session.setAttribute("languages", Location.getInstance()
				.getLanguagesList());
		arg2.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
