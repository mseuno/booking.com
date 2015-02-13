package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.controller.impl.manager.ManagerAdminRequestController.Status;
import com.epam.lab.model.Hotel;
import com.epam.lab.service.ManagerService;

public class ManagerMessageListController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/message_list.jsp";
	private ManagerService managerService = new ManagerService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();

		Hotel hotel = (Hotel) session.getAttribute("hotel");

		request.setAttribute("hotel", hotel);
		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("messageList", managerService
				.getImportantSendMessage(Status.SEND.ordinal(),
						Status.IMPORTANT.ordinal()));

		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();

		Hotel hotel = (Hotel) session.getAttribute("hotel");

		request.setAttribute("hotel", hotel);

		if (request.getParameter("importantSend") != null) {
			request.setAttribute(
					"messageList",
					managerService.getImportantSendMessage(
							Status.SEND.ordinal(), Status.IMPORTANT.ordinal()));
		}

		if (request.getParameter("dismit") != null) {
			request.setAttribute("messageList",
					managerService.getMessageByStatus(Status.DISMIT.ordinal()));
		}

		if (request.getParameter("accept") != null) {
			request.setAttribute("messageList",
					managerService.getMessageByStatus(Status.ACCEPT.ordinal()));
		}

		request.setAttribute("hotel", hotel);
		request.setAttribute("immURL", hotel.getLogo());

		forward(URL, request, response);

	}

}
