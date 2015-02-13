package com.epam.lab.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.dao.BaseDao;
import com.epam.lab.dao.ConnectionManager;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.model.Service;

public class ServiceDao extends BaseDao<Service> {

	public List<Service> selectServiceByLocale(String locale) {
		List<Service> result = new ArrayList<>();
		Service service = null;

		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_SERVICE_BY_LOCALE)) {

			preparedStatement.setString(1, locale);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				service = new Mapping<Service>(Service.class)
						.convert(resultSet);

				result.add(service);
				service = null;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Service> readHotelServiceByIdByLocale(long id, String language) {

		List<Service> result = new ArrayList<>();
		Service service = null;

		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_SERVICE_BY_ID_BY_LOCALE)) {

			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, language);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				service = new Mapping<Service>(Service.class)
						.convert(resultSet);

				result.add(service);
				service = null;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
