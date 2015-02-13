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
import com.epam.lab.service.BookingService;

public class UserHomeController extends DispatcherController {

	private final String URL = "/pages/user/actions/home.jsp";

	private BookingService bookingService = new BookingService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();

		request.setAttribute("userCabinetState", true);

		User user = (User) session.getAttribute("user");
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");

		request.setAttribute("UserHome_home_bookings", bookingService
				.selectBookingByUserId(user.getId(), bundle.getLocale()
						.getLanguage()));

		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		request.setAttribute("userCabinetState", true);
		String bokingId = request.getParameter("booking_id");
		if (bokingId != null) {
			bookingService.cancelBooking(toLong(bokingId));
		}

		executeGet(servletContext, request, response);
	}

}
