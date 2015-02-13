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
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.dao.queries.CreateQueries;
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.exceptions.DuplicateUniqueKeyException;
import com.epam.lab.model.Manager;
import com.epam.lab.model.helper.HotelInfo;

public class ManagerDao extends BaseDao<Manager> {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public Long registerNewManager(Manager manager)
			throws DuplicateUniqueKeyException {
		Long id = (long) -1;
		ResultSet generatedKeys = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_MANAGER_REGISTER,
								PreparedStatement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, manager.getFirstName());
			preparedStatement.setString(2, manager.getLastName());
			preparedStatement.setString(3, manager.getEmail());
			preparedStatement.setString(4, manager.getPassword());
			preparedStatement.setString(5, manager.getPhone());
			preparedStatement.setDate(6, manager.getRegistrationDate());
			preparedStatement.executeUpdate();
			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getLong(1);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			// SQLState 23000 - integrity constraint violation
			if (e.getSQLState().equals("23000")) {
				throw new DuplicateUniqueKeyException();
			} else {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
		} finally {
			if (generatedKeys != null) {
				try {
					generatedKeys.close();
				} catch (SQLException e) {
					LOG.error(e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return id;
	}

	public Manager readByEmailAndPassword(String email, String password) {
		Manager result = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_MANAGER_BY_EMAIL_AND_PASSWORD)) {

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.first()) {

				result = new Mapping<Manager>(Manager.class).convert(resultSet);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public List<Manager> getNewApplications(String language) {
		List<Manager> result = new ArrayList<>();
		Manager manager = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_MANAGER_GET_NEW_APPLICATIONS)) {

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				manager = new Mapping<Manager>(Manager.class)
						.convert(resultSet);
				manager.setHotelInfo(new Mapping<HotelInfo>(HotelInfo.class)
						.convert(resultSet));
				result.add(manager);
				manager = null;
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();

		}
		return result;
	}

}
