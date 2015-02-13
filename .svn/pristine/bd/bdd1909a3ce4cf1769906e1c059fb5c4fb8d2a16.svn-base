package com.epam.lab.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.impl.AdminDao;
import com.epam.lab.dao.impl.ManagerMessageDao;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.exceptions.DuplicateUniqueKeyException;
import com.epam.lab.model.Admin;
import com.epam.lab.model.City;
import com.epam.lab.model.Country;
import com.epam.lab.model.Region;
import com.epam.lab.model.Service;
import com.epam.lab.model.Street;
import com.epam.lab.model.helper.ManagerMessage;
import com.epam.lab.utils.Location;

public class AdminService {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	private AdminDao adminDao = new AdminDao();

	public Admin selectAdminByEmailAndPassword(String email, String password) {
		return adminDao.readByEmailAndPassword(email, password);
	}

	public List<ManagerMessage> readManagerMessages() {
		return new ManagerMessageDao().readFromTheEnd();
	}

	public List<ManagerMessage> readManagerMessages(int status) {
		return new ManagerMessageDao().getMessageByStatus(status);
	}

	public void updateMessage(ManagerMessage message) {
		if (message.getId() != -1) {
			new ManagerMessageDao().update(message);
		}
	}

	public List<Country> pickCountriesByName(Map<String, String[]> map) {

		String name = null;
		String language = null;

		for (Map.Entry<String, String[]> entry : map.entrySet()) {

			if (entry.getKey().equals("search_name")) {
				name = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_locale_id")) {
				language = entry.getValue()[0];
			}
		}
		if (name != null && language != null) {
			return Location.getInstance().getCountryList(name.toLowerCase(),
					language);
		} else {
			return null;
		}

	}

	public List<Region> pickRegionsByName(Map<String, String[]> map) {

		String name = null;
		String language = null;
		long countryId = -1;

		for (Map.Entry<String, String[]> entry : map.entrySet()) {

			if (entry.getKey().equals("search_name")) {
				name = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_locale_id")) {
				language = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_country_id")) {
				countryId = toLong(entry.getValue()[0]);
			}
		}
		if (name != null && language != null) {
			return Location.getInstance().getRegionList(name.toLowerCase(),
					language, countryId);
		} else {
			return null;
		}

	}

	public List<City> pickCitiesByName(Map<String, String[]> map) {

		String name = null;
		String language = null;
		long countryId = -1;
		long regionId = -1;

		for (Map.Entry<String, String[]> entry : map.entrySet()) {

			if (entry.getKey().equals("search_name")) {
				name = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_locale_id")) {
				language = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_country_id")) {
				countryId = toLong(entry.getValue()[0]);
			}
			if (entry.getKey().equals("search_region_id")) {
				regionId = toLong(entry.getValue()[0]);
			}
		}
		if (name != null && language != null) {
			return Location.getInstance().getCitiesList(name.toLowerCase(),
					countryId, regionId, language);
		} else {
			return null;
		}
	}

	public List<Street> pickStreetsByName(Map<String, String[]> map) {

		String name = null;
		String language = null;
		long countryId = -1;
		long regionId = -1;
		long cityId = -1;

		for (Map.Entry<String, String[]> entry : map.entrySet()) {

			if (entry.getKey().equals("search_name")) {
				name = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_locale_id")) {
				language = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_country_id")) {
				countryId = toLong(entry.getValue()[0]);
			}
			if (entry.getKey().equals("search_region_id")) {
				regionId = toLong(entry.getValue()[0]);
			}
			if (entry.getKey().equals("search_city_id")) {
				cityId = toLong(entry.getValue()[0]);
			}
		}
		if (name != null && language != null) {
			return Location.getInstance().getStreetsList(name.toLowerCase(),
					countryId, regionId, cityId, language);
		} else {
			return null;
		}
	}

	public List<Service> pickServiceByName(Map<String, String[]> map) {
		String name = null;
		String language = null;

		for (Map.Entry<String, String[]> entry : map.entrySet()) {

			if (entry.getKey().equals("search_name")) {
				name = entry.getValue()[0];
			}
			if (entry.getKey().equals("search_locale_id")) {
				language = entry.getValue()[0];
			}
		}
		if (name != null && language != null) {
			return Location.getInstance().getServicesList(name.toLowerCase(),
					language);
		} else {
			return null;
		}
	}

	public String registerNewAdmin(Admin admin) {
		String result = null;
		try {
			adminDao.registerNewAdmin(admin);
		} catch (DuplicateUniqueKeyException e) {
			result = "Admin with such email exist!";
			LOG.warn(result);
		}
		return result;
	}

	private long toLong(String str) {
		long result = -1;
		try {
			result = Long.parseLong(str);
		} catch (NumberFormatException e) {

		}
		return result;
	}

	public void updateAdmin(Admin admin) {
		adminDao.update(admin);
	}
}
