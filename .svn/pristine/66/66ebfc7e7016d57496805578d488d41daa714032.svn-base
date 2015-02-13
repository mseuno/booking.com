package com.epam.lab.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.epam.lab.dao.impl.CountryDao;
import com.epam.lab.model.Country;
import com.epam.lab.model.Region;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.utils.Location;

public class CountryService {

	private CountryDao daoCountry = new CountryDao();

	public HashMap<Country, Long> loadForLocation() {

		HashMap<Country, Long> result = new HashMap<>();
		List<Country> list = daoCountry.read();
		for (int i = 0; i < list.size(); i++) {
			result.put(list.get(i), list.get(i).getId());
		}
		return result;
	}

	public void create(String[] names, String[] locales) {

		if (names.length == locales.length) {
			long id = daoCountry.getNewId();
			for (int i = 0; i < names.length; i++) {
				Country country = new Country();
				country.setId(id);
				country.setLocaleId(locales[i]);
				country.setName(names[i]);
				daoCountry.create(country);
			}
			Location.getInstance().loadCountry();
		}
	}

	public void update(String[] names, String[] locales, long id) {

		if (names.length == locales.length) {
			for (int i = 0; i < names.length; i++) {
				Country country = new Country();
				country.setId(id);
				country.setLocaleId(locales[i]);
				country.setName(names[i]);
				daoCountry.update(country);
			}
			Location.getInstance().loadCountry();
		}
	}

	public void delete(long id) {
		if (id != -1) {
			List<Region> regiones = Location.getInstance()
					.getRegionListSelectBox(id, "en");
			if (!regiones.isEmpty()) {
				RegionService regionService = new RegionService();
				for (Region region : regiones) {
					regionService.delete(region.getId());
				}
			}
			List<Locale> list = Location.getInstance().getLanguagesList();
			for (Locale language : list) {
				Country street = new Country();
				street.setId(id);
				street.setLocaleId(language.getId());
				daoCountry.delete(street);
			}
			Location.getInstance().loadCountry();
		}
	}

	public List<Country> refreshInfoForUpdate(String[] names, String[] locale,
			long id) {
		List<Country> result = new ArrayList<>();
		if (names.length == locale.length) {
			for (int i = 0; i < names.length; i++) {
				Country country = new Country();
				country.setId(id);
				country.setLocaleId(locale[i]);
				country.setName(names[i]);
				result.add(country);
			}
		}
		return result;
	}
}
