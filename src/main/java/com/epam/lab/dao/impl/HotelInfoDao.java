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
import com.epam.lab.model.helper.HotelInfo;

public class HotelInfoDao extends BaseDao<HotelInfo> {

	private static final Logger LOG = Logger.getLogger(CityDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<HotelInfo> readByBlocked(boolean blocked, String language) {

		List<HotelInfo> hotels = new ArrayList<>();
		HotelInfo hotelInfo = new HotelInfo();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_INFO_READ_BY_BLOCKED)) {

			preparedStatement.setBoolean(1, blocked);
			preparedStatement.setString(2, language);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				hotelInfo = new Mapping<HotelInfo>(HotelInfo.class)
						.convert(resultSet);
				hotels.add(hotelInfo);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return hotels;
	}

	public List<HotelInfo> search(String key, boolean blocked) {

		List<HotelInfo> hotels = new ArrayList<>();
		HotelInfo hotelInfo = new HotelInfo();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_INFO_SEARCH)) {

			preparedStatement.setBoolean(1, blocked);
			preparedStatement.setString(2, "%" + key + "%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				hotelInfo = new Mapping<HotelInfo>(HotelInfo.class)
						.convert(resultSet);
				hotels.add(hotelInfo);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("size : " + hotels.size());
		return hotels;
	}

}
