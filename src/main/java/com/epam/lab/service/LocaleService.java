package com.epam.lab.service;

import java.util.List;

import com.epam.lab.dao.impl.LocaleDao;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.utils.Location;

public class LocaleService {

	private LocaleDao daoLocale = new LocaleDao();

	public List<Locale> read() {
		return daoLocale.read();
	}

	public Locale getLocaleById(String id) {
		return daoLocale.getLocaleById(id);
	}

	public void updateLocale(Locale locale, String oldId) {
		daoLocale.updateLocale(locale, oldId);
		Location.getInstance().loadLanguages();
	}

	public void createLocale(Locale locale) {
		daoLocale.create(locale);
		Location.getInstance().loadLanguages();
	}

}
