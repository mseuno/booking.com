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
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Room;
import com.epam.lab.model.helper.RoomInfo;
import com.epam.lab.service.RoomService;

public class ManagerAddNewRoomController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/add_new_room.jsp";

	private RoomService roomService = new RoomService();
	private String language = "en";

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		if (session.getAttribute("ManagerAddNewRoom_page_language") == null) {
			init(servletContext, request, response);
		}
		language = (String) session
				.getAttribute("ManagerAddNewRoom_page_language");
		List<Room> rooms = roomService.readByHotelId(hotel.getId(), language);
		request.setAttribute("rooms", rooms);

		if (request.getParameter("edit_room") != null
				&& request.getParameter("edit_room").equals("update")) {
			Long roomId = toLong(request.getParameter("edit_room_id"));
			Room room = roomService.getFullRoom(roomId, language);
			session.setAttribute("room", room);
			request.setAttribute("update", "true");

		}

		if (request.getParameter("deleteApartment") != null) {
			roomService.deleteAppartment(toLong(request
					.getParameter("deleteApartment")));
			rooms = roomService.readByHotelId(hotel.getId(),
					(String) session.getAttribute("language"));
			session.setAttribute("selectedRoomID", rooms.get(0).getId());
			forward("editrooms", request, response);
			return;
		}

		request.setAttribute("hotel", hotel);
		request.setAttribute("id", request.getParameter("edit_room_id"));

		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		language = (String) session
				.getAttribute("ManagerAddNewRoom_page_language");
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		if (request.getParameter("addNewapArtment") != null) {
			Room newRoom = new Room();
			RoomInfo newRoomInfo = new RoomInfo();
			newRoomInfo.setName(request.getParameter("room_name"));
			newRoomInfo.setLocaleId("en");
			newRoom.setRoomInfo(newRoomInfo);
			newRoom.setHotelId(hotel.getId());
			newRoom.setCost(toLong(request.getParameter("room_cost")));
			newRoom.setNumberOfRooms(toInt(request
					.getParameter("room_number_of_rooms")));
			newRoom.setNumberOfPeople(toInt(request
					.getParameter("room_number_of_people")));
			String result = roomService.createFullRoom(newRoom);
			if (result == null) {
				forward("editrooms", request, response);
				return;
			} else {
				request.setAttribute("message", result);
				forward(URL, request, response);
				return;
			}
		}

		if (request.getParameter("updateApartment") != null) {
			Room room = (Room) session.getAttribute("room");
			room.getRoomInfo().setRoomId(room.getId());
			room.getRoomInfo().setName(request.getParameter("room_name"));
			room.getRoomInfo().setLocaleId(request.getParameter("language"));
			room.setCost(toLong(request.getParameter("room_cost")));
			room.setNumberOfPeople(toInt(request
					.getParameter("room_number_of_people")));
			room.setNumberOfRooms(toInt(request
					.getParameter("room_number_of_rooms")));
			roomService.updateRoom(room);
			session.setAttribute("room", room);
		}

		if (request.getParameter("selectRoom") != null) {
			if (!request.getParameter("selectRoom").equals(
					session.getAttribute("selectedRoomID"))) {
				session.setAttribute("selectedRoomID",
						request.getParameter("selectRoom"));
				Room room = roomService.getFullRoom(
						toLong(request.getParameter("selectRoom")), language);
				session.setAttribute("room", room);
			}
		}

		if (request.getParameter("language") != null) {
			if (!language.equals(request.getParameter("language"))) {
				session.setAttribute("ManagerAddNewRoom_page_language",
						request.getParameter("language"));
				Long roomId = toLong(request.getParameter("edit_room_id"));
				Room room = (Room) session.getAttribute("room");
				language = request.getParameter("language");
				room.setRoomInfo(roomService.selectRoomInfo(roomId,
						request.getParameter("language")));
				session.setAttribute("room", room);
			}
		}

		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("rooms",
				roomService.readByHotelId(hotel.getId(), language));
		request.setAttribute("language", language);
		request.setAttribute("selectedRoomID",
				session.getAttribute("selectedRoomID"));
		request.setAttribute("hotel", hotel);
		request.setAttribute("update", "true");

		request.setAttribute("id", request.getParameter("edit_room_id"));
		forward(URL, request, response);
	}

	private void init(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		language = ((ResourceBundle) session.getAttribute("ResourceBundle"))
				.getLocale().getLanguage();
		session.setAttribute("ManagerAddNewRoom_page_language", language);

	}
}
