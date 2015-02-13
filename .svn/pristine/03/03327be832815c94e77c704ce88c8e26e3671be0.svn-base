package com.epam.lab.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.User;
import com.epam.lab.service.UserService;
import com.google.gson.JsonObject;

public class FavoriteController extends DispatcherController {

	private UserService userService = new UserService();

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		String action = request.getParameter("action");
		String id = request.getParameter("id");

		User user = (User) request.getSession().getAttribute("user");

		JsonObject result = new JsonObject();

		if (action == null || id == null) {
			return;
		}

		boolean updateState = false;
		if (action.equals("remove")) {
			updateState = userService.deleteHotelFromFavorite(user.getId(),
					toLong(id));
		} else if (action.equals("add")) {
			updateState = userService
					.setFavoriteHotel(user.getId(), toLong(id));
		}

		result.addProperty("state", updateState);

		PrintWriter printWriter = response.getWriter();
		printWriter.print(result);
		printWriter.flush();
	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

	}

}
