package com.epam.lab.filters;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.utils.ResourceBundleManager;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		Cookie language = null;
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("language")) {
					language = c;
				}
			}
		}
		if (session.getAttribute("ResourceBundle") == null) {
			if (language == null) {
				session.setAttribute("ResourceBundle",
						new ResourceBundleManager().getBundle(req));
				language = new Cookie("language", new ResourceBundleManager()
						.getBundle(req).getLocale().getLanguage());
				language.setMaxAge(365 * 24 * 60 * 60);
				resp.addCookie(language);
			} else {
				session.setAttribute("ResourceBundle",
						new ResourceBundleManager().getBundle(new Locale(
								language.getValue())));
			}

		}

		if (req.getRequestURI().equals("/HotelBooking/managerlogin")) {

			if (session.getAttribute("user") != null) {
				resp.sendRedirect("already-login");
				return;
			}
		}

		if (req.getRequestURI().equals("/HotelBooking/userlogin")) {

			if (session.getAttribute("user") != null) {
				resp.sendRedirect("already-login");
				return;
			}
		}
		if (req.getRequestURI().equals("/HotelBooking/adminlogin")) {

			if (session.getAttribute("user") != null) {
				resp.sendRedirect("already-login");
				return;
			}
		}
		arg2.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
