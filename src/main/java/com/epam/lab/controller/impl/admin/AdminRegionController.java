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
import com.epam.lab.model.Region;
import com.epam.lab.service.AdminService;
import com.epam.lab.service.RegionService;
import com.epam.lab.utils.Location;

public class AdminRegionController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/admin_region.jsp";
	private final String URL_EDIT = "/pages/extranet/admin_cabinet/actions/edit/edit_region.jsp";

	private AdminService adminService = new AdminService();
	private RegionService regionService = new RegionService();
	private String language = "en";
	private Long selectboxCountryId = (long) -1;
	private Location location = Location.getInstance();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("region_init") == null) {
			init(request, response);
			forward(URL, request, response);
			return;
		}

		if (request.getParameter("search_locale_id") != null) {
			language = request.getParameter("search_locale_id");
			request.setAttribute("AdminRegion_page_language",
					request.getParameter("search_locale_id"));
		} else {
			language = ((ResourceBundle) request.getSession().getAttribute(
					"ResourceBundle")).getLocale().getLanguage();
		}
		// Update
		if (request.getParameter("edit_update") != null) {
			List<Region> region = location.getRegion(toLong(request
					.getParameter("edit_id")));
			request.setAttribute("region_id",
					request.getAttribute("update_init"));
			request.setAttribute("region", region);
			if (region != null) {
				request.setAttribute("AdminRegion_country_id", region.get(0)
						.getCountryId());
			}
			request.setAttribute("countries", location.getCountryList(language));
			forward(URL_EDIT, request, response);
			return;
		}
		// Create
		if (request.getParameter("edit_create") != null) {
			request.setAttribute("update_create", "create");
			forward(URL_EDIT, request, response);
			return;
		}
		// Delete
		if (request.getParameter("edit_delete") != null) {
			regionService.delete(toLong(request.getParameter("edit_delete")));
		}

		if (request.getParameter("search_country_id") != null) {
			selectboxCountryId = toLong(request
					.getParameter("search_country_id"));
			request.setAttribute("AdminRegion_country_id", selectboxCountryId);
		}

		// Search
		if (request.getParameter("search") != null
				&& !request.getParameter("search_name").isEmpty()) {
			request.setAttribute("regions",
					adminService.pickRegionsByName(request.getParameterMap()));
		} else {
			request.setAttribute("regions",
					location.getRegionList(selectboxCountryId, language));
		}

		request.setAttribute("countries", location.getCountryList(language));
		request.setAttribute("search_result",
				request.getParameter("search_name"));
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		boolean forwardBack = false;
		language = (String) session.getAttribute("AdminRegion_page_language");

		if (request.getParameter("delete") != null) {
			long id = toLong(request.getParameter("region_id"));
			regionService.delete(id);
			forwardBack = true;
		}
		if (request.getParameter("update") != null) {
			long id = toLong(request.getParameter("region_id"));
			selectboxCountryId = toLong(request
					.getParameter("search_country_id"));
			regionService.update(request.getParameterValues("edit_names"),
					request.getParameterValues("edit_locale"), id,
					selectboxCountryId);
			forwardBack = true;
		}
		if (request.getParameter("create") != null) {
			selectboxCountryId = toLong(request
					.getParameter("search_country_id"));
			regionService.create(request.getParameterValues("edit_names"),
					request.getParameterValues("edit_locale"),
					selectboxCountryId);
			forwardBack = true;
		}

		if (request.getParameter("search_country_id") != null) {
			request.setAttribute("countries", location.getCountryList(language));
			request.setAttribute("AdminRegion_country_id",
					toLong(request.getParameter("search_country_id")));
		}

		if (forwardBack) {
			request.setAttribute("regions",
					location.getRegionList(selectboxCountryId, language));
			request.setAttribute("countries", location.getCountryList(language));
			forward(URL, request, response);
			return;
		} else {
			forward(URL_EDIT, request, response);
		}
	}

	private void init(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		language = ((ResourceBundle) request.getSession().getAttribute(
				"ResourceBundle")).getLocale().getLanguage();
		request.setAttribute("countries", location.getCountryList(language));
		request.setAttribute("regions", location.getRegionList(language));
		request.setAttribute("AdminRegion_page_language", language);
		session.setAttribute("region_init", "true");
	}
}
