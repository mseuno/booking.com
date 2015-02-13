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
import com.epam.lab.dao.queries.ReadQueries;
import com.epam.lab.model.City;
import com.epam.lab.model.Country;
import com.epam.lab.model.Region;

public class CityDao extends BaseDao<City> {

	private static final Logger LOG = Logger.getLogger(CityDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<City> readByRegionId(long id, String locale) {

		List<City> result = new ArrayList<>();
		City city = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_CITY_BY_REGION_ID)) {

			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, locale);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				city = new Mapping<City>(City.class).convert(resultSet);

				result.add(city);
				city = null;

			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

	public List<City> readFullInfoByName(String name) {

		List<City> result = new ArrayList<>();
		ResultSet resultSet = null;
		City city = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_CITY_FULL_BY_CITY_NAME_INFO)) {

			preparedStatement.setString(1, name + "%");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				city = new Mapping<City>(City.class).convert(resultSet);
				city.setCountry(new Mapping<Country>(Country.class)
						.convert(resultSet));
				city.setRegion(new Mapping<Region>(Region.class)
						.convert(resultSet));

				result.add(city);
				city = null;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

}
