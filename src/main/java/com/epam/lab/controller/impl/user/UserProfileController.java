package com.epam.lab.controller.impl.user;

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
import com.epam.lab.model.User;
import com.epam.lab.service.LoginService;
import com.epam.lab.service.UserService;
import com.epam.lab.utils.Validator;

public class UserProfileController extends DispatcherController {

	private final String URL = "/pages/user/actions/user_profile.jsp";

	private LoginService loginService = new LoginService();
	private UserService userService = new UserService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		// TODO Auto-generated method stub
		request.setAttribute("userCabinetState", true);

		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		request.setAttribute("userCabinetState", true);

		if (request.getParameter("refresh") != null) {
			forward(URL, request, response);
			return;
		}

		String message = null;
		User user = (User) session.getAttribute("user");

		String pass = request.getParameter("password");
		String email = user.getEmail();

		String password = loginService.generateHash(email, pass);
		Date date = new Date();
		Timestamp lastUpdate = new Timestamp(date.getTime());

		if (Validator.USER_EMAIL.validate(request.getParameter("email")) == false) {
			message = "Input correct e-mail.";
		}

		else if (!user.getPassword().equals(password)) {

			message = "Incorrect old password";
		}
		if ((!request.getParameter("new_password").isEmpty())
				&& Validator.USER_PASSWORD.validate(request
						.getParameter("new_password"))) {

			user.setPassword(loginService.generateHash(
					request.getParameter("email"),
					request.getParameter("new_password")));

		}

		if ((!request.getParameter("new_password").isEmpty())
				&& (Validator.USER_PASSWORD.validate(request
						.getParameter("new_password")) == false)) {
			message = "Input correct new password.";
		}

		if (message == null) {

			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			user.setPhone(request.getParameter("phone"));
			user.setEmail(request.getParameter("email"));
			user.setLastUpdate(lastUpdate);

			userService.updateUser(user);
			message = "changes saved.";
			request.setAttribute("message", message);

			forward(URL, request, response);
			return;

		} else {

			request.setAttribute("message", message);

		}
		forward(URL, request, response);
	}

}
