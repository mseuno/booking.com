package com.epam.lab.controller.impl.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Admin;
import com.epam.lab.service.AdminService;
import com.epam.lab.service.LoginService;
import com.epam.lab.utils.Validator;

public class AdminNewAdminController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/admin_new_admin.jsp";
	private AdminService adminService = new AdminService();
	private LoginService loginService = new LoginService();

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

		Admin admin = new Admin();
		String email = request.getParameter("email").toLowerCase();
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date date = new Date();

		admin.setEmail(email);
		admin.setPassword(loginService.generateHash(admin.getEmail(), password));
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setRegistrationDate(new java.sql.Date(date.getTime()));

		String message;
		if (Validator.USER_EMAIL.validate(admin.getEmail()) == false) {
			message = "Input correct e-mail.";
		} else if (Validator.USER_PASSWORD.validate(request
				.getParameter("password")) == false) {
			message = "Input correct password.";
		} else {
			message = adminService.registerNewAdmin(admin);
		}
		if (message == null) {
			message = "Registration complete, sign in:";
			request.setAttribute("message", message);
			request.setAttribute("admin_login", admin.getEmail());
			response.sendRedirect("adminlogin");
			return;
		} else {
			request.setAttribute("message", message);
			request.setAttribute("userlogin", request.getParameter("email"));
			request.setAttribute("userfirstName",
					request.getParameter("firstName"));
			request.setAttribute("userlastName",
					request.getParameter("lastName"));

		}

		forward(URL, request, response);
		System.out
				.println(email + password + firstName + lastName + " " + date);
	}

}
