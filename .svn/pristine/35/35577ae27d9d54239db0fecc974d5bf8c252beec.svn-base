package com.epam.lab.dao.queries;

public class ReadQueries {

	/**
	 * MANAGER
	 */
	public static final String SQL_MANAGER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM manager WHERE email = ? AND password = ?";
	
	public static final String SQL_MANAGER_READ_MESSAGE_IMPORTANT_SEND = "SELECT * FROM manager_message  WHERE status=? OR status =? ORDER BY -id";

	public static final String SQL_MANAGER_READ_MESSAGE_BY_STATUS = "SELECT * FROM manager_message  WHERE status=? ORDER BY -id";
	
	public static final String SQL_MANAGER_GET_NEW_APPLICATIONS = "SELECT * FROM manager inner join hotel_info on manager.hotel_id = hotel_info.hotel_id  inner join hotel on hotel.id = manager.hotel_id WHERE manager.admin_id IS NULL AND hotel.blocked='0' group by hotel.id";
	
	/**
	 * HOTEL
	 */
	public static final String SQL_HOTEL_CHECK_IF_USER_CAN_ADD_REVIEW = "SELECT * FROM booking WHERE user_id=? AND hotel_id=? AND status=0";
	
	public static final String SQL_HOTEL_ADD_HOTEL_REVIEW = "INSERT INTO review (user_id, hotel_id, rating, review) VALUES (?, ?, ?, ?)";
	
	public static final String SQL_HOTEL_GET_REVIEW = "SELECT review.rating, review.review FROM review WHERE user_id=? AND hotel_id=?";
	
	public static final String SQL_HOTEL_GET_ALL_HOTEL_REVIEW = "SELECT user.first_name, review.rating, review.review FROM review INNER JOIN user ON review.user_id = user.id WHERE hotel_id=?";
	
	public static final String SQL_HOTEL_READ_BY_MANAGER_ID = "SELECT * FROM hotel WHERE hotel.id = ?";
	
	public static final String SQL_HOTEL_READ_BY_HOTEL_ADMIN_ID = "SELECT * FROM hotel INNER JOIN city ON hotel.city_id = city.id INNER JOIN region ON hotel.region_id = region.id INNER JOIN country ON hotel.country_id = country.id INNER JOIN street ON hotel.street_id = street.id INNER JOIN manager ON hotel.id = manager.hotel_id WHERE hotel.id = ? AND city.locale_id=? AND country.locale_id = ? AND region.locale_id=? AND street.locale_id = ?";
	
	public static final String SQL_HOTEL_BY_MANAGER = "SELECT  hotel.* FROM hotel INNER JOIN manager_hotel ON hotel.id = manager_hotel.hotel_id WHERE manager_hotel.manager_id = ?";

	public static final String SQL_HOTEL_SERVICEC_BY_HOTEL_ID = "SELECT DISTINCT service.* FROM hotel_service INNER JOIN service ON hotel_service.hotel_id = service.id WHERE hotel_service.hotel_id = ?";

	public static final String SQL_HOTEL_GALLERY_BY_HOTEL_ID = "SELECT * FROM hotel_gallery WHERE hotel_id = ?";

	public static final String SQL_HOTEL_BY_CITY = "SELECT * FROM hotel INNER JOIN city ON hotel.city_id = city.id INNER JOIN region ON hotel.region_id = region.id INNER JOIN country ON hotel.country_id = country.id INNER JOIN street ON hotel.street_id = street.id INNER JOIN manager ON hotel.id = manager.hotel_id WHERE manager.admin_id IS NOT NULL AND hotel.city_id = ? AND city.locale_id=? AND country.locale_id = ? AND region.locale_id=? AND street.locale_id = ?";

	public static final String SQL_HOTEL_BY_REGION = "SELECT * FROM hotel INNER JOIN city ON hotel.city_id = city.id INNER JOIN region ON hotel.region_id = region.id INNER JOIN country ON hotel.country_id = country.id INNER JOIN street ON hotel.street_id = street.id INNER JOIN manager ON hotel.id = manager.hotel_id WHERE manager.admin_id IS NOT NULL AND hotel.region_id = ? AND city.locale_id=? AND country.locale_id = ? AND region.locale_id=? AND street.locale_id = ?";

	public static final String SQL_HOTEL_BY_HOTEL_ID = "SELECT * FROM hotel INNER JOIN city ON hotel.city_id = city.id INNER JOIN region ON hotel.region_id = region.id INNER JOIN country ON hotel.country_id = country.id INNER JOIN street ON hotel.street_id = street.id INNER JOIN manager ON hotel.id = manager.hotel_id WHERE manager.admin_id IS NOT NULL AND hotel.id = ? AND city.locale_id=? AND country.locale_id = ? AND region.locale_id=? AND street.locale_id = ? AND hotel.blocked = '0'";

	public static final String SQL_HOTEL_INFO_BY_HOTEL_ID = "SELECT * FROM hotel_info WHERE hotel_id = ? AND locale_id = ?";

	public static final String SQL_HOTEL_FULL_INFO_BY_ID = "SELECT * FROM hotel INNER JOIN city ON hotel.city_id = city.id INNER JOIN region ON city.region_id = region.id INNER JOIN country ON region.country_id = country.id INNER JOIN street ON hotel.street_id = street.id INNER JOIN hotel_info ON hotel.id = hotel_info.hotel_id WHERE hotel.id = ?";

	public static final String SQL_HOTEL_FULL_INFO_BY_NAME = "SELECT * FROM hotel INNER JOIN city ON hotel.city_id = city.id INNER JOIN region ON city.region_id = region.id AND city.locale_id = region.locale_id INNER JOIN country ON region.country_id = country.id AND region.locale_id = country.locale_id INNER JOIN street ON hotel.street_id = street.id AND city.locale_id = street.locale_id INNER JOIN hotel_info ON hotel.id = hotel_info.hotel_id AND city.locale_id = hotel_info.locale_id WHERE LOWER(hotel_info.name) LIKE LOWER(?)";

	public static final String SQL_HOTEL_RANDOM_LIST = "SELECT * FROM hotel INNER JOIN city ON hotel.city_id = city.id INNER JOIN region ON hotel.region_id = region.id INNER JOIN country ON hotel.country_id = country.id INNER JOIN street ON hotel.street_id = street.id INNER JOIN manager ON hotel.id = manager.hotel_id WHERE manager.admin_id IS NOT NULL AND city.locale_id=? AND country.locale_id = ? AND region.locale_id=? AND street.locale_id = ? ORDER BY rand() limit ?";

	public static final String SQL_HOTEL_USER_FAVORITES = "select * from hotel inner join favorite on favorite.hotel_id = hotel.id inner join user on favorite.user_id = user.id inner join hotel_info on hotel.id = hotel_info.hotel_id where user.id = ? AND locale_id = ?";
	
	public static final String SQL_HOTELES_FOR_MANAGER_HOTELES_LIST = "SELECT hotel.*,hotel_info.name, country.name, city.name FROM hotel INNER JOIN hotel_info ON hotel.id = hotel_info.hotel_id INNER JOIN manager_hotel ON hotel.id = manager_hotel.hotel_id INNER JOIN country ON hotel.country_id = country.id INNER JOIN city ON hotel.city_id = city.id WHERE manager_hotel.manager_id = ? AND hotel_info.locale_id = city.locale_id AND country.locale_id = city.locale_id AND city.locale_id = ?";
	
	/**
	 * CITY
	 */

	public static final String SQL_CITY_BY_REGION_ID = "SELECT * FROM city WHERE region_id = ? AND locale_id = ?";

	public static final String SQL_CITY_FULL_BY_CITY_NAME_INFO = "SELECT * FROM city INNER JOIN region ON city.region_id = region.id AND city.locale_id = region.locale_id INNER JOIN country ON region.country_id = country.id  AND region.locale_id = country.locale_id WHERE LOWER(city.name) LIKE LOWER(?)";

	public static final String SQL_CITY_LOCALE_BY_REGION_AND_COUNTRY_ID = "SELECT * FROM city WHERE region_id = ? AND country_id = ? AND locale_id = ?";

	/**
	 * REGION
	 */
	public static final String SQL_REGION_BY_REGION_NAME_FULL_INFO = "SELECT * FROM region INNER JOIN country ON region.country_id = country.id AND region.locale_id = country.locale_id WHERE LOWER(region.name) LIKE LOWER(?)";

	public static final String SQL_REGION_LOCAL_BY_COUNTRY_ID = "SELECT * FROM region WHERE country_id = ? AND locale_id = ?";

	public static final String SQL_REGIONS_BY_LOCALE_ID = "SELECT * FROM region WHERE locale_id = ?";
	

	public static final String SQL_REGION_LOCALE_BY_COUNTRY_ID = "SELECT * FROM region WHERE country_id = ? AND locale_id = ?";

	
	/**
	 * ADMIN
	 */
	public static final String SQL_ADMIN_BY_EMAIL_AND_PASSWORD = "SELECT * FROM admin WHERE email = ? AND password = ?";

	public static final String SQL_ADMIN_READ_MANAGER_REQUEST = "SELECT * FROM manager_message ORDER BY -id ";

	/**
	 * STREET
	 */

	public static final String SQL_STREET_LOCALE_BY_CITY_ID = "SELECT * FROM street WHERE city_id = ? AND locale_id = ?";

	/**
	 * BOOKING
	 */


	public static final String SQL_UNCONFIRMED_BOOKING_FULL_INFO_BY_MANAGER_ID = "SELECT booking.*,user.*,hotel.* FROM booking INNER JOIN user ON booking.user_id = user.id INNER JOIN hotel ON booking.hotel_id=hotel.id INNER JOIN booking_room ON booking.id = booking_room.booking_id WHERE hotel.id = ?  AND booking.status=1 GROUP BY booking.id";
	
	public static final String SQL_BOOKING_BY_USER_ID = "SELECT * FROM booking INNER JOIN hotel_info ON booking.hotel_id = hotel_info.hotel_id WHERE booking.user_id = ? AND CASE WHEN EXISTS (SELECT hotel_id FROM hotel_info WHERE hotel_info.hotel_id = booking.hotel_id AND locale_id = ?) THEN hotel_info.locale_id = ? ELSE hotel_info.locale_id = 'en' END";
	
	public static final String SQL_BOOKING_HISTORY_BY_USER_ID = "SELECT * FROM booking INNER JOIN hotel_info ON booking.hotel_id = hotel_info.hotel_id WHERE booking.user_id = ? AND booking.begin_date < ? AND CASE WHEN EXISTS (SELECT hotel_id FROM hotel_info WHERE hotel_info.hotel_id = booking.hotel_id AND locale_id = ?) THEN hotel_info.locale_id = ? ELSE hotel_info.locale_id = 'en' END";

	public static final String SQL_BOOKING_BY_HOTEL_ID_AND_DATE = "SELECT * FROM booking WHERE booking.hotel_id = ? AND DATE(booking.begin_date) <= DATE( ? ) AND DATE(booking.end_date) > DATE( ? ) AND booking.status != 3";

	public static final String SQL_BOOKING_FULL_INFO_BY_MANAGER_ID = "SELECT booking.*,user.*,hotel.* FROM booking INNER JOIN user ON booking.user_id = user.id INNER JOIN hotel ON booking.hotel_id=hotel.id INNER JOIN manager ON booking.hotel_id = manager.hotel_id INNER JOIN booking_room ON booking.id = booking_room.booking_id WHERE manager.id = ? AND (booking.status =3 or booking.status =0) GROUP BY booking.id";

	public static final String SQL_DENIED_BOOKING_FULL_INFO_BY_MANAGER_ID = "SELECT booking.*,user.*,hotel.* FROM booking INNER JOIN user ON booking.user_id = user.id INNER JOIN hotel ON booking.hotel_id=hotel.id INNER JOIN manager ON booking.hotel_id = manager.hotel_id INNER JOIN booking_room ON booking.id = booking_room.booking_id WHERE manager.id = ? AND booking.status =3 GROUP BY booking.id";

	public static final String SQL_DONE_BOOKING_FULL_INFO_BY_MANAGER_ID = "SELECT booking.*,user.*,hotel.* FROM booking INNER JOIN user ON booking.user_id = user.id INNER JOIN hotel ON booking.hotel_id=hotel.id INNER JOIN manager ON booking.hotel_id = manager.hotel_id INNER JOIN booking_room ON booking.id = booking_room.booking_id WHERE manager.id = ? AND booking.status =0 GROUP BY booking.id";

	public static final String SQL_CONFIRMED_BOOKING_FULL_INFO_BY_MANAGER_ID = "SELECT booking.*,user.*,hotel.* FROM booking INNER JOIN user ON booking.user_id = user.id INNER JOIN hotel ON booking.hotel_id=hotel.id INNER JOIN manager ON booking.hotel_id = manager.hotel_id INNER JOIN booking_room ON booking.id = booking_room.booking_id WHERE manager.id = ? AND booking.status =2 GROUP BY booking.id";
	
	public static final String SQL_BOOKING_ROOM_BY_BOOKING_ID = "SELECT * FROM booking_room INNER JOIN room ON booking_room.room_id = room.id INNER JOIN room_info ON room_info.room_id = room.id WHERE booking_room.booking_id = ? AND CASE WHEN EXISTS (SELECT room_id FROM room_info WHERE room_info.room_id = room.id AND locale_id = ?) THEN room_info.locale_id = ? ELSE room_info.locale_id = 'en' END";

	/**
	 * USER
	 */

	public static final String SQL_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM user WHERE email = ? AND password = ?";
	
	public static final String SQL_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";

	/**
	 * ROOM
	 */
	
	
	public static final String SQL_ROOM_READ_BY_HOTEL_ID = "SELECT * FROM room inner join room_info on room_info.room_id = room.id WHERE room.id = ? AND locale_id = ?";
	
	public static final String SQL_ROOM_BY_HOTEL_ID = "SELECT * FROM room WHERE hotel_id = ?";

	public static final String SQL_ROOM_BY_ROOM_ID = "SELECT * FROM room WHERE id = ?";

	public static final String SQL_ROOM_INFO_BY_ROOM_ID = "SELECT * FROM room_info WHERE room_id = ? AND locale_id = ?";

	/**
	 * COUNTRY
	 */

	public static final String SQL_COUNTRIES_BY_LOCALE_ID = "SELECT * FROM country WHERE locale_id = ?";

	/**
	 * SERVICE
	 */

	public static final String SQL_HOTEL_SERVICE_BY_LOCALE = "SELECT * FROM service WHERE locale_id = ?";
	
	public static final String SQL_SERVICE_BY_ID = "SELECT * FROM service WHERE id = ?";
	
	public static final String SQL_SERVICE_BY_ID_BY_LOCALE = "SELECT * FROM hotel_service INNER JOIN service ON hotel_service.service_id = service.id WHERE hotel_service.hotel_id = ? AND service.locale_id = ?";

	
	/**
	 * HOTEL_INFO
	 */
	
	public static final String SQL_READ_HOTEL_INFO_BY_HOTELID_BY_LANGUAGE = "SELECT * FROM hotel_info WHERE hotel_id = ? AND locale_id = ?";
	
	public static final String SQL_READ_BY_LOCALE = "SELECT *  FROM hotel_info WHERE locale_id =?";
	
	public static final String SQL_HOTEL_INFO_READ = "SELECT hotel_info.*  FROM hotel_info INNER JOIN hotel ON hotel.id = hotel_info.hotel_id WHERE hotel.id = ? AND hotel_info = ?";
	
	public static final String SQL_HOTEL_INFO_READ_BY_BLOCKED = "SELECT *  FROM hotel_info INNER JOIN hotel ON hotel.id = hotel_info.hotel_id WHERE hotel.blocked = ? AND hotel_info.locale_id = ?";
	
	public static final String SQL_HOTEL_INFO_SEARCH = "SELECT *  FROM hotel_info INNER JOIN hotel ON hotel.id = hotel_info.hotel_id WHERE hotel.blocked = ? AND LOWER(hotel_info.name) LIKE ?";
	
	
	/**
	 * HOTEL_INFO
	 */
	
	public static final String SQL_SERVICES_BY_HOTEL_ID = "SELECT * FROM hotel_service WHERE hotel_service.hotel_id = ?";
	
	/***
	 * LOCALE	
	 */
	
	public static final String SQL_LOCALE_BY_ID = "SELECT * FROM locale WHERE id = ?";
	
	
	
	
	private ReadQueries() {

	}
}
