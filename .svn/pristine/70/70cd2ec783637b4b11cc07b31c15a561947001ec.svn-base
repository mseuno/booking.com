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
import com.epam.lab.model.Country;
import com.epam.lab.model.Region;

public class RegionDao extends BaseDao<Region> {

	private static final Logger LOG = Logger.getLogger(RegionDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<Region> readFullInfoByName(String name) {

		List<Region> result = new ArrayList<>();
		ResultSet resultSet = null;
		Region region = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_REGION_BY_REGION_NAME_FULL_INFO)) {

			preparedStatement.setString(1, name + "%");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				region = new Mapping<Region>(Region.class).convert(resultSet);
				region.setCountry(new Mapping<Country>(Country.class)
						.convert(resultSet));
				result.add(region);

			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

}
