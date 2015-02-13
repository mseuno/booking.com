package com.epam.lab.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.epam.lab.dao.impl.BookingDao;
import com.epam.lab.model.Booking;
import com.epam.lab.model.helper.BookingRoom;
import com.epam.lab.utils.RoomAccessibility;

public class BookingService {

	private BookingDao bookingDao = new BookingDao();

	public Long insertBooking(Booking booking) {
		return bookingDao.create(booking);
	}

	public boolean insertBookingRooms(
			Map<Long, RoomAccessibility> availableRooms,
			List<BookingRoom> bookingRooms) {
		return bookingDao.insertBookingRooms(availableRooms, bookingRooms);
	}

	public List<Booking> selectBookingFullByManagerId(long id, String locale) {
		List<Booking> bookings = bookingDao.readFullBookingInfoByManagerId(id);
		for (Booking booking : bookings) {
			booking.setBookingRoom(bookingDao.getBookingRom(booking.getId(),
					locale));
		}
		return bookings;
	}

	public List<Booking> selectDeniedBookingFullByManagerId(long id,
			String locale) {
		List<Booking> bookings = bookingDao
				.readFullDeniedBookingInfoByManagerId(id);
		for (Booking booking : bookings) {
			booking.setBookingRoom(bookingDao.getBookingRom(booking.getId(),
					locale));
		}
		return bookings;
	}

	public List<Booking> selectDoneBookingFullByManagerId(long id, String locale) {
		List<Booking> bookings = bookingDao
				.readFullDoneBookingInfoByManagerId(id);
		for (Booking booking : bookings) {
			booking.setBookingRoom(bookingDao.getBookingRom(booking.getId(),
					locale));
		}
		return bookings;
	}

	public List<Booking> selectConfirmedBookingFullByManagerId(long id,
			String locale) {
		List<Booking> bookings = bookingDao
				.readFullConfirmedBookingInfoByManagerId(id);
		for (Booking booking : bookings) {
			booking.setBookingRoom(bookingDao.getBookingRom(booking.getId(),
					locale));
		}
		return bookings;
	}

	public List<Booking> selectUnconfirmedBookingFullByHotelId(long id,
			String locale) {

		List<Booking> bookings = bookingDao
				.readUnconfirmedFullBookingInfoByHotelId(id);

		for (Booking booking : bookings) {
			booking.setBookingRoom(bookingDao.getBookingRom(booking.getId(),
					locale));
		}

		return bookings;
	}

	public List<Booking> selectBookingByUserId(long id, String locale) {
		List<Booking> result = null;
		if (id != -1) {
			result = bookingDao.readBookingByUserId(id, locale);
			Collections.reverse(result);
		}

		return result;
	}

	public List<Booking> selectBookingHistoryByUserId(long id, String locale) {
		List<Booking> result = null;
		if (id != -1) {
			result = bookingDao.readBookingHistoryByUserId(id, locale);
			Collections.reverse(result);
		}

		return result;
	}

	public List<Booking> selectBookingByHotelIdAndDate(long id,
			Calendar beginDate, Calendar endDate, String locale) {
		List<Booking> result = null;

		if (id != -1) {
			result = bookingDao.readBookingByHotelIdAndDate(id, beginDate,
					endDate, locale);
		}
		return result;
	}

	public boolean cancelBooking(long id) {
		boolean result = false;
		if (id != -1) {
			result = bookingDao.cancelBooking(id);
		}
		return result;
	}

	public void updateBooking(Booking booking) {
		bookingDao.update(booking);
	}
}
