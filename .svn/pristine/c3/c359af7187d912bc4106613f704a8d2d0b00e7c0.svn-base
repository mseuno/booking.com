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
import com.epam.lab.model.Gallery;

public class GalleryDao extends BaseDao<Gallery> {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<Gallery> readHotelGallery(long hotel_id) {

		List<Gallery> result = new ArrayList<>();
		Gallery gallery = null;

		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_HOTEL_GALLERY_BY_HOTEL_ID)) {

			preparedStatement.setLong(1, hotel_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gallery = new Mapping<Gallery>(Gallery.class)
						.convert(resultSet);
				result.add(gallery);
				gallery = null;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

}
