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
import com.epam.lab.model.City;
import com.epam.lab.service.AdminService;
import com.epam.lab.service.CityService;
import com.epam.lab.utils.Location;

public class AdminCityController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/admin_city.jsp";
	private final String URL_EDIT = "/pages/extranet/admin_cabinet/actions/edit/edit_city.jsp";

	private AdminService adminService = new AdminService();
	private CityService cityService = new CityService();
	private String language = "en";
	private Long selectboxCountryId = (long) -1;
	private Long selectboxRegionId = (long) -1;
	private Location location = Location.getInstance();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("city_init") == null) {
			init(request, response);
			forward(URL, request, response);
			return;
		}
		if (request.getParameter("search_locale_id") != null) {
			language = request.getParameter("search_locale_id");
			request.setAttribute("AdminCity_page_language",
					request.getParameter("search_locale_id"));
		} else {
			language = ((ResourceBundle) request.getSession().getAttribute(
					"ResourceBundle")).getLocale().getLanguage();
		}
		// Update
		if (request.getParameter("edit_update") != null) {
			List<City> city = location.getCity(toLong(request
					.getParameter("edit_id")));
			request.setAttribute("countries", location.getCountryList(language));
			request.setAttribute("city_id", request.getParameter("edit_id"));
			request.setAttribute("city", city);
			forward(URL_EDIT, request, response);
			return;
		}
		// Create
		if (request.getParameter("edit_create") != null) {
			request.setAttribute("update_create", "create");
			request.setAttribute("countries", location.getCountryList(language));
			forward(URL_EDIT, request, response);
			return;
		}
		if (request.getParameter("edit_delete") != null) {
			cityService.delete(toLong(request.getParameter("edit_delete")));
		}

		if (request.getParameter("search_country_id") != null) {
			selectboxCountryId = toLong(request
					.getParameter("search_country_id"));
			request.setAttribute("AdminCity_country_id", selectboxCountryId);
		}
		if (request.getParameter("search_region_id") != null) {
			selectboxRegionId = toLong(request.getParameter("search_region_id"));
			request.setAttribute("AdminCity_region_id", selectboxRegionId);
		}
		// Search
		if (request.getParameter("search") != null
				&& !request.getParameter("search_name").isEmpty()) {
			request.setAttribute("cities",
					adminService.pickCitiesByName(request.getParameterMap()));
		} else {
			request.setAttribute("cities", location.getCitiesList(
					selectboxCountryId, selectboxRegionId, language));
		}

		request.setAttribute("countries", location.getCountryList(language));
		request.setAttribute("regions",
				location.getRegionListSelectBox(selectboxCountryId, language));
		request.setAttribute("search_result",
				request.getParameter("search_name"));
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		if (request.getParameter("delete") != null) {
			long id = toLong(request.getParameter("city_id"));
			cityService.delete(id);
			executeGet(servletContext, request, response);
			return;
		}
		if (request.getParameter("update") != null) {
			long id = toLong(request.getParameter("city_id"));
			selectboxRegionId = toLong(request.getParameter("search_region_id"));
			selectboxCountryId = toLong(request
					.getParameter("search_country_id"));
			cityService.update(request.getParameterValues("edit_names"),
					request.getParameterValues("edit_locale"), id,
					selectboxRegionId, selectboxCountryId);
			executeGet(servletContext, request, response);
			return;

		}
		if (request.getParameter("create") != null) {
			selectboxRegionId = toLong(request.getParameter("search_region_id"));
			selectboxCountryId = toLong(request
					.getParameter("search_country_id"));
			cityService.create(request.getParameterValues("edit_names"),
					request.getParameterValues("edit_locale"),
					selectboxCountryId, selectboxRegionId);
			executeGet(servletContext, request, response);
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
		request.setAttribute("cities", location.getCitiesList(language));
		request.setAttribute("AdminCity_page_language", language);
		session.setAttribute("city_init", "true");
	}
}
