package com.epam.lab.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.BaseDao;
import com.epam.lab.dao.ConnectionManager;
import com.epam.lab.dao.annotations.Table;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.dao.queries.CreateQueries;
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.model.Booking;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Room;
import com.epam.lab.model.User;
import com.epam.lab.model.helper.BookingRoom;
import com.epam.lab.model.helper.HotelInfo;
import com.epam.lab.model.helper.RoomInfo;
import com.epam.lab.utils.RoomAccessibility;

public class BookingDao extends BaseDao<Booking> {

	private static final Logger LOG = Logger.getLogger(BookingDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<Booking> readBookingByHotelIdAndDate(long id,
			Calendar beginDate, Calendar endDate, String locale) {

		List<Booking> result = new ArrayList<>();
		Booking booking = new Booking();
		List<BookingRoom> resultBookingRoom = new ArrayList<>();
		BookingRoom bookingRoom = new BookingRoom();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		if (aclass.isAnnotationPresent(Table.class)) {

			ResultSet resultSet = null;
			ResultSet resultSetBookingRoom = null;
			try (Connection connection = ConnectionManager.getConnection();
					PreparedStatement preparedStatement = connection
							.prepareStatement(ReadQueries.SQL_BOOKING_BY_HOTEL_ID_AND_DATE);
					PreparedStatement preparedStatementBookingRoom = connection
							.prepareStatement(ReadQueries.SQL_BOOKING_ROOM_BY_BOOKING_ID)) {

				preparedStatement.setLong(1, id);
				preparedStatement.setString(2,
						dateFormat.format(endDate.getTime()));
				preparedStatement.setString(3,
						dateFormat.format(beginDate.getTime()));

				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					booking = new Mapping<Booking>(Booking.class)
							.convert(resultSet);

					resultBookingRoom.clear();
					preparedStatementBookingRoom.setLong(1, booking.getId());
					preparedStatementBookingRoom.setString(2, locale);
					preparedStatementBookingRoom.setString(3, locale);

					resultSetBookingRoom = preparedStatementBookingRoom
							.executeQuery();
					while (resultSetBookingRoom.next()) {

						bookingRoom = new Mapping<BookingRoom>(
								BookingRoom.class)
								.convert(resultSetBookingRoom);
						resultBookingRoom.add(bookingRoom);
					}
					booking.setBookingRoom(resultBookingRoom);

					result.add(booking);
				}

			} catch (SQLException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
		}

		return result;

	}

	public List<Booking> readBookingHistoryByUserId(long id, String locale) {

		List<Booking> result = new ArrayList<>();
		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_BOOKING_HISTORY_BY_USER_ID)) {

			preparedStatement.setLong(1, id);
			preparedStatement.setDate(2, new Date(Calendar.getInstance()
					.getTimeInMillis()));
			preparedStatement.setString(3, locale);
			preparedStatement.setString(4, locale);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Booking booking = new Mapping<Booking>(Booking.class)
						.convert(resultSet);

				booking.setHotelInfo(new Mapping<HotelInfo>(HotelInfo.class)
						.convert(resultSet));
				booking.setBookingRoom(getBookingRom(booking.getId(), locale));

				result.add(booking);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public List<Booking> readBookingByUserId(long id, String locale) {

		List<Booking> result = new ArrayList<>();
		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_BOOKING_BY_USER_ID)) {

			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, locale);
			preparedStatement.setString(3, locale);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Booking booking = new Mapping<Booking>(Booking.class)
						.convert(resultSet);

				booking.setHotelInfo(new Mapping<HotelInfo>(HotelInfo.class)
						.convert(resultSet));
				booking.setBookingRoom(getBookingRom(booking.getId(), locale));

				result.add(booking);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public List<BookingRoom> getBookingRom(long idBooking, String locale) {
		List<BookingRoom> resultBookingRoom = new ArrayList<>();
		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_BOOKING_ROOM_BY_BOOKING_ID)) {

			preparedStatement.setLong(1, idBooking);
			preparedStatement.setString(2, locale);
			preparedStatement.setString(3, locale);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookingRoom bookingRoom = new Mapping<BookingRoom>(
						BookingRoom.class).convert(resultSet);

				bookingRoom.setRoom(new Mapping<Room>(Room.class)
						.convert(resultSet));

				bookingRoom.getRoom().setRoomInfo(
						new Mapping<RoomInfo>(RoomInfo.class)
								.convert(resultSet));

				resultBookingRoom.add(bookingRoom);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return resultBookingRoom;
	}

	public List<Booking> readFullBookingInfoByManagerId(long id) {

		List<Booking> result = new ArrayList<>();
		Booking booking = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_BOOKING_FULL_INFO_BY_MANAGER_ID)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				booking = new Mapping<Booking>(Booking.class)
						.convert(resultSet);
				booking.setUser(new Mapping<User>(User.class)
						.convert(resultSet));
				booking.setHotel(new Mapping<Hotel>(Hotel.class)
						.convert(resultSet));

				result.add(booking);

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public List<Booking> readFullDeniedBookingInfoByManagerId(long id) {

		List<Booking> result = new ArrayList<>();
		Booking booking = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_DENIED_BOOKING_FULL_INFO_BY_MANAGER_ID)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				booking = new Mapping<Booking>(Booking.class)
						.convert(resultSet);
				booking.setUser(new Mapping<User>(User.class)
						.convert(resultSet));
				booking.setHotel(new Mapping<Hotel>(Hotel.class)
						.convert(resultSet));

				result.add(booking);

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public List<Booking> readFullConfirmedBookingInfoByManagerId(long id) {

		List<Booking> result = new ArrayList<>();
		Booking booking = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_CONFIRMED_BOOKING_FULL_INFO_BY_MANAGER_ID)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				booking = new Mapping<Booking>(Booking.class)
						.convert(resultSet);
				booking.setUser(new Mapping<User>(User.class)
						.convert(resultSet));
				booking.setHotel(new Mapping<Hotel>(Hotel.class)
						.convert(resultSet));

				result.add(booking);

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public List<Booking> readFullDoneBookingInfoByManagerId(long id) {

		List<Booking> result = new ArrayList<>();
		Booking booking = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_DONE_BOOKING_FULL_INFO_BY_MANAGER_ID)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				booking = new Mapping<Booking>(Booking.class)
						.convert(resultSet);
				booking.setUser(new Mapping<User>(User.class)
						.convert(resultSet));
				booking.setHotel(new Mapping<Hotel>(Hotel.class)
						.convert(resultSet));

				result.add(booking);

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public List<Booking> readUnconfirmedFullBookingInfoByHotelId(long id) {

		List<Booking> result = new ArrayList<>();
		Booking booking = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_UNCONFIRMED_BOOKING_FULL_INFO_BY_MANAGER_ID)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				booking = new Mapping<Booking>(Booking.class)
						.convert(resultSet);
				booking.setUser(new Mapping<User>(User.class)
						.convert(resultSet));
				booking.setHotel(new Mapping<Hotel>(Hotel.class)
						.convert(resultSet));

				result.add(booking);

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public boolean insertBookingRooms(
			Map<Long, RoomAccessibility> availableRooms,
			List<BookingRoom> bookingRooms) {

		boolean result = true;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_INSETR_BOOKING_ROOMS_QUERY)) {

			connection.setAutoCommit(false);

			for (BookingRoom bookingRoom : bookingRooms) {

				RoomAccessibility accessibility = availableRooms
						.get(bookingRoom.getRoomId());

				if (accessibility == null) {
					result = false;
					System.out.println("fuck");
					break;
				}

				Integer availableRoomCount = accessibility
						.getRoomAccessebility().getNumberOfRooms();

				if (availableRoomCount < bookingRoom.getNumberOfRooms()) {
					result = false;
					System.out.println("fuck2");
					break;
				}

				preparedStatement.setLong(1, bookingRoom.getBookingId());
				preparedStatement.setLong(2, bookingRoom.getRoomId());
				preparedStatement.setLong(3, bookingRoom.getHotelId());
				preparedStatement.setInt(4, bookingRoom.getNumberOfRooms());
				preparedStatement.setLong(5, bookingRoom.getCost());

				preparedStatement.execute();
			}

			if (result) {
				connection.commit();
			} else {
				connection.rollback();
			}

			connection.setAutoCommit(true);

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

	public boolean cancelBooking(Long id) {
		boolean result = false;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_BOOKING_CANCEL_QUERY)) {

			preparedStatement.setLong(1, id);

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				result = true;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
