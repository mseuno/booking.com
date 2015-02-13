package com.epam.lab.service;

import java.util.HashMap;
import java.util.List;

import com.epam.lab.dao.impl.RegionDao;
import com.epam.lab.model.City;
import com.epam.lab.model.Region;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.utils.Location;

public class RegionService {

	private RegionDao daoRegion = new RegionDao();

	public List<Region> selectFullInfoByName(String name) {
		return daoRegion.readFullInfoByName(name);
	}

	public HashMap<Region, Long> loadForLocation() {
		HashMap<Region, Long> result = new HashMap<>();
		List<Region> list = daoRegion.read();
		for (int i = 0; i < list.size(); i++) {
			result.put(list.get(i), list.get(i).getCountryId());
		}
		return result;
	}

	public void create(String[] names, String[] locales, long countryId) {
		if (names.length == locales.length) {
			long id = daoRegion.getNewId();
			for (int i = 0; i < names.length; i++) {
				Region region = new Region();
				region.setId(id);
				region.setCountryId(countryId);
				region.setName(names[i]);
				region.setLocaleId(locales[i]);
				daoRegion.create(region);
			}

			Location.getInstance().loadRegion();
		}
	}

	public void delete(long id) {
		if (id != -1) {
			List<City> cities = Location.getInstance().getCitiesList(id, "en");
			if (!cities.isEmpty()) {
				CityService cityService = new CityService();
				for (City city : cities) {
					cityService.delete(city.getId());
				}
			}
			List<Locale> list = Location.getInstance().getLanguagesList();
			for (Locale language : list) {
				Region region = new Region();
				region.setId(id);
				region.setLocaleId(language.getId());
				daoRegion.delete(region);
			}
			Location.getInstance().loadRegion();
		}
	}

	public void update(String[] names, String[] locales, long id, long countryId) {
		if (names.length == locales.length) {
			for (int i = 0; i < names.length; i++) {
				Region region = new Region();
				region.setId(id);
				region.setCountryId(countryId);
				region.setName(names[i]);
				region.setLocaleId(locales[i]);
				daoRegion.update(region);
			}
			Location.getInstance().loadRegion();
		}
	}
}
