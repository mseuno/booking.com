package com.epam.lab.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.lab.dao.BaseDao;
import com.epam.lab.dao.ConnectionManager;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.dao.queries.CreateQueries;
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.model.helper.Locale;

public class LocaleDao extends BaseDao<Locale> {

	public Locale getLocaleById(String id) {

		Locale locale = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_LOCALE_BY_ID)) {

			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				locale = new Mapping<Locale>(Locale.class).convert(resultSet);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return locale;
	}

	public void updateLocale(Locale locale, String oldId) {

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_LOCALE_UPDATE_LOCALE)) {

			preparedStatement.setString(1, locale.getName());
			preparedStatement.setString(2, locale.getId());
			preparedStatement.setString(3, oldId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
