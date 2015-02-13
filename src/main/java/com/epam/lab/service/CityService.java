package com.epam.lab.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.epam.lab.dao.impl.CityDao;
import com.epam.lab.model.City;
import com.epam.lab.model.Street;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.utils.Location;

public class CityService {

	private CityDao daoCity = new CityDao();

	@Deprecated
	public List<City> selectCityByRegionId(long id, String locale) {
		List<City> result = null;
		if (id != -1) {
			result = daoCity.readByRegionId(id, locale);
		}
		return result;
	}

	public List<City> selectFullInfoByName(String name) {
		return daoCity.readFullInfoByName(name);
	}

	public HashMap<City, Long> loadForLocation() {
		HashMap<City, Long> result = new HashMap<>();
		List<City> list = daoCity.read();
		for (int i = 0; i < list.size(); i++) {
			result.put(list.get(i), list.get(i).getRegionId());
		}
		return result;
	}

	public void delete(long id) {
		if (id != -1) {
			List<Street> streets = Location.getInstance().getStreetsList(id,
					"en");
			if (!streets.isEmpty()) {
				StreetService streetService = new StreetService();
				for (Street street : streets) {
					streetService.delete(street.getId());
				}
			}
			List<Locale> list = Location.getInstance().getLanguagesList();
			for (Locale language : list) {
				City street = new City();
				street.setId(id);
				street.setLocaleId(language.getId());
				daoCity.delete(street);
			}
			Location.getInstance().loadCity();
		}
	}

	public void create(String[] names, String[] locales, long countryId,
			long regionId) {
		if (regionId != -1 && countryId != -1) {
			if (names.length == locales.length) {
				long id = daoCity.getNewId();
				for (int i = 0; i < names.length || i < locales.length; i++) {
					City city = new City();
					city.setId(id);
					city.setLocaleId(locales[i]);
					city.setCountryId(countryId);
					city.setRegionId(regionId);
					city.setName(names[i]);
					daoCity.create(city);
				}
				Location.getInstance().loadCity();
			}
		}
	}

	public void update(String[] names, String[] locale, long id, long regionId,
			long countryId) {
		if (id != -1 && regionId != -1 && countryId != -1) {
			if (names.length == locale.length) {
				for (int i = 0; i < names.length; i++) {
					City city = new City();
					city.setId(id);
					city.setLocaleId(locale[i]);
					city.setRegionId(regionId);
					city.setCountryId(countryId);
					city.setName(names[i]);
					daoCity.update(city);
				}
				Location.getInstance().loadCity();
			}
		}
	}

	@Deprecated
	public List<City> refreshInfoForUpdate(String[] names, String[] locale,
			long id, long regionId, long countryId) {
		List<City> result = new ArrayList<>();
		if (names.length == locale.length) {
			if (id != 0) {
				for (int i = 0; i < names.length; i++) {
					City city = new City();
					city.setId(id);
					city.setLocaleId(locale[i]);
					city.setRegionId(regionId);
					city.setCountryId(countryId);
					city.setName(names[i]);
					result.add(city);
				}
			} else {
				for (int i = 0; i < names.length; i++) {
					City city = new City();
					city.setLocaleId(locale[i]);
					city.setName(names[i]);
					result.add(city);
				}
			}

		}
		return result;
	}
}
