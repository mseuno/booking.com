package com.epam.lab.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

public abstract class BaseDao<T> {

	protected Class<T> aclass;
	private List<Object> values = new ArrayList<>();
	private static final Logger LOG = Logger.getLogger(BaseDao.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	@SuppressWarnings("unchecked")
	protected BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		this.aclass = (Class<T>) parameterizedType.getActualTypeArguments()[0];

		if (!aclass.isAnnotationPresent(Table.class)) {
			LOG.error("annotation @Table doesn't exist in class : "
					+ aclass.getSimpleName());
		}

	}

	public Long create(T obj) {

		Long result = null;
		String sql = queryCreate(obj);

		ResultSet generatedKeys = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql,
								PreparedStatement.RETURN_GENERATED_KEYS)) {
			for (int i = 0; i < values.size(); i++) {
				preparedStatement.setObject(i + 1, values.get(i));
			}
			preparedStatement.executeUpdate();
			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = generatedKeys.getLong(1);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// Out of range column
			if (e.getSQLState().equals("22001")) {
				result = (long) -22001;
				LOG.error(e.getMessage());
			} else {
				LOG.error(e.getMessage());
				e.printStackTrace();

			}

		} finally {
			values.clear();
			if (generatedKeys != null) {
				try {
					generatedKeys.close();
				} catch (SQLException e) {
					LOG.error(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public T read(T obj) {
		T result = null;
		String sql = queryRead(obj);
		ResultSet resultSet = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql)) {
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = mapping(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return result;
	}

	public List<T> read() {

		List<T> result = new ArrayList<>();
		T entity = null;
		ResultSet resultSet = null;

		String sql = "SELECT * FROM "
				+ aclass.getAnnotation(Table.class).name();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql)) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				entity = mapping(resultSet);
				result.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return result;
	}

	public void update(T obj) {

		String sql = queryUpdate(obj);

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql)) {
			for (int i = 0; i < values.size(); i++) {
				preparedStatement.setObject(i + 1, values.get(i));
			}
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		} finally {
			values.clear();
		}
	}

	public void delete(T obj) {

		String sql = queryDelete(obj);

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql)) {

			preparedStatement.execute();

		} catch (SQLException | NullPointerException e) {

			System.out.println(((SQLException) e).getSQLState());
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
	}

	private String queryRead(T obj) {
		Field fileds[] = aclass.getDeclaredFields();
		StringBuilder result = new StringBuilder();
		StringBuilder firstPart = new StringBuilder();
		try {
			// READ BY ID
			firstPart.append("SELECT * FROM ");
			firstPart.append(aclass.getAnnotation(Table.class).name());
			firstPart.append(" WHERE ");
			for (int i = 0; i < fileds.length; i++) {
				Field field = fileds[i];
				if (field.isAnnotationPresent(Column.class)) {
					field.setAccessible(true);
					if (field.isAnnotationPresent(Id.class)) {
						firstPart.append(field.getAnnotation(Column.class)
								.name());
						firstPart.append("='");
						firstPart.append(field.get(obj));
						firstPart.append("' AND ");
					}
				}
			}
			result.append(firstPart.substring(0, firstPart.length() - 4));
			System.out.println(result.toString());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return result.toString();
	}

	private String queryDelete(T obj) {
		Field fileds[] = aclass.getDeclaredFields();
		StringBuilder result = new StringBuilder();
		StringBuilder firstPart = new StringBuilder();
		firstPart.append("DELETE FROM ");
		firstPart.append(aclass.getAnnotation(Table.class).name());
		firstPart.append(" WHERE ");
		try {
			for (int i = 0; i < fileds.length; i++) {
				Field field = fileds[i];
				if (field.isAnnotationPresent(Column.class)) {
					field.setAccessible(true);
					if (field.isAnnotationPresent(Id.class)) {
						firstPart.append(field.getAnnotation(Column.class)
								.name());
						firstPart.append("='");
						firstPart.append(field.get(obj));
						firstPart.append("' AND ");
					}
				}
			}
			result.append(firstPart.substring(0, firstPart.length() - 4));
			System.out.println(result.toString());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return result.toString();
	}

	private String queryUpdate(T obj) {
		Field fileds[] = aclass.getDeclaredFields();
		StringBuilder result = new StringBuilder();
		StringBuilder firstPart = new StringBuilder();
		StringBuilder secondPart = new StringBuilder();
		try {
			firstPart.append("UPDATE ");
			firstPart.append(aclass.getAnnotation(Table.class).name());
			firstPart.append(" SET ");
			secondPart.append(" WHERE ");
			for (Field field : fileds) {
				field.setAccessible(true);
				if (field.get(obj) != null) {
					if (field.isAnnotationPresent(Column.class)) {
						if (field.isAnnotationPresent(Id.class)) {
							secondPart.append(field.getAnnotation(Column.class)
									.name());
							secondPart.append("='");
							secondPart.append(field.get(obj));
							secondPart.append("' ");
							secondPart.append("AND ");

						} else {
							firstPart.append(field.getAnnotation(Column.class)
									.name());
							firstPart.append("=?,");
							values.add(field.get(obj));
						}
					}
				}
			}
			result.append(firstPart.substring(0, firstPart.length() - 1));
			result.append(secondPart.substring(0, secondPart.length() - 4));
			System.out.println(result.toString());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return result.toString();
	}

	private String queryCreate(T obj) {
		Field fileds[] = aclass.getDeclaredFields();
		StringBuilder result = new StringBuilder();
		StringBuilder firstPart = new StringBuilder();
		StringBuilder secondPart = new StringBuilder();
		try {
			firstPart.append("INSERT INTO ");
			firstPart.append(aclass.getAnnotation(Table.class).name());
			firstPart.append(" (");
			secondPart.append("VALUES(");
			for (int i = 0; i < fileds.length; i++) {
				Field field = fileds[i];
				if (field.isAnnotationPresent(Column.class)) {
					field.setAccessible(true);
					if (field.get(obj) != null) {
						firstPart.append(field.getAnnotation(Column.class)
								.name());
						values.add(field.get(obj));
						secondPart.append("?");
						secondPart.append(",");
						firstPart.append(",");
					}
				}
			}
			result.append(firstPart.substring(0, firstPart.length() - 1));
			result.append(") ");
			result.append(secondPart.substring(0, secondPart.length() - 1));
			result.append(")");

			System.out.println(result.toString());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		return result.toString();
	}

	private T mapping(ResultSet resultSet) throws SQLException {
		T result = null;
		try {
			result = aclass.newInstance();
			Field fileds[] = aclass.getDeclaredFields();
			if (resultSet != null) {
				for (Field field : fileds) {
					if (field.isAnnotationPresent(Column.class)) {
						field.setAccessible(true);
						if (resultSet.getObject(field.getAnnotation(
								Column.class).name()) != null) {
							field.set(
									result,
									resultSet.getObject(field.getAnnotation(
											Column.class).name()));
						}
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public Long getNewId() {
		String sql = "SELECT id FROM "
				+ aclass.getAnnotation(Table.class).name()
				+ " ORDER BY -id LIMIT 1";
		ResultSet resultSet = null;
		Long result = null;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql)) {

			resultSet = preparedStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				result = resultSet.getLong("id");
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result + 1;
	}
}
