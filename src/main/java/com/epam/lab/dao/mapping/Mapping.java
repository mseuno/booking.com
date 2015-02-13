package com.epam.lab.dao.mapping;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.annotations.Column;

public class Mapping<T> {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	protected Class<T> aclass;

	@SuppressWarnings("unchecked")
	public Mapping(@SuppressWarnings("rawtypes") Class aclass) {
		this.aclass = aclass;
	}

	public T convert(ResultSet resultSet) throws SQLException {
		T result = null;
		try {
			result = (T) aclass.newInstance();
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
			LOG.error(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException | IllegalArgumentException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

}
