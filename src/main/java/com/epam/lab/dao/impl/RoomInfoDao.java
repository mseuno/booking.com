package com.epam.lab.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.BaseDao;
import com.epam.lab.dao.ConnectionManager;
import com.epam.lab.dao.queries.CreateQueries;
import com.epam.lab.model.helper.RoomInfo;

public class RoomInfoDao extends BaseDao<RoomInfo> {

	private static final Logger LOG = Logger.getLogger(RoomInfoDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	@Override
	public void update(RoomInfo roomInfo) {

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_ROOM_INFO_UPDATE)) {

			preparedStatement.setLong(1, roomInfo.getRoomId());
			preparedStatement.setString(2, roomInfo.getLocaleId());
			preparedStatement.setString(3, roomInfo.getName());
			preparedStatement.setString(4, roomInfo.getName());
			preparedStatement.execute();

		}

		catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
