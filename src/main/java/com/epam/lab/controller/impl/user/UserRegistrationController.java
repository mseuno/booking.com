package com.epam.lab.controller.impl.user;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.User;
import com.epam.lab.service.LoginService;
import com.epam.lab.service.UserService;
import com.epam.lab.utils.Validator;

public class UserRegistrationController extends DispatcherController {

	private final String URL = "/pages/userregistration.jsp";

	private LoginService loginService = new LoginService();
	private UserService userService = new UserService();

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		User user = new User();

		user.setFirstName(Validator.DELETE_FORBIDDEN_CHARACTERS
				.deleteForbiddenCharacter(request.getParameter("firstName")));
		user.setLastName(Validator.DELETE_FORBIDDEN_CHARACTERS
				.deleteForbiddenCharacter(request.getParameter("lastName")));
		user.setEmail(request.getParameter("email").toLowerCase());
		user.setPassword(loginService.generateHash(user.getEmail(),
				request.getParameter("password")));
		user.setRegistrationDate(new Date(System.currentTimeMillis()));
		user.setRegistered(true);
		user.setBlocked(false);

		String message = new String();
		if (Validator.USER_EMAIL.validate(user.getEmail()) == false) {
			message = "Input correct e-mail.";
		} else {

			message = userService.registerNewUser(user);
			if (message == null) {
				HttpSession session = request.getSession(false);
				userService.registerNewUser(user);
				message = "Registration complete, sign in:";
				session.setAttribute("message", message);
				session.setAttribute("user_login", user.getEmail());
				response.sendRedirect("userlogin");
				return;
			} else {
				request.setAttribute("message", message);
				request.setAttribute("user_login",
						request.getParameter("email"));
				request.setAttribute("user_firstName",
						request.getParameter("firstName"));
				request.setAttribute("user_lastName",
						request.getParameter("lastName"));

			}

		}
		forward(URL, request, response);
	}

}
