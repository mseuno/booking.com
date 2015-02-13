package com.epam.lab.service;

import java.util.HashMap;
import java.util.List;

import com.epam.lab.dao.impl.StreetDao;
import com.epam.lab.model.Street;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.utils.Location;

public class StreetService {

	private StreetDao daoStreet = new StreetDao();

	public HashMap<Street, Long> loadForLocation() {
		HashMap<Street, Long> result = new HashMap<>();
		List<Street> list = daoStreet.read();
		for (int i = 0; i < list.size(); i++) {
			result.put(list.get(i), list.get(i).getCityId());
		}
		return result;
	}

	public void create(String[] names, String[] locales, long cityId,
			long regionId, long countryId) {
		if (cityId != -1) {
			if (names.length == locales.length) {
				long id = daoStreet.getNewId();
				for (int i = 0; i < names.length || i < locales.length; i++) {
					Street street = new Street();
					street.setId(id);
					street.setLocaleId(locales[i]);
					street.setCityId(cityId);
					street.setRegionId(regionId);
					street.setCountryId(countryId);
					street.setName(names[i]);
					daoStreet.create(street);
				}

				Location.getInstance().loadStreet();
			}
		}
	}

	public void update(String[] names, String[] locales, long id, long cityId) {
		if (cityId != -1 && id != -1) {
			if (names.length == locales.length) {
				for (int i = 0; i < names.length || i < locales.length; i++) {
					Street street = new Street();
					street.setId(id);
					street.setLocaleId(locales[i]);
					street.setCityId(cityId);
					street.setName(names[i]);
					daoStreet.update(street);
				}
				Location.getInstance().loadStreet();
			}
		}
	}

	public void delete(long id) {
		if (id != -1) {
			List<Locale> list = Location.getInstance().getLanguagesList();
			for (Locale language : list) {
				Street street = new Street();
				street.setId(id);
				street.setLocaleId(language.getId());
				daoStreet.delete(street);
			}
			Location.getInstance().loadStreet();
		}
	}
}
