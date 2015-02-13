package com.epam.lab.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import javax.servlet.http.HttpServletRequest;

public class ResourceBundleManager {

	private ResourceBundle bundle = null;
	private String Bundle_Base = "locale.i18n";
	private UTF8Control control = new UTF8Control();

	public ResourceBundle getBundle(Locale locale) {

		try {
			bundle = ResourceBundle.getBundle(Bundle_Base, locale, control);
		} catch (Exception e) {

			bundle = ResourceBundle.getBundle(Bundle_Base, Locale.ENGLISH,
					control);
		}

		return bundle;
	}

	public ResourceBundle getBundle(HttpServletRequest req) {

		try {
			Locale locale = req.getLocale();
			bundle = ResourceBundle.getBundle(Bundle_Base, locale, control);
		} catch (Exception e) {

			bundle = ResourceBundle.getBundle(Bundle_Base, Locale.ENGLISH,
					control);
		}

		return bundle;
	}

	private static class UTF8Control extends Control {

		public ResourceBundle newBundle(String baseName, Locale locale,
				String format, ClassLoader loader, boolean reload)
				throws IllegalAccessException, InstantiationException,
				IOException {
			// The below is a copy of the default implementation.
			String bundleName = toBundleName(baseName, locale);
			String resourceName = toResourceName(bundleName, "properties");
			ResourceBundle bundle = null;
			InputStream stream = null;
			if (reload) {
				URL url = loader.getResource(resourceName);
				if (url != null) {
					URLConnection connection = url.openConnection();
					if (connection != null) {
						connection.setUseCaches(false);
						stream = connection.getInputStream();
					}
				}
			} else {
				stream = loader.getResourceAsStream(resourceName);
			}
			if (stream != null) {
				try {
					// Only this line is changed to make it to read properties
					// files
					// as UTF-8.
					bundle = new PropertyResourceBundle(new InputStreamReader(
							stream, "UTF-8"));
				} finally {
					stream.close();
				}
			}
			return bundle;
		}
	}

	public ResourceBundle getBundle(String baseName) {

		try {
			bundle = ResourceBundle.getBundle(baseName, control);
		} catch (Exception e) {

		}

		return bundle;
	}

}
