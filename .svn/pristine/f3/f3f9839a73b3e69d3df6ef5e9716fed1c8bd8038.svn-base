package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Booking;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Manager;
import com.epam.lab.service.BookingService;

public class ManagerBookingController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/booking.jsp";
	private BookingService bookingService = new BookingService();
	private List<Booking> bookings;

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession(false);
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");

		bookings = bookingService.selectBookingFullByManagerId(
				((Manager) session.getAttribute("user")).getId(), bundle
						.getLocale().getLanguage());

		Hotel hotel = (Hotel) session.getAttribute("hotel");
		// Hotel hotel =
		// hotelService.selectHotelByManagerId(bundle.getLocale().getLanguage(),(Manager)
		// session.getAttribute("user"));

		// session.setAttribute("hotel", hotel);

		// if (request.getParameter("edit_done") != null) {
		// long bookingId = toLong(request.getParameter("edit_id"));
		// for (Booking booking : bookings) {
		// if (bookingId == booking.getId()) {
		// booking.setStatus(0);
		// bookingService.updateBooking(booking);
		// }
		// }
		// }
		//
		// if (request.getParameter("edit_denied") != null) {
		// long bookingId = toLong(request.getParameter("edit_id"));
		// for (Booking booking : bookings) {
		// if (bookingId == booking.getId()) {
		// booking.setStatus(3);
		// bookingService.updateBooking(booking);
		// }
		// }
		// }

		bookings = bookingService.selectBookingFullByManagerId(
				((Manager) session.getAttribute("user")).getId(), bundle
						.getLocale().getLanguage());

		request.setAttribute("bookings", bookings);
		request.setAttribute("hotel", session.getAttribute("hotel"));
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession(false);
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");
		// List<Booking> bookings =
		// bookingService.selectBookingFullByManagerId(((Manager)
		// session.getAttribute("user")).getId(),
		// bundle.getLocale().getLanguage());

		request.setAttribute("bookings", bookings);
		request.setAttribute("hotel", session.getAttribute("hotel"));

		if (request.getParameter("all") != null) {
			bookings = bookingService.selectBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			request.setAttribute("bookings", bookings);
		}

		if (request.getParameter("done") != null) {
			bookings = bookingService.selectDoneBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			request.setAttribute("bookings", bookings);
		}

		if (request.getParameter("denied") != null) {
			bookings = bookingService.selectDeniedBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			request.setAttribute("bookings", bookings);
		}

		Hotel hotel = (Hotel) session.getAttribute("hotel");
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}
}
