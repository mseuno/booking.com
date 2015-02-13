package com.epam.lab.controller.impl.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.service.LocaleService;
import com.epam.lab.utils.Location;

public class AdminLocaleController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/admin_locale.jsp";
	private final String URL_EDIT = "/pages/extranet/admin_cabinet/actions/edit/edit_locale.jsp";
	private Location location = new Location();
	private LocaleService localeService = new LocaleService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		request.setAttribute("locales", location.getLanguagesList());

		if (request.getParameter("edit_update") != null) {

			request.setAttribute("locale", localeService.getLocaleById(request
					.getParameter("edit_id")));
			System.out.println("edit not null");
			forward(URL_EDIT, request, response);
			return;
		}

		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		// TODO Auto-generated method stub

		if (request.getParameter("update_name") != null) {

			String oldId = request.getParameter("locale_id");
			Locale locale = localeService.getLocaleById(oldId);

			locale.setName(request.getParameter("update_name"));

			localeService.updateLocale(locale, oldId);

			request.setAttribute("message", "updating locale already complete!");

		}

		if (request.getParameter("create_locale") != null) {
			request.setAttribute("formLocale", "form locale");
			System.out.println("bbbbbbbb");

		}

		if (request.getParameter("add") != null) {

			Locale locale = new Locale();
			String name = request.getParameter("new_locale_name");
			String id = request.getParameter("new_locale_id");

			locale.setId(id);
			locale.setName(name);

			localeService.createLocale(locale);

			request.setAttribute("message",
					"adding new locale already complete!");

			request.setAttribute("locales", location.getLanguagesList());

		}

		forward(URL, request, response);

	}

}
