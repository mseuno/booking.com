package com.epam.lab.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.epam.lab.model.Booking;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Room;
import com.epam.lab.model.helper.BookingRoom;
import com.epam.lab.service.BookingService;
import com.epam.lab.service.HotelService;

public class SearchEngine {

	private HotelService hotelService = new HotelService();
	private BookingService bookingService = new BookingService();

	public List<Hotel> searchByRegionId(SearchParameters searchParameters) {
		List<Hotel> hotelList = new LinkedList<Hotel>();
		hotelList = hotelService.selectHotelByRegionId(
				searchParameters.getRegionId(), searchParameters.getLocale());
		Hotel hotel = new Hotel();

		Iterator<Hotel> hotelIterator = hotelList.iterator();
		while (hotelIterator.hasNext()) {
			hotel = hotelIterator.next();
			if (hotelIsAccessible(hotel, searchParameters) == false) {
				hotelIterator.remove();
			}
		}

		return hotelList;
	}

	public List<Hotel> searchByCityId(SearchParameters searchParameters) {
		List<Hotel> hotelList = new LinkedList<Hotel>();
		hotelList = hotelService.selectHotelByCityId(
				searchParameters.getCityId(), searchParameters.getLocale());
		Hotel hotel = new Hotel();

		Iterator<Hotel> hotelIterator = hotelList.iterator();
		while (hotelIterator.hasNext()) {
			hotel = hotelIterator.next();
			if (hotelIsAccessible(hotel, searchParameters) == false) {
				hotelIterator.remove();
			}
		}

		return hotelList;
	}

	public Hotel searchByHotelId(SearchParameters searchParameters) {
		Hotel hotel = new Hotel();
		hotel = hotelService.selectHotelByHotelId(
				searchParameters.getHotelId(), searchParameters.getLocale());

		if (hotelIsAccessible(hotel, searchParameters)) {
			return hotel;
		} else {
			return null;
		}

	}

	public List<Hotel> searchByName(SearchParameters searchParameters) {
		return null;
	}

	public Boolean hotelIsAccessible(Hotel hotel,
			SearchParameters searchParameters) {

		Map<Long, RoomAccessibility> roomMap = getRoomsAccessibilities(hotel,
				searchParameters);

		HotelAccessibility hotelAccessibility = new HotelAccessibility();
		boolean result;

		int count;
		for (Room room : hotel.getRooms()) {
			count = roomMap.get(room.getId()).getRoomAccessebility()
					.getNumberOfRooms();
			hotelAccessibility.setNumberOfRooms(hotelAccessibility
					.getNumberOfRooms() + count);
			count = roomMap.get(room.getId()).getRoomAccessebility()
					.getNumberOfPeople();
			hotelAccessibility.setNumberOfPeople(hotelAccessibility
					.getNumberOfPeople() + count);
		}

		if ((hotelAccessibility.getNumberOfPeople() >= searchParameters
				.getNumberOfPeople())
				&& (hotelAccessibility.getNumberOfRooms() >= searchParameters
						.getNumberOfRooms())) {
			result = true;
		} else
			result = false;

		if (hotel.getBlocked()) {
			result = false;
		}
		return result;
	}

	public Map<Long, RoomAccessibility> getRoomsAccessibilities(Hotel hotel,
			SearchParameters searchParameters) {

		if (hotel == null) {
			return null;
		}
		Map<Long, RoomAccessibility> roomMap = new HashMap<Long, RoomAccessibility>();

		if ((searchParameters.getBeginDate() == null)
				|| (searchParameters.getEndDate() == null)) {
			for (Room room : hotel.getRooms()) {
				RoomAccessibility roomAccessibility = new RoomAccessibility();
				roomAccessibility.initiate(Calendar.getInstance(),
						Calendar.getInstance(), room.getNumberOfRooms(),
						room.getNumberOfPeople());
				roomMap.put(room.getId(), roomAccessibility);
			}
		} else {
			if (hotel.getRooms() != null) {
				for (Room room : hotel.getRooms()) {
					RoomAccessibility roomAccessibility = new RoomAccessibility();
					roomAccessibility.initiate(searchParameters.getBeginDate(),
							searchParameters.getEndDate(),
							room.getNumberOfRooms(), room.getNumberOfPeople());
					roomMap.put(room.getId(), roomAccessibility);
				}
			}

			List<Booking> bookingList = new ArrayList<Booking>();
			bookingList = bookingService
					.selectBookingByHotelIdAndDate(hotel.getId(),
							searchParameters.getBeginDate(),
							searchParameters.getEndDate(),
							searchParameters.getLocale());
			for (Booking booking : bookingList) {
				for (BookingRoom bookingRoom : booking.getBookingRoom()) {
					RoomAccessibility roomAccessibility = new RoomAccessibility();
					roomAccessibility = roomMap.get(bookingRoom.getRoomId());
					roomAccessibility.addBooking(
							searchParameters.getBeginDate(),
							searchParameters.getEndDate(),
							bookingRoom.getNumberOfRooms());
					roomMap.put(bookingRoom.getRoomId(), roomAccessibility);
				}
			}
		}

		return roomMap;
	}

}
