package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Room;
import com.epam.lab.service.RoomService;

public class ManagerNewBookingController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/new_booking.jsp";
	private RoomService roomService = new RoomService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession(false);
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		request.setAttribute("hotel", hotel);

		List<Room> rooms = roomService.readByHotelId(hotel.getId(), "en");
		if (rooms != null) {
			request.setAttribute("rooms", rooms);
		}

		request.setAttribute("showAvailableRooms", false);
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession(false);
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		request.setAttribute("hotel", hotel);

		List<Room> rooms = roomService.readByHotelId(hotel.getId(), "en");
		if (rooms != null) {
			request.setAttribute("rooms", rooms);
		}

		String[] checked = request.getParameterValues("checkedRows");
		String message = "";
		if (checked != null) {
			for (Room room : rooms) {
				for (String string : checked) {
					if (room.getId() == Long.parseLong(string)) {
						message += " room press	ID : " + room.getId() + ";	";
					}
				}
			}

		}

		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("message", message);
		forward(URL, request, response);

	}

}
