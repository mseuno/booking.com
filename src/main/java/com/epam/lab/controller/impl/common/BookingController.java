package com.epam.lab.controller.impl.common;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Booking;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.User;
import com.epam.lab.model.helper.BookingRoom;
import com.epam.lab.service.BookingService;
import com.epam.lab.service.HotelService;
import com.epam.lab.service.UserService;
import com.epam.lab.utils.MD5Encrypter;
import com.epam.lab.utils.RoomAccessibility;
import com.epam.lab.utils.SearchEngine;
import com.epam.lab.utils.SearchParameters;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BookingController extends DispatcherController {

	// private static final Logger LOG =
	// Logger.getLogger(BookingController.class);
	//
	// {
	// PropertyConfigurator.configure(getClass().getResourceAsStream(
	// "/config/log4j.properties"));
	// }

	private static final String AVAILABLE_ROOMS_FRAGMENT = "/pages/booking-fragments/available_rooms_fragment.jsp";
	private static final String RESULT_FRAGMENT = "/pages/booking-fragments/result_fragment.jsp";
	private HotelService hotelService = new HotelService();
	private BookingService bookingService = new BookingService();
	private UserService userService = new UserService();

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {
	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {
		String action = request.getParameter("action");
		String hotelId = request.getParameter("hotel_id");
		String dateFrom = request.getParameter("date_from");
		String dateTo = request.getParameter("date_to");
		String totalCost = request.getParameter("totalCost");
		String rooms = request.getParameter("rooms");

		String userName = request.getParameter("name");
		String userSurname = request.getParameter("surename");
		String userMail = request.getParameter("mail");
		String userPhone = request.getParameter("phone");

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar beginDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();

		beginDate.setTime(dateFormat.parse(dateFrom));
		endDate.setTime(dateFormat.parse(dateTo));

		if (action == null && hotelId == null && dateFrom == null
				&& dateTo == null) {
			request.setAttribute("success", false);
			forward(RESULT_FRAGMENT, request, response);
		}

		HttpSession session = request.getSession();
		User user = null;
		if (session.getAttribute("user") != null
				&& session.getAttribute("user") instanceof User) {
			user = (User) session.getAttribute("user");
		}

		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");

		Hotel hotel = hotelService.selectHotelByHotelId(toLong(hotelId), bundle
				.getLocale().getLanguage());

		if (action.equals("getRooms")) {
			getAvailableRooms(request, response, hotel, beginDate, endDate,
					user);
		} else if (action.equals("book")) {
			if (bookingAction(hotelId, totalCost, rooms, userName, userSurname,
					userMail, userPhone, beginDate, endDate, user, hotel)) {
				request.setAttribute("success", true);
				forward(RESULT_FRAGMENT, request, response);
			} else {
				request.setAttribute("success", false);
				forward(RESULT_FRAGMENT, request, response);
			}
		} else {
			request.setAttribute("success", false);
			forward(RESULT_FRAGMENT, request, response);
		}
	}

	private boolean bookingAction(String hotelId, String totalCost,
			String rooms, String userName, String userSurname, String userMail,
			String userPhone, Calendar beginDate, Calendar endDate, User user,
			Hotel hotel) {
		if (totalCost == null && rooms == null) {
			return false;
		}

		if (user != null) {
			return createBooking(rooms, toLong(hotelId), user.getId(), hotel,
					beginDate, endDate, toLong(totalCost));
		} else {
			return createBookingForUnregisteredUser(hotelId, totalCost, rooms,
					userName, userSurname, userMail, userPhone, beginDate,
					endDate, hotel);
		}
	}

	private boolean createBookingForUnregisteredUser(String hotelId,
			String totalCost, String rooms, String userName,
			String userSurname, String userMail, String userPhone,
			Calendar beginDate, Calendar endDate, Hotel hotel) {
		User user = getUserObject(userName, userSurname, userMail, userPhone);
		if (user != null) {
			Long userId = userService.getUserIdForBooking(user);
			if (userId != null) {
				return createBooking(rooms, toLong(hotelId), userId, hotel,
						beginDate, endDate, toLong(totalCost));

			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private User getUserObject(String userName, String userSurname,
			String userMail, String userPhone) {
		User user = null;

		// TODO add additional check
		if (userName != null && userSurname != null && userMail != null
				&& userPhone != null) {
			user = new User();
			user.setFirstName(userName);
			user.setLastName(userSurname);
			user.setPassword(MD5Encrypter.encrypt(userMail + userName
					+ userSurname));
			user.setEmail(userMail);
			user.setPhone(userPhone);
			user.setRegistered(false);
			user.setBlocked(false);
			user.setRegistrationDate(new Date(Calendar.getInstance()
					.getTimeInMillis()));
		}
		return user;
	}

	private boolean createBooking(String rooms, long parsedHotelId,
			long userId, Hotel hotel, Calendar beginDate, Calendar endDate,
			long parsedTotalCost) {

		boolean result = false;

		Long bookingId = bookingService.insertBooking(getBookingObject(
				parsedHotelId, parsedTotalCost, userId, beginDate, endDate));

		if (bookingId != null) {

			List<BookingRoom> bookingRooms = new ArrayList<BookingRoom>();

			JsonElement element = new JsonParser().parse(rooms);
			JsonArray array = element.getAsJsonArray();
			for (JsonElement arrayElement : array) {
				JsonObject jsonObject = arrayElement.getAsJsonObject();

				BookingRoom bookingRoom = getBookingRoomObject(parsedHotelId,
						bookingId, jsonObject.get("id").getAsLong(), jsonObject
								.get("cost").getAsLong(),
						jsonObject.get("count").getAsInt());

				bookingRooms.add(bookingRoom);
			}

			SearchParameters parameters = new SearchParameters();
			parameters.setBeginDate(beginDate);
			parameters.setEndDate(endDate);
			Map<Long, RoomAccessibility> availableRooms = new SearchEngine()
					.getRoomsAccessibilities(hotel, parameters);

			result = bookingService.insertBookingRooms(availableRooms,
					bookingRooms);
		}
		return result;
	}

	private BookingRoom getBookingRoomObject(long parsedHotelId,
			Long bookingId, Long roomId, Long roomCost, int roomCount) {
		BookingRoom bookingRoom = new BookingRoom();
		bookingRoom.setBookingId(bookingId);
		bookingRoom.setRoomId(roomId);
		bookingRoom.setCost(roomCost);
		bookingRoom.setHotelId(parsedHotelId);
		bookingRoom.setNumberOfRooms(roomCount);
		return bookingRoom;
	}

	private Booking getBookingObject(long prsedHotelId, long parsedTotalCost,
			long userId, Calendar beginDate, Calendar endDate) {
		Booking booking = new Booking();
		booking.setUserId(userId);
		booking.setHotelId(prsedHotelId);
		booking.setBeginDate(new Date(beginDate.getTimeInMillis()));
		booking.setEndDate(new Date(endDate.getTimeInMillis()));
		booking.setTotalCost(parsedTotalCost);
		booking.setStatus(1);
		return booking;
	}

	private void getAvailableRooms(HttpServletRequest request,
			HttpServletResponse response, Hotel hotel, Calendar beginDate,
			Calendar endDate, User user) throws IOException, ServletException {
		SearchParameters parameters = new SearchParameters();
		parameters.setBeginDate(beginDate);
		parameters.setEndDate(endDate);

		hotelService.getAvailableRoomsForBooking(hotel, parameters);

		if (user != null) {
			request.setAttribute("showUserInfo", false);
		} else {
			request.setAttribute("showUserInfo", true);
		}

		request.setAttribute("hotel", hotel);
		forward(AVAILABLE_ROOMS_FRAGMENT, request, response);
	}

}
