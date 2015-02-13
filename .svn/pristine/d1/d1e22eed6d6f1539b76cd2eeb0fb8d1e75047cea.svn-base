package com.epam.lab.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.BaseDao;
import com.epam.lab.dao.ConnectionManager;
import com.epam.lab.dao.queries.CreateQueries;
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.model.Admin;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.exceptions.DuplicateUniqueKeyException;

public class AdminDao extends BaseDao<Admin> {

	private static final Logger LOG = Logger.getLogger(AdminDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public Admin readByEmailAndPassword(String email, String password) {

		Admin result = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_ADMIN_BY_EMAIL_AND_PASSWORD)) {

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = new Mapping<Admin>(Admin.class).convert(resultSet);
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public void registerNewAdmin(Admin admin)
			throws DuplicateUniqueKeyException {

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_ADMIN_REGISTER)) {

			preparedStatement.setString(1, admin.getFirstName());
			preparedStatement.setString(2, admin.getLastName());
			preparedStatement.setString(3, admin.getEmail());
			preparedStatement.setString(4, admin.getPassword());
			preparedStatement.setDate(5, admin.getRegistrationDate());
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

}
