package com.epam.lab.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.BaseDao;
import com.epam.lab.dao.ConnectionManager;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.dao.queries.CreateQueries;
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.exceptions.DuplicateUniqueKeyException;
import com.epam.lab.model.User;

public class UserDao extends BaseDao<User> {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public User readByEmailAndPassword(String email, String password) {
		User result = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_USER_BY_EMAIL_AND_PASSWORD)) {

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.first()) {

				result = new Mapping<User>(User.class).convert(resultSet);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public User readByEmail(String email) {
		User result = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_USER_BY_EMAIL)) {
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {

				result = new Mapping<User>(User.class).convert(resultSet);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public void registerNewUser(User user) throws DuplicateUniqueKeyException {

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_USER_REGISTER)) {

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setDate(5, user.getRegistrationDate());
			preparedStatement.setBoolean(6, user.getRegistered());
			preparedStatement.setBoolean(7, user.getBlocked());
			preparedStatement.setTimestamp(8, user.getLastUpdate());
			preparedStatement.setString(9, user.getPhone());
			preparedStatement.execute();

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			// SQLState 23000 - integrity constraint violation
			if (e.getSQLState().equals("23000")) {

				throw new DuplicateUniqueKeyException();
			} else {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}

		}
	}

	public void updateUser(User user) {

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE user SET first_name = ?, last_name = ?, email = ?, password = ?,"
								+ "last_update = ?, phone = ? WHERE id = ?")) {

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setTimestamp(5, user.getLastUpdate());
			preparedStatement.setString(6, user.getPhone());
			preparedStatement.setLong(7, user.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean setFavoriteHotel(Long userId, Long hotelId) {
		boolean result = false;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO favorite (user_id, hotel_id) VALUES (?,?)")) {

			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, hotelId);
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

	public boolean checkIfHotelIsFavorite(Long userId, Long hotelId) {
		Boolean result = false;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM favorite WHERE user_id = ? AND hotel_id = ?")) {

			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, hotelId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public boolean deleteHotelFromFavorite(Long userId, Long hotelId) {
		boolean result = false;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM favorite WHERE user_id = ? AND hotel_id = ?")) {

			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, hotelId);
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