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

import com.epam.lab.model.Hotel;
import com.epam.lab.model.Manager;
import com.epam.lab.service.HotelService;
import com.epam.lab.utils.Location;

public class ManagerFilter implements Filter {

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
				|| !(session.getAttribute("user") instanceof Manager)) {
			resp.sendRedirect("managerlogin");
			return;
		}
		if (session.getAttribute("redirect_url") != null) {
			session.removeAttribute("redirect_url");
		}
		if (req.getRequestURI().equals("/HotelBooking/admincountry")) {
			session.removeAttribute("region_init");
			session.removeAttribute("city_init");
			session.removeAttribute("street_init");
		}
		if (req.getRequestURI().equals("/HotelBooking/adminregion")) {
			session.removeAttribute("country_init");
			session.removeAttribute("city_init");
			session.removeAttribute("street_init");
		}
		if (req.getRequestURI().equals("/HotelBooking/admincity")) {
			session.removeAttribute("country_init");
			session.removeAttribute("region_init");
			session.removeAttribute("street_init");
		}
		if (req.getRequestURI().equals("/HotelBooking/adminstreet")) {
			session.removeAttribute("country_init");
			session.removeAttribute("region_init");
			session.removeAttribute("city_init");
		}

		session.setAttribute("languages", Location.getInstance()
				.getLanguagesList());

		if (((Manager) session.getAttribute("user")).getHotelId() == null) {
			resp.sendRedirect("managerrequired");
			return;
		}

		if (session.getAttribute("hotel") == null) {
			Hotel hotel = new HotelService()
					.selectHotelByManagerId((Manager) session
							.getAttribute("user"));
			session.setAttribute("hotel", hotel);
		}
		session.setAttribute("languages", Location.getInstance()
				.getLanguagesList());
		arg2.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
