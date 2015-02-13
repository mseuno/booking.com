package com.epam.lab.controller.impl.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.service.AdminService;
import com.epam.lab.service.ServiceService;
import com.epam.lab.utils.Location;

public class AdminServiceController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/admin_service.jsp";
	private final String URL_EDIT = "/pages/extranet/admin_cabinet/actions/edit/edit_service.jsp";

	private ServiceService serviceService = new ServiceService();
	private Location location = Location.getInstance();
	private String language = "en";
	private boolean reload = false;

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("service_init") == null) {
			init(request, response);
			forward(URL, request, response);
			return;
		}
		language = (String) session.getAttribute("AdminService_page_language");
		// Change language
		if (request.getParameter("search_locale_id") != null) {
			language = request.getParameter("search_locale_id");
			session.setAttribute("AdminService_page_language", language);
			session.setAttribute("services",
					location.getServicesList(language, false));
		}

		// Update
		if (request.getParameter("update_update") != null) {
			request.setAttribute("service", location.getService(toLong(request
					.getParameter("update_service_id"))));
			executePost(servletContext, request, response);
			return;
		}
		// Delete
		if (request.getParameter("edit_delete") != null) {
			serviceService.delete(toLong(request.getParameter("edit_delete")));
			reload = true;
		}

		// Create
		if (request.getParameter("edit_create") != null) {
			request.setAttribute("update_create", "create");
			executePost(servletContext, request, response);
			return;
		}

		// Search
		if (request.getParameter("search") != null
				&& !request.getParameter("search_name").isEmpty()) {
			session.setAttribute("services", new AdminService()
					.pickServiceByName(request.getParameterMap()));
		}
		// Reload after update changes
		if (reload) {
			session.setAttribute("services",
					location.getServicesList(language, false));
		}
		request.setAttribute("search_result",
				request.getParameter("search_name"));
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		if (request.getParameter("update") != null) {
			String[] names = request.getParameterValues("edit_names");
			String[] locales = request.getParameterValues("edit_locale");
			long id = toLong(request.getParameter("service_id"));
			serviceService.update(names, locales, id);
			reload = true;
			executeGet(servletContext, request, response);
			return;
		}
		if (request.getParameter("create") != null) {
			String[] names = request.getParameterValues("edit_names");
			String[] locales = request.getParameterValues("edit_locale");
			serviceService.create(names, locales);
			reload = true;
			executeGet(servletContext, request, response);
			return;
		}
		if (request.getParameter("delete") != null) {
			serviceService.delete(toLong(request.getParameter("service_id")));
			reload = true;
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
		session.setAttribute("services",
				location.getServicesList(language, false));
		session.setAttribute("AdminService_page_language", language);
		session.setAttribute("service_init", "true");
	}
}
