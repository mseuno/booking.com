package com.epam.lab.controller.impl.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Country;
import com.epam.lab.service.AdminService;
import com.epam.lab.service.CountryService;
import com.epam.lab.utils.Location;

public class AdminCountryController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/admin_country.jsp";
	private final String URL_EDIT = "/pages/extranet/admin_cabinet/actions/edit/edit_country.jsp";
	private CountryService countryService = new CountryService();
	private AdminService adminService = new AdminService();
	private String language = "en";
	private Location location = Location.getInstance();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("country_init") == null) {
			init(request, response);
			forward(URL, request, response);
			return;
		}

		if (request.getParameter("search_locale_id") != null) {
			language = request.getParameter("search_locale_id");
			session.setAttribute("AdminCountry_page_language",
					request.getParameter("search_locale_id"));
		} else {
			language = ((ResourceBundle) request.getSession().getAttribute(
					"ResourceBundle")).getLocale().getLanguage();
		}

		// Update
		if (request.getParameter("edit_update") != null) {
			List<Country> country = location.getCountry(toLong(request
					.getParameter("edit_id")));
			request.setAttribute("country_id",
					request.getAttribute("update_init"));
			request.setAttribute("country", country);
			forward(URL_EDIT, request, response);
			return;
		}
		// Create
		if (request.getParameter("edit_create") != null) {
			forward(URL_EDIT, request, response);
			return;
		}
		// Delete
		if (request.getParameter("edit_delete") != null) {
			countryService.delete(toLong(request.getParameter("edit_delete")));
		}
		// Search
		if (request.getParameter("search") != null
				&& !request.getParameter("search_name").isEmpty()) {
			request.setAttribute("countries",
					adminService.pickCountriesByName(request.getParameterMap()));
		} else {
			request.setAttribute("countries", location.getCountryList(language));
		}
		request.setAttribute("search_result",
				request.getParameter("search_name"));
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		if (request.getParameter("delete") != null) {
			long id = toLong(request.getParameter("country_id"));
			countryService.delete(id);
			forward(URL, request, response);
			return;
		}
		if (request.getParameter("update") != null) {
			long id = toLong(request.getParameter("country_id"));
			countryService.update(request.getParameterValues("edit_names"),
					request.getParameterValues("edit_locale"), id);
			request.setAttribute("countries", location.getCountryList(language));
			forward(URL, request, response);
			return;

		}
		if (request.getParameter("create") != null) {
			countryService.create(request.getParameterValues("edit_names"),
					request.getParameterValues("edit_locale"));
			request.setAttribute("countries", location.getCountryList(language));
			forward(URL, request, response);
			return;
		}

		if (request.getParameter("update_page") != null
				&& !request.getParameter("update_page").equals("create")) {
			long id = toLong(request.getParameter("country_id"));
			List<Country> country = countryService.refreshInfoForUpdate(
					request.getParameterValues("edit_names"),
					request.getParameterValues("edit_locale"), id);
			request.setAttribute("country", country);
			forward(URL_EDIT, request, response);
			return;
		}
		forward(URL_EDIT, request, response);
	}

	private void init(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();

		language = ((ResourceBundle) request.getSession().getAttribute(
				"ResourceBundle")).getLocale().getLanguage();
		request.setAttribute("countries", location.getCountryList(language));
		session.setAttribute("AdminCountry_page_language", language);
		session.setAttribute("country_init", "true");
	}
}
