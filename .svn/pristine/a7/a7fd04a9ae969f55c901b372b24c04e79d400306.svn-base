package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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

public class ManagerHomeController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/home.jsp";
	private BookingService bookingService = new BookingService();
	private List<Booking> bookings;
	private String message;

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession(false);
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");

		Hotel hotel = (Hotel) session.getAttribute("hotel");

		bookings = bookingService.selectUnconfirmedBookingFullByHotelId(
				((Manager) session.getAttribute("user")).getHotelId(), bundle
						.getLocale().getLanguage());
		message = "Unconfirmed Booking List";

		// ----якщо вийшла дата замовлення і його статус підтвердженний але
		// замовлення не виконано то замовленню встановлюється статус скасовано
		for (Booking booking : bookings) {
			Date date = new Date();
			if (date.after(booking.getBeginDate())) {
				booking.setStatus(3);
				bookingService.updateBooking(booking);
			}
		}

		bookings = bookingService.selectUnconfirmedBookingFullByHotelId(
				((Manager) session.getAttribute("user")).getHotelId(), bundle
						.getLocale().getLanguage());

		// -----------------------------------------------------------------------------------------------------------------------------------------

		if (request.getParameter("edit_confirm") != null) {
			bookings = bookingService.selectUnconfirmedBookingFullByHotelId(
					((Manager) session.getAttribute("user")).getHotelId(),
					bundle.getLocale().getLanguage());
			long bookingId = toLong(request.getParameter("edit_id"));
			for (Booking booking : bookings) {
				if (bookingId == booking.getId()) {
					booking.setStatus(2);
					bookingService.updateBooking(booking);
				}
			}
			bookings = bookingService.selectUnconfirmedBookingFullByHotelId(
					((Manager) session.getAttribute("user")).getHotelId(),
					bundle.getLocale().getLanguage());
			message = "Unconfirmed Booking List";
		}

		if (request.getParameter("edit_denied") != null) {
			bookings = bookingService.selectUnconfirmedBookingFullByHotelId(
					((Manager) session.getAttribute("user")).getHotelId(),
					bundle.getLocale().getLanguage());
			long bookingId = toLong(request.getParameter("edit_id"));
			for (Booking booking : bookings) {
				if (bookingId == booking.getId()) {
					booking.setStatus(3);
					bookingService.updateBooking(booking);
				}
			}
			bookings = bookingService.selectUnconfirmedBookingFullByHotelId(
					((Manager) session.getAttribute("user")).getHotelId(),
					bundle.getLocale().getLanguage());
			message = "Unconfirmed Booking List";
		}

		if (request.getParameter("edit_confirm_confirmed") != null) {
			bookings = bookingService.selectConfirmedBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			long bookingId = toLong(request.getParameter("edit_id"));
			for (Booking booking : bookings) {
				if (bookingId == booking.getId()) {
					booking.setStatus(0);
					bookingService.updateBooking(booking);
				}
			}
			bookings = bookingService.selectConfirmedBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			message = "Confirmed Booking List";
		}

		if (request.getParameter("edit_denied_confirmed") != null) {
			bookings = bookingService.selectConfirmedBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			long bookingId = toLong(request.getParameter("edit_id"));
			for (Booking booking : bookings) {
				if (bookingId == booking.getId()) {
					booking.setStatus(3);
					bookingService.updateBooking(booking);
				}
			}
			bookings = bookingService.selectConfirmedBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			message = "Confirmed Booking List";
		}

		request.setAttribute("message", message);
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

		if (request.getParameter("booking_un_confirmed_list") != null) {
			bookings = bookingService.selectUnconfirmedBookingFullByHotelId(
					((Manager) session.getAttribute("user")).getHotelId(),
					bundle.getLocale().getLanguage());
			message = "Unconfirmed Booking List";
		}

		if (request.getParameter("booking_confirmed_list") != null) {

			bookings = bookingService.selectConfirmedBookingFullByManagerId(
					((Manager) session.getAttribute("user")).getId(), bundle
							.getLocale().getLanguage());
			message = "Confirmed Booking List";
		}

		request.setAttribute("bookings", bookings);
		request.setAttribute("message", message);
		request.setAttribute("hotel", session.getAttribute("hotel"));
		forward(URL, request, response);

	}

}
