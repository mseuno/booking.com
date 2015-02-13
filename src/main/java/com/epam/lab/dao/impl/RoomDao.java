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
import com.epam.lab.model.Room;
import com.epam.lab.model.helper.RoomInfo;

public class RoomDao extends BaseDao<Room> {

	private static final Logger LOG = Logger.getLogger(RoomDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<Room> readByHotelId(long id, String locale) {
		return getRooms(id, locale, ReadQueries.SQL_ROOM_BY_HOTEL_ID);
	}

	public Room getRoomById(long id, String locale) {
		Room room = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_ROOM_READ_BY_HOTEL_ID)) {

			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, locale);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				room = new Mapping<Room>(Room.class).convert(resultSet);
				room.setRoomInfo(new Mapping<RoomInfo>(RoomInfo.class)
						.convert(resultSet));
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return room;
	}

	private List<Room> getRooms(long id, String locale, String query) {
		List<Room> result = new ArrayList<>();

		Room room = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(query)) {

			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				room = new Mapping<Room>(Room.class).convert(resultSet);

				try (PreparedStatement preparedStatementRoomInfo = connection
						.prepareStatement(ReadQueries.SQL_ROOM_INFO_BY_ROOM_ID)) {
					ResultSet resultSetRoomInfo = null;
					preparedStatementRoomInfo.setLong(1, room.getId());
					preparedStatementRoomInfo.setString(2, locale);
					resultSetRoomInfo = preparedStatementRoomInfo
							.executeQuery();

					// Перевірка, чи є інформація про готель на вибраній
					// локалі.
					// Якщо ні - витягуємо інформацію на англійській

					if (resultSetRoomInfo.first() == false) {
						preparedStatementRoomInfo.setLong(1, room.getId());
						preparedStatementRoomInfo.setString(2, "en");
						resultSetRoomInfo = preparedStatementRoomInfo
								.executeQuery();
						resultSetRoomInfo.next();
					}

					room.setRoomInfo(new Mapping<RoomInfo>(RoomInfo.class)
							.convert(resultSetRoomInfo));

				} catch (SQLException e) {
					e.printStackTrace();
				}

				result.add(room);
				room = null;
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public void setRoomQuantity(long quantity, long id) {

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(CreateQueries.SQL_ROOM_SET_ROOM_QUANTITY)) {

			preparedStatement.setLong(1, quantity);
			preparedStatement.setLong(2, id);
			preparedStatement.execute();

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
