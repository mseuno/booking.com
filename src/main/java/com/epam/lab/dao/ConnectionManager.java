package com.epam.lab.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConnectionManager {

	private static final String POOL_NAME_JNDI = "jdbc/pool";
	private static final String PREFIX = "java:/comp/env";

	private static final ConnectionManager INSTANCE = new ConnectionManager();

	private DataSource dataSource;

	private static final Logger LOG = Logger.getLogger(ConnectionManager.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	public static Connection getConnection() throws SQLException {
		return INSTANCE.dataSource.getConnection();
	}

	private ConnectionManager() {
		try {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup(PREFIX);
			dataSource = (DataSource) envContext.lookup(POOL_NAME_JNDI);
		} catch (NamingException e) {
			LOG.error(e.getMessage());
		}
	}

}
