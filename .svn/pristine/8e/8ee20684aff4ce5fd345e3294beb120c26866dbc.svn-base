package com.epam.lab.controller.impl.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.helper.ManagerMessage;
import com.epam.lab.service.AdminService;

public class AdminManagerResponsController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/manager_respond.jsp";
	private AdminService adminService = new AdminService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();

		if (request.getParameter("edit_accept") != null) {
			ManagerMessage message = new ManagerMessage();
			message.setStatus(1);
			message.setId(toLong(request.getParameter("edit_id")));
			adminService.updateMessage(message);
		}
		if (request.getParameter("edit_dismit") != null) {
			ManagerMessage message = new ManagerMessage();
			message.setStatus(2);
			message.setId(toLong(request.getParameter("edit_id")));
			adminService.updateMessage(message);
		}
		if (request.getParameter("edit_important") != null) {
			ManagerMessage message = new ManagerMessage();
			message.setStatus(3);
			message.setId(toLong(request.getParameter("edit_id")));
			adminService.updateMessage(message);
		}

		if (session.getAttribute("status") == null) {
			List<ManagerMessage> messages = adminService.readManagerMessages();
			session.setAttribute("manager_message_list", messages);
		} else {
			int status = Integer.parseInt(session.getAttribute("status")
					.toString());
			List<ManagerMessage> messages = adminService
					.readManagerMessages(status);
			session.setAttribute("manager_message_list", messages);
		}
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		if (request.getParameter("all") != null) {
			List<ManagerMessage> messages = adminService.readManagerMessages();
			session.setAttribute("manager_message_list", messages);
			session.removeAttribute("status");
		}
		if (request.getParameter("accept") != null) {
			List<ManagerMessage> messages = adminService.readManagerMessages(1);
			session.setAttribute("manager_message_list", messages);
			session.setAttribute("status", 1);
		}
		if (request.getParameter("dismit") != null) {
			List<ManagerMessage> messages = adminService.readManagerMessages(2);
			session.setAttribute("manager_message_list", messages);
			session.setAttribute("status", 2);
		}
		if (request.getParameter("important") != null) {
			List<ManagerMessage> messages = adminService.readManagerMessages(3);
			session.setAttribute("manager_message_list", messages);
			session.setAttribute("status", 3);
		}
		if (request.getParameter("new") != null) {
			List<ManagerMessage> messages = adminService.readManagerMessages(0);
			session.setAttribute("manager_message_list", messages);
			session.setAttribute("status", 0);
		}

		request.setAttribute("type", MessageType.values());
		forward(URL, request, response);
	}

	enum MessageType {
		NEW_COUNTRY, NEW_REGION, NEW_CITY, NEW_STREET, ERROR, ELSE;
	};

	enum Status {
		SEND, ACCEPT, DISMIT, IMPORTANT
	};
}
