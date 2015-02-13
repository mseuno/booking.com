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
import com.epam.lab.model.helper.ManagerMessage;

public class ManagerMessageDao extends BaseDao<ManagerMessage> {

	private static final Logger LOG = Logger.getLogger(ManagerMessageDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public List<ManagerMessage> readFromTheEnd() {

		List<ManagerMessage> result = new ArrayList<>();
		ManagerMessage message = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_ADMIN_READ_MANAGER_REQUEST)) {

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				message = new Mapping<ManagerMessage>(ManagerMessage.class)
						.convert(resultSet);
				result.add(message);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

	public List<ManagerMessage> getImportantSendMessage(int send, int important) {

		List<ManagerMessage> result = new ArrayList<>();
		ManagerMessage message = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_MANAGER_READ_MESSAGE_IMPORTANT_SEND)) {

			preparedStatement.setInt(1, send);
			preparedStatement.setInt(2, important);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				message = new Mapping<ManagerMessage>(ManagerMessage.class)
						.convert(resultSet);
				result.add(message);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

	public List<ManagerMessage> getMessageByStatus(int status) {

		List<ManagerMessage> result = new ArrayList<>();
		ManagerMessage message = null;
		ResultSet resultSet = null;

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(ReadQueries.SQL_MANAGER_READ_MESSAGE_BY_STATUS)) {

			preparedStatement.setInt(1, status);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				message = new Mapping<ManagerMessage>(ManagerMessage.class)
						.convert(resultSet);
				result.add(message);
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;

	}

}
