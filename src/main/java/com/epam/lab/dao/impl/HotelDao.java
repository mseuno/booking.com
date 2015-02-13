package com.epam.lab.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.BaseDao;
import com.epam.lab.dao.ConnectionManager;
import com.epam.lab.dao.annotations.Table;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.dao.queries.CreateQueries;
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.model.City;
import com.epam.lab.model.Country;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Region;
import com.epam.lab.model.Street;
import com.epam.lab.model.helper.HotelInfo;
import com.epam.lab.model.helper.HotelReview;

public class HotelDao extends BaseDao<Hotel> {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<Hotel> readByCityId(long id, String locale) {
		return getHotels(id, locale, ReadQueries.SQL_HOTEL_BY_CITY);
	}

	public List<Hotel> readByRegionId(long id, String locale) {
		return getHotels(id, locale, ReadQueries.SQL_HOTEL_BY_REGION);
	}

	public Hotel readByHotelId(long id, String locale) {
		List<Hotel> result = getHotels(id, locale,
				ReadQueries.SQL_HOTEL_BY_HOTEL_ID);
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;

	}

	public Hotel readByHotelIdAdmin(long id, String locale) {
		List<Hotel> result = getHotels(id, locale,
				ReadQueries.SQL_HOTEL_READ_BY_HOTEL_ADMIN_ID);
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;

	}

	private List<Hotel> getHotels(long id, String locale, String query) {
		List<Hotel> result = new ArrayList<>();

		Hotel hotel = null;
		if (aclass.isAnnotationPresent(Table.class)) {

			ResultSet resultSet = null;
			try (Connection connection = ConnectionManager.getConnection();
					PreparedStatement preparedStatement = connection
							.prepareStatement(query)) {

				preparedStatement.setLong(1, id);
				preparedStatement.setString(2, locale);
				preparedStatement.setString(3, locale);
				preparedStatement.setString(4, locale);
				preparedStatement.setString(5, locale);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					hotel = new Mapping<Hotel>(Hotel.class).convert(resultSet);
					hotel.setCountry(new Mapping<Country>(Country.class)
							.convert(resultSet));
					hotel.setRegion(new Mapping<Region>(Region.class)
							.convert(resultSet));
					hotel.setCity(new Mapping<City>(City.class)
							.convert(resultSet));
					hotel.setStreet(new Mapping<Street>(Street.class)
							.convert(resultSet));

					RoomDao roomDao = new RoomDao();
					hotel.setRooms(roomDao.readByHotelId(hotel.getId(), locale));

					try (PreparedStatement preparedStatementHotelInfo = connection
							.prepareStatement(ReadQueries.SQL_HOTEL_INFO_BY_HOTEL_ID)) {
						ResultSet resultSetHotelInfo = null;
						preparedStatementHotelInfo.setLong(1, hotel.getId());
						preparedStatementHotelInfo.setString(2, locale);
						resultSetHotelInfo = preparedStatementHotelInfo
								.executeQuery();
						if (!resultSetHotelInfo.next()) {
							preparedStatementHotelInfo
									.setLong(1, hotel.getId());
							preparedStatementHotelInfo.setString(2, "en");
							resultSetHotelInfo = preparedStatementHotelInfo
									.executeQuery();
							resultSetHotelInfo.next();
						}
						hotel.setHotelInfo(new Mapping<HotelInfo>(
								HotelInfo.class).convert(resultSetHotelInfo));

					} catch (SQLException e) {
						LOG.error(e.getMessage());
						e.printStackTrace();
					}

					result.add(hotel);

				}

			} catch (SQLException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<Hotel> readRandom(int quantity, String locale) {

		List<Hotel> result = new ArrayList<>();

		Hotel hotel = null;
		if (aclass.isAnnotationPresent(Table.class)) {

			ResultSet resultSet = null;
			try (Connection connection = ConnectionManager.getConnection();
					PreparedStatement preparedStatement = connection
							.prepareStatement(ReadQueries.SQL_HOTEL_RANDOM_LIST)) {

				preparedStatement.setString(1, locale);
				preparedStatement.setString(2, locale);
				preparedStatement.setString(3, locale);
				preparedStatement.setString(4, locale);
				preparedStatement.setInt(5, quantity);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {

					hotel = new Mapping<Hotel>(Hotel.class).convert(resultSet);
					hotel.setCountry(new Mapping<Country>(Country.class)
							.convert(resultSet));
					hotel.setRegion(new Mapping<Region>(Region.class)
							.convert(resultSet));
					hotel.setCity(new Mapping<City>(City.class)
							.convert(resultSet));
					hotel.setStreet(new Mapping<Street>(Street.class)
							.convert(resultSet));

					RoomDao roomDao = new RoomDao();
					hotel.setRooms(roomDao.readByHotelId(hotel.getId(), locale));

					try (PreparedStatement preparedStatementHotelInfo = connection
							.prepareStatement(ReadQueries.SQL_HOTEL_INFO_BY_HOTEL_ID)) {
						ResultSet resultSetHotelInfo = null;
						preparedStatementHotelInfo.setLong(1, hotel.getId());
						preparedStatementHotelInfo.setString(2, locale);
						resultSetHotelInfo = preparedStatementHotelInfo
								.executeQuery();
						if (!resultSetHotelInfo.next()) {
							preparedStatementHotelInfo
									.setLong(1, hotel.getId());
							preparedStatementHotelInfo.setString(2, "en");
							resultSetHotelInfo = preparedStatementHotelInfo
									.executeQuery();
							resultSetHotelInfo.next();
						}
						hotel.setHotelInfo(new Mapping<HotelInfo>(
								HotelInfo.class).convert(resultSetHotelInfo));

					} catch (SQLException e) {
						LOG.error(e.getMessage());
						e.printStackTrace();
					}

					result.add(hotel);

				}

			} catch (SQLException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<Hotel> readFullInfoByName(String name) {

		List<Hotel> result = new ArrayList<>();

		Hotel hotel = null;

		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_FULL_INFO_BY_NAME)) {

			preparedStatement.setString(1, "%" + name + "%");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				hotel = getHotelObject(resultSet);
				result.add(hotel);

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	private Hotel getHotelObject(ResultSet resultSet) throws SQLException {
		Hotel hotel = new Mapping<Hotel>(Hotel.class).convert(resultSet);
		hotel.setCountry(new Mapping<Country>(Country.class).convert(resultSet));
		hotel.setRegion(new Mapping<Region>(Region.class).convert(resultSet));
		hotel.setCity(new Mapping<City>(City.class).convert(resultSet));
		hotel.setStreet(new Mapping<Street>(Street.class).convert(resultSet));
		hotel.setHotelInfo(new Mapping<HotelInfo>(HotelInfo.class)
				.convert(resultSet));
		return hotel;
	}

	public List<Hotel> readUsersFavorites(long id, String language) {

		List<Hotel> result = new ArrayList<>();
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_USER_FAVORITES)) {

			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, language);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Hotel hotel = new Mapping<Hotel>(Hotel.class)
						.convert(resultSet);
				hotel.setHotelInfo(new Mapping<HotelInfo>(HotelInfo.class)
						.convert(resultSet));
				result.add(hotel);

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

	public void addToBlackList(Long id, boolean block) {

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_HOTEL_BLOCK)) {

			preparedStatement.setBoolean(1, block);
			preparedStatement.setLong(2, id);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public Hotel readByManagerId(long id) {

		Hotel result = null;

		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_READ_BY_MANAGER_ID)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = new Mapping<Hotel>(Hotel.class).convert(resultSet);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

	public List<HotelReview> getAllHotelReview(Long hotelId) {
		List<HotelReview> result = new ArrayList<HotelReview>();

		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_GET_ALL_HOTEL_REVIEW)) {

			preparedStatement.setLong(1, hotelId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				HotelReview hotelReview = new HotelReview();
				hotelReview.setUserName(resultSet.getString("first_name"));
				hotelReview.setRating(resultSet.getByte("rating"));
				hotelReview.setReview(resultSet.getString("review"));
				result.add(hotelReview);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public HotelReview getHotelReview(Long userId, Long hotelId) {
		HotelReview result = new HotelReview();

		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_GET_REVIEW)) {

			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, hotelId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result.setRating(resultSet.getByte("rating"));
				result.setReview(resultSet.getString("review"));
			} else {
				result = null;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public void addHotelReview(Long userId, Long hotelId,
			HotelReview hotelReview) {
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_ADD_HOTEL_REVIEW)) {

			this.deleteHotelReview(userId, hotelId);

			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, hotelId);
			preparedStatement.setByte(3, hotelReview.getRating());
			preparedStatement.setString(4, hotelReview.getReview());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteHotelReview(Long userId, Long hotelId) {
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM review WHERE user_id=? AND hotel_id=?")) {

			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, hotelId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

	// user can add review only if he has completed booking in the hotel
	public boolean checkIfUserCanAddReview(Long userId, Long hotelId) {
		boolean result = false;

		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_CHECK_IF_USER_CAN_ADD_REVIEW)) {

			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, hotelId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = true;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
