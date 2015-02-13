package com.epam.lab.controller.impl.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Admin;
import com.epam.lab.service.AdminService;
import com.epam.lab.service.LoginService;
import com.epam.lab.utils.Validator;

public class AdminProfileController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/profile.jsp";

	private AdminService adminService = new AdminService();
	private LoginService loginService = new LoginService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		// TODO Auto-generated method stub

		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		if (request.getParameter("refresh") != null) {
			forward(URL, request, response);
			return;
		}

		String message = null;
		Admin admin = (Admin) session.getAttribute("user");
		String pass = request.getParameter("password");
		String email = admin.getEmail();

		String password = loginService.generateHash(email, pass);

		System.out.println(admin.getPassword().equals(password));
		if (Validator.USER_EMAIL.validate(request.getParameter("email")) == false) {
			message = "Input correct e-mail.";
		}

		else if (!admin.getPassword().equals(password)) {

			message = "Incorrect old password";
		}

		if ((!request.getParameter("new_password").isEmpty())
				&& Validator.USER_PASSWORD.validate(request
						.getParameter("new_password"))) {

			admin.setPassword(loginService.generateHash(
					request.getParameter("email"),
					request.getParameter("new_password")));

		}
		if ((!request.getParameter("new_password").isEmpty())
				&& (Validator.USER_PASSWORD.validate(request
						.getParameter("new_password")) == false)) {
			message = "Input correct new password. Password can not contain less than 4 letters";
		}

		if (message == null) {

			admin.setFirstName(request.getParameter("firstName"));
			admin.setLastName(request.getParameter("lastName"));
			admin.setEmail(request.getParameter("email"));

			adminService.updateAdmin(admin);

			message = "changes saved:";
			request.setAttribute("message", message);

			forward(URL, request, response);
			return;

		} else {

			request.setAttribute("message", message);

		}
		forward(URL, request, response);
	}
}
