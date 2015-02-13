package com.epam.lab.controller.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.utils.ResourceBundleManager;

public class LanguageController extends DispatcherController {

	private final String URL = "/WEB-INF/jsp/temp/language_example.jsp";

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();

		if (request.getParameter("english") != null) {
			session.setAttribute("ResourceBundle",
					new ResourceBundleManager().getBundle(Locale.ENGLISH));
		} else if (request.getParameter("ukraine") != null) {
			session.setAttribute("ResourceBundle",
					new ResourceBundleManager().getBundle(new Locale("ua")));
		}

		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		forward(URL, request, response);
	}

}
