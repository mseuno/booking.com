package com.epam.lab.service;

import java.util.HashMap;
import java.util.List;

import com.epam.lab.dao.impl.ServiceDao;
import com.epam.lab.model.Service;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.utils.Location;

public class ServiceService {

	private ServiceDao daoService = new ServiceDao();

	public List<Service> selectServiceByLocale(String language) {

		if (language.equals("search_all")) {
			return daoService.read();
		} else {
			return daoService.selectServiceByLocale(language);
		}
	}

	public void update(String[] names, String[] locales, long id) {

		if (id != -1) {
			if (names.length == locales.length) {
				for (int i = 0; i < names.length; i++) {
					Service service = new Service();
					service.setId(id);
					service.setLocaleId(locales[i]);
					service.setName(names[i]);
					daoService.update(service);
				}
			}
		}
	}

	public void create(String[] names, String[] locales) {
		if (names.length == locales.length) {
			long id = daoService.getNewId();
			for (int i = 0; i < names.length; i++) {
				Service service = new Service();
				service.setId(id);
				service.setLocaleId(locales[i]);
				service.setName(names[i]);
				daoService.create(service);
			}
			Location.getInstance().loadServices();
		}
	}

	public void delete(long id) {
		if (id != -1) {
			List<Locale> list = Location.getInstance().getLanguagesList();
			for (Locale locale : list) {
				Service service = new Service();
				service.setId(id);
				service.setLocaleId(locale.getId());
				daoService.delete(service);
			}
			Location.getInstance().loadServices();
		}
	}

	public HashMap<Service, String> loadForLocation() {
		HashMap<Service, String> result = new HashMap<>();
		List<Service> list = daoService.read();
		for (int i = 0; i < list.size(); i++) {
			result.put(list.get(i), list.get(i).getLocaleId());
		}
		return result;
	}
}
