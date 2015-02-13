package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Hotel;
import com.epam.lab.service.RoomService;

public class ManagerEditRoomsController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/edit_rooms.jsp";

	private RoomService roomService = new RoomService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		String language = ((ResourceBundle) session
				.getAttribute("ResourceBundle")).getLocale().getLanguage();
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		if (request.getParameter("edit_room_plus") != null) {
			roomService.updateRoomsNumber(
					toLong(request.getParameter("edit_room_id")),
					(toLong(request.getParameter("edit_room_quantity")) + 1));
		}
		if (request.getParameter("edit_room_minus") != null) {
			roomService.updateRoomsNumber(
					toLong(request.getParameter("edit_room_id")),
					(toLong(request.getParameter("edit_room_quantity")) - 1));
		}
		if (request.getParameter("edit_room_delete") != null) {
			roomService.delete(toLong(request.getParameter("edit_room_id")));
		}
		request.setAttribute("rooms",
				roomService.readByHotelId(hotel.getId(), language));
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		String language = ((ResourceBundle) session
				.getAttribute("ResourceBundle")).getLocale().getLanguage();
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		if (request.getParameter("selectRoom") != null) {
			session.setAttribute("selectedRoomID",
					request.getParameter("selectRoom"));
		}

		request.setAttribute("rooms",
				roomService.readByHotelId(hotel.getId(), language));
		request.setAttribute("selectedRoomID",
				session.getAttribute("selectedRoomID"));
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);
	}

}
