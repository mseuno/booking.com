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
import com.epam.lab.model.Admin;
import com.epam.lab.model.Manager;
import com.epam.lab.service.HotelService;
import com.epam.lab.service.ManagerService;

public class AdminHomeController extends DispatcherController {

	private final String url = "/pages/extranet/admin_cabinet/actions/admin.jsp";
	private ManagerService managerService = new ManagerService();
	private String language = "en";

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		language = ((ResourceBundle) session.getAttribute("ResourceBundle"))
				.getLocale().getLanguage();

		if (request.getParameter("edit_accept") != null) {
			Admin user = (Admin) session.getAttribute("user");
			Manager manager = new Manager();
			long managerId = toLong(request.getParameter("edit_id"));
			manager.setAdminId(user.getId());
			manager.setId(managerId);
			managerService.update(manager);
		}
		if (request.getParameter("edit_block") != null) {
			long hotelId = toLong(request.getParameter("edit_id"));
			new HotelService().addToBlackList(hotelId);
		}
		request.setAttribute("managers",
				managerService.getNewApplications(language));
		forward(url, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		language = ((ResourceBundle) session.getAttribute("ResourceBundle"))
				.getLocale().getLanguage();

		if (request.getParameter("booking_confirm") != null) {
			String[] checked = request.getParameterValues("confirmed");
			if (checked != null) {
				Admin user = (Admin) session.getAttribute("user");
				Manager manager = new Manager();
				for (String str : checked) {
					long managerId = toLong(str);
					manager.setAdminId(user.getId());
					manager.setId(managerId);
					managerService.update(manager);
				}

			}
		}

		request.setAttribute("managers",
				managerService.getNewApplications(language));
		forward(url, request, response);
	}
}
