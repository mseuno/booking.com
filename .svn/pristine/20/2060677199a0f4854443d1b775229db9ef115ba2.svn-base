package com.epam.lab.dao.queries;

public class CreateQueries {

	/**
	 * MANAGER
	 */
	public static final String SQL_MANAGER_REGISTER = "INSERT INTO booking.manager (first_name, last_name, email, password, phone, registration_date) VALUES(?,?,?,?,?,?)";

	public static final String SQL_CONFIRM_NEW_MANAGER_BY_ADMIN = "UPDATE booking.manager SET admin_id = ? WHERE id = ? ";

	public static final String SQL_MANAGER_UPDATE = "UPDATE manager SET first_name = ?, last_name = ?, email = ?, last_update = ?, password = ?, phone = ?, registration_date = ?, hotel_id = ? WHERE id = ?";

	/**
	 * ADMIN
	 */

	public static final String SQL_ADMIN_REGISTER = "INSERT INTO admin (first_name, last_name, email, password, registration_date) VALUES(?,?,?,?,?)";

	/**
	 * country
	 * 
	 */
	@Deprecated
	public static final String SQL_COUNTRY_UPDATE_BY_LOCALE = "UPDATE booking.country SET name = ? WHERE id = ? AND locale_id = ? ";

	/*
	 * 
	 * USER
	 */
	public static final String SQL_USER_REGISTER = "INSERT INTO user (first_name, last_name, email, password, registration_date, registered, blocked, last_update, phone) VALUES(?,?,?,?,?,?,?,?,?)";

	/**
	 * room Info
	 */
	public static final String SQL_UPDATE_ROOMINFO_BY_ROOMID_BY_LOCALEID = "UPDATE room_info SET name = ? WHERE room_id = ? AND locale_id = ?";

	public static final String SQL_ROOM_INFO_UPDATE = "INSERT INTO room_info (room_id,locale_id,name) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name=?";

	/**
	 * HOTEL INFO
	 */
	@Deprecated
	public static final String SQL_UPDATE_HOTELINFO_BY_HOTELID_BY_LOCALEID = "UPDATE hotel_info SET short_info = ?, extended_info = ?, name = ? WHERE hotel_id = ? AND locale_id = ? ";

	/*
	 * HOTEL
	 */
	public static final String SQL_HOTEL_BLOCK = "UPDATE hotel SET blocked = ? WHERE id = ?";

	/**
	 * booking
	 * */

	public static final String SQL_BOOKING_CANCEL_QUERY = "UPDATE booking SET status = 3 WHERE id = ?";
	public static final String SQL_INSETR_BOOKING_ROOMS_QUERY = "INSERT INTO booking_room SET booking_id = ?, room_id = ?, hotel_id = ?, number_of_rooms = ?, cost = ?";
	/**
	 * Locale
	 * */
	public static final String SQL_LOCALE_UPDATE_LOCALE = "UPDATE locale SET locale = ?, id = ? WHERE id = ?";

	/**
	 * Room
	 * */

	public static final String SQL_ROOM_SET_ROOM_QUANTITY = "UPDATE room SET number_of_rooms = ? WHERE id = ?";

}
