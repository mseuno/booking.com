package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Manager;
import com.epam.lab.service.LoginService;
import com.epam.lab.service.ManagerService;
import com.epam.lab.utils.Validator;

public class ManagerProfileController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/profile.jsp";

	private ManagerService managerService = new ManagerService();
	private LoginService loginService = new LoginService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		request.setAttribute("hotel", hotel);
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		request.setAttribute("hotel", hotel);

		if (request.getParameter("refresh") != null) {

			request.setAttribute("immURL", hotel.getLogo());
			forward(URL, request, response);
			return;
		}

		String message = null;
		Manager manager = (Manager) session.getAttribute("user");

		String pass = request.getParameter("password");
		String email = manager.getEmail();

		String password = loginService.generateHash(email, pass);
		Date date = new Date();
		Timestamp lastUpdate = new Timestamp(date.getTime());

		if (Validator.USER_EMAIL.validate(request.getParameter("email")) == false) {
			message = "Input correct e-mail.";
		}

		else if (!manager.getPassword().equals(password)) {

			message = "Incorrect old password";
		}

		if ((!request.getParameter("new_password").isEmpty())
				&& Validator.USER_PASSWORD.validate(request
						.getParameter("new_password"))) {
			manager.setPassword(loginService.generateHash(
					request.getParameter("email"),
					request.getParameter("new_password")));
		}

		if ((!request.getParameter("new_password").isEmpty())
				&& (Validator.USER_PASSWORD.validate(request
						.getParameter("new_password")) == false)) {
			message = "Input correct new password. Password can not contain less than 4 letters";
		}

		if (message == null) {

			manager.setFirstName(request.getParameter("firstName"));
			manager.setLastName(request.getParameter("lastName"));
			manager.setPhone(request.getParameter("phone"));
			manager.setEmail(request.getParameter("email"));
			manager.setLastUpdate(lastUpdate);

			managerService.update(manager);
			message = "changes saved.";
			request.setAttribute("message", message);

			forward(URL, request, response);
			return;

		} else {

			request.setAttribute("message", message);

		}
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}

}
