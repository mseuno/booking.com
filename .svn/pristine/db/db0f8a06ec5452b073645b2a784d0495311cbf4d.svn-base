package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Manager;
import com.epam.lab.model.helper.ManagerMessage;
import com.epam.lab.service.ManagerService;

public class ManagerAdminRequestController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/admin_request.jsp";
	private ManagerService managerService = new ManagerService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		request.setAttribute("hotel", hotel);

		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("type", MessageType.values());
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();

		System.out.println(MessageType.NEW_CITY.ordinal());
		if (request.getParameter("send") != null) {
			StringBuilder builder = new StringBuilder();
			ManagerMessage message = new ManagerMessage();
			message.setManagerId(((Manager) session.getAttribute("user"))
					.getId());
			builder.append(request.getParameter("text_area"));
			message.setType(Integer.parseInt(request.getParameter("type")));
			message.setStatus(Status.SEND.ordinal());
			message.setMessage(builder.toString());
			managerService.sendRequest(message);
		}

		Hotel hotel = (Hotel) session.getAttribute("hotel");
		request.setAttribute("hotel", hotel);
		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("type", MessageType.values());
		forward(URL, request, response);

	}

	enum MessageType {
		NEW_COUNTRY, NEW_REGION, NEW_CITY, NEW_STREET, ERROR, ELSE;
	};

	enum Status {
		SEND, ACCEPT, DISMIT, IMPORTANT
	}
}
