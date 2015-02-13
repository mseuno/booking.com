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
import com.epam.lab.model.helper.HotelesServices;

public class HotelServiceDao extends BaseDao<HotelesServices> {

	public List<HotelesServices> readServicesListByHotelId(long id) {

		List<HotelesServices> result = new ArrayList<>();
		HotelesServices service = null;

		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_SERVICES_BY_HOTEL_ID)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				service = new Mapping<HotelesServices>(HotelesServices.class)
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
