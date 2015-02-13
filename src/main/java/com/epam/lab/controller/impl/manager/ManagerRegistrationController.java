package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Manager;
import com.epam.lab.service.LoginService;
import com.epam.lab.service.ManagerService;
import com.epam.lab.utils.Validator;

public class ManagerRegistrationController extends DispatcherController {

	private final String URL = "/pages/extranet/registration/managerregistration.jsp";

	private LoginService loginService = new LoginService();
	private ManagerService managerService = new ManagerService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		Manager manager = new Manager();

		manager.setFirstName(Validator.DELETE_FORBIDDEN_CHARACTERS
				.deleteForbiddenCharacter(request.getParameter("firstName")));
		manager.setLastName(Validator.DELETE_FORBIDDEN_CHARACTERS
				.deleteForbiddenCharacter(request.getParameter("lastName")));
		manager.setEmail(request.getParameter("email").toLowerCase());
		manager.setPassword(loginService.generateHash(manager.getEmail(),
				request.getParameter("password")));
		manager.setRegistrationDate(new Date(System.currentTimeMillis()));
		manager.setPhone(request.getParameter("phone"));

		String message = null;
		if (Validator.USER_EMAIL.validate(manager.getEmail()) == false) {
			message = "Input correct e-mail.";
		} else if (Validator.USER_PASSWORD.validate(request
				.getParameter("password")) == false) {
			message = "Input correct password.";
		} else if (Validator.USER_PHONE.validate(manager.getPhone()) == false) {
			message = "Input correct phone.";
		} else {
			message = managerService.registerNewManager(manager);
		}

		if (message == null) {

			HttpSession session = request.getSession();
			message = "Registration complete, sign in:";
			session.setAttribute("message", message);
			session.setAttribute("manager_login", manager.getEmail());
			response.sendRedirect("managerlogin");
			return;
		} else {
			request.setAttribute("message", message);
			request.setAttribute("user_login", request.getParameter("email"));
			request.setAttribute("user_firstName",
					request.getParameter("firstName"));
			request.setAttribute("user_lastName",
					request.getParameter("lastName"));
			request.setAttribute("phone", request.getParameter("phone"));

		}
		forward(URL, request, response);
	}

}
