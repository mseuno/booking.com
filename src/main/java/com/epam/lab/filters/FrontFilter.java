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

import com.epam.lab.model.Admin;
import com.epam.lab.model.Manager;
import com.epam.lab.model.User;
import com.epam.lab.utils.Location;
import com.epam.lab.utils.ResourceBundleManager;

public class FrontFilter implements Filter {

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

		/**
		 * Check URL
		 */

		if (req.getRequestURI().equals("/HotelBooking/cabinet")) {

			if (session.getAttribute("user") instanceof Manager) {
				resp.sendRedirect("manager");
				return;
			}
			if (session.getAttribute("user") instanceof Admin) {
				resp.sendRedirect("adminhome");
				return;
			}
			if (session.getAttribute("user") instanceof User) {
				resp.sendRedirect("user");
				return;
			}
		}

		if (req.getRequestURI().equals("/HotelBooking/managerrequired")) {
			if (session.getAttribute("user") == null
					|| !(session.getAttribute("user") instanceof Manager)
					|| ((Manager) session.getAttribute("user")).getHotelId() != null) {
				resp.sendRedirect("home");
				return;
			}
		}

		/**
		 * Language
		 */

		if (req.getParameter("language") != null) {
			if (req.getParameter("language").equals("ukraine")) {
				session.setAttribute("ResourceBundle",
						new ResourceBundleManager().getBundle(new Locale("ua")));

				language = new Cookie("language", "ua");
				language.setMaxAge(365 * 24 * 60 * 60);
				resp.addCookie(language);
			}
			if (req.getParameter("language").equals("english")) {
				session.setAttribute("ResourceBundle",
						new ResourceBundleManager().getBundle(Locale.ENGLISH));

				language = new Cookie("language", "en");
				language.setMaxAge(365 * 24 * 60 * 60);
				resp.addCookie(language);
			}

			resp.sendRedirect(req.getHeader("Referer"));
			return;
		}
		/*
		 * 
		 * Remove session attribute
		 */
		session.removeAttribute("hotel");
		session.removeAttribute("language");
		session.removeAttribute("AdminCountry_country_language");

		session.removeAttribute("AdminRegion_region_language_id");
		session.removeAttribute("AdminRegion_region_country_id");

		session.removeAttribute("AdminCity_city_language_id");
		session.removeAttribute("AdminCity_city_country_id");
		session.removeAttribute("AdminCity_city_region_id");

		session.removeAttribute("AdminStreet_street_language_id");
		session.removeAttribute("AdminStreet_street_country_id");
		session.removeAttribute("AdminStreet_street_region_id");
		session.removeAttribute("AdminStreet_street_city_id");

		session.removeAttribute("message");
		
		session.removeAttribute("languages");
		arg2.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		Location.getInstance().loadAll();
	}

}
