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
import com.epam.lab.service.LoginService;

public class AdminLoginController extends DispatcherController {

	private final String URL = "/pages/extranet/login/adminlogin.jsp";
	private LoginService loginService = new LoginService();

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

		Admin admin = loginService.loginAdmin(request.getParameter("login"),
				request.getParameter("password"));

		if (admin != null) {
			HttpSession session = request.getSession(false);
			session.setAttribute("user", admin);
			if (session.getAttribute("redirect_url") != null) {
				redirect((String) session.getAttribute("redirect_url"),
						response, context);
			} else {
				redirect("adminhome", response, context);
			}
			return;
		} else {
			request.setAttribute("message", "Check_email/password");
			request.setAttribute("admin_login", request.getParameter("login"));
		}

		forward(URL, request, response);

	}

}
