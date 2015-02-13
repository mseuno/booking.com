package com.epam.lab.controller.impl.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.User;
import com.epam.lab.service.UserService;

public class UserFavoritesController extends DispatcherController {

	private final String URL = "/pages/user/actions/favorites.jsp";

	private UserService userService = new UserService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		request.setAttribute("userCabinetState", true);

		HttpSession session = request.getSession();
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");

		request.setAttribute("UserFavorites_favorites", userService
				.selectFavorites(
						toLong(((User) session.getAttribute("user")).getId()),
						bundle));
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		request.setAttribute("userCabinetState", true);

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		if (request.getParameter("hotel_id") != null) {
			String hotelId = request.getParameter("hotel_id");
			System.out.println(hotelId);
			userService.deleteHotelFromFavorite(user.getId(), toLong(hotelId));

		}
		executeGet(servletContext, request, response);
	}

}
