package com.epam.lab.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.lab.model.City;
import com.epam.lab.model.Country;
import com.epam.lab.model.Region;
import com.epam.lab.model.Service;
import com.epam.lab.model.Street;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.service.CityService;
import com.epam.lab.service.CountryService;
import com.epam.lab.service.LocaleService;
import com.epam.lab.service.RegionService;
import com.epam.lab.service.ServiceService;
import com.epam.lab.service.StreetService;

public class Location {

	private static Location instance;

	// value - id
	private static HashMap<Country, Long> countryMap = null;
	// value - country id
	private static HashMap<Region, Long> regionMap = null;
	// value - region id
	private static HashMap<City, Long> cityMap = null;
	// value = city id
	private static HashMap<Street, Long> streetMap = null;
	private static List<Locale> languages = null;
	// value locale id
	private static HashMap<Service, String> serviceMap = null;

	public List<Street> getStreet(Long id) {

		List<Street> result = new ArrayList<>();
		for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {
			if (map.getKey().getId().equals(id)) {
				result.add(map.getKey());
			}
		}
		return result;
	}

	public List<Street> getStreetsList(Long countryId, Long regionId,
			Long cityId, String language) {

		List<Street> result = new ArrayList<>();

		if (countryId == -1) {
			if (language.equals("serach_all")) {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					result.add(map.getKey());
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getLocaleId().equals(language)) {
						result.add(map.getKey());
					}
				}

			}
			return result;
		}

		if (regionId == -1) {
			if (language.equals("serach_all")) {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getCountryId().equals(countryId)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getLocaleId().equals(language)
							&& map.getKey().getCountryId().equals(countryId)) {
						result.add(map.getKey());
					}
				}

			}
			return result;
		}

		if (cityId == -1) {
			if (language.equals("serach_all")) {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getRegionId().equals(regionId)
							&& map.getKey().getCountryId().equals(countryId)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getLocaleId().equals(language)
							&& map.getKey().getCountryId().equals(countryId)
							&& map.getKey().getRegionId().equals(regionId)) {
						result.add(map.getKey());
					}
				}

			}
			return result;
		}

		if (language.equals("serach_all")) {
			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {
				if (map.getKey().getRegionId().equals(regionId)
						&& map.getKey().getCountryId().equals(countryId)
						&& map.getValue().equals(cityId)) {
					result.add(map.getKey());
				}
			}
		} else {
			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {
				if (map.getKey().getLocaleId().equals(language)
						&& map.getKey().getCountryId().equals(countryId)
						&& map.getKey().getRegionId().equals(regionId)
						&& map.getValue().equals(cityId)) {
					result.add(map.getKey());
				}
			}

		}
		return result;
	}

	public List<Street> getStreetsList(String name, Long countryId,
			Long regionId, Long cityId, String language) {

		List<Street> result = new ArrayList<>();

		if (countryId == -1) {
			if (language.equals("serach_all")) {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getName().toLowerCase().contains(name)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getLocaleId().equals(language)
							&& map.getKey().getName().toLowerCase()
									.contains(name)) {
						result.add(map.getKey());
					}
				}

			}
			return result;
		}

		if (regionId == -1) {
			if (language.equals("serach_all")) {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getCountryId().equals(countryId)
							&& map.getKey().getName().toLowerCase()
									.contains(name)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getLocaleId().equals(language)
							&& map.getKey().getCountryId().equals(countryId)
							&& map.getKey().getName().toLowerCase()
									.contains(name)) {
						result.add(map.getKey());
					}
				}

			}
			return result;
		}

		if (cityId == -1) {
			if (language.equals("serach_all")) {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getRegionId().equals(regionId)
							&& map.getKey().getCountryId().equals(countryId)
							&& map.getKey().getName().toLowerCase()
									.contains(name)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getKey().getLocaleId().equals(language)
							&& map.getKey().getCountryId().equals(countryId)
							&& map.getKey().getRegionId().equals(regionId)
							&& map.getKey().getName().toLowerCase()
									.contains(name)) {
						result.add(map.getKey());
					}
				}

			}
			return result;
		}

		if (language.equals("serach_all")) {
			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {
				if (map.getKey().getRegionId().equals(regionId)
						&& map.getKey().getCountryId().equals(countryId)
						&& map.getValue().equals(cityId)
						&& map.getKey().getName().toLowerCase().contains(name)) {
					result.add(map.getKey());
				}
			}
		} else {
			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {
				if (map.getKey().getLocaleId().equals(language)
						&& map.getKey().getCountryId().equals(countryId)
						&& map.getKey().getRegionId().equals(regionId)
						&& map.getValue().equals(cityId)
						&& map.getKey().getName().toLowerCase().contains(name)) {
					result.add(map.getKey());
				}
			}

		}
		return result;
	}

	public List<Street> getStreetsList(Long cityId, String language) {

		List<Street> result = new ArrayList<>();

		if (language.equals("search_all") || language == null) {

			if (cityId == -1) {

				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					result.add(map.getKey());
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {
					if (map.getValue().equals(cityId)) {
						result.add(map.getKey());
					}
				}
			}

		} else {
			if (cityId == -1) {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {

					if (map.getKey().getLocaleId().equals(language)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<Street, Long> map : Location.streetMap
						.entrySet()) {

					if (map.getKey().getLocaleId().equals(language)
							&& map.getValue().equals(cityId)) {
						result.add(map.getKey());
					}
				}
			}

		}

		return result;

	}

	@Deprecated
	public List<Street> getStreetsList(Long cityId) {

		List<Street> result = new ArrayList<>();

		if (cityId == -1) {

			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {
			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {

				if (map.getValue().equals(cityId)) {
					result.add(map.getKey());
				}
			}
		}

		return result;

	}

	public List<Street> getStreetsList(String language) {

		List<Street> result = new ArrayList<>();

		if (language.equals("search_all") || language == null) {

			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {
			for (Map.Entry<Street, Long> map : Location.streetMap.entrySet()) {

				if (map.getKey().getLocaleId().equals(language)) {
					result.add(map.getKey());
				}
			}
		}

		return result;

	}

	public List<City> getCity(Long id) {

		List<City> result = new ArrayList<>();
		for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
			if (map.getKey().getId().equals(id)) {
				result.add(map.getKey());
			}
		}
		return result;
	}

	public List<City> getCitiesList(Long countryId, Long regionId,
			String language) {
		List<City> result = new ArrayList<>();

		if (countryId == -1) {
			for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {

			for (Map.Entry<Region, Long> map : Location.regionMap.entrySet()) {
				if (map.getKey().getId().equals(regionId)) {
					if (map.getKey().getCountryId().equals(countryId)) {
						break;
					} else {
						regionId = (long) -1;
						break;
					}
				}
			}
			if (language.equals("search_all")) {
				if (regionId == -1) {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getCountryId().equals(countryId)) {
							result.add(map.getKey());
						}
					}
				} else {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getCountryId().equals(countryId)
								&& map.getValue().equals(regionId)) {
							result.add(map.getKey());
						}
					}
				}
			} else {
				if (regionId == -1) {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getCountryId().equals(countryId)
								& map.getKey().getLocaleId().equals(language)) {
							result.add(map.getKey());
						}
					}
				} else {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getCountryId().equals(countryId)
								&& map.getValue().equals(regionId)
								&& map.getKey().getLocaleId().equals(language)) {
							result.add(map.getKey());
						}
					}
				}
			}
		}
		return result;
	}

	public List<City> getCitiesList(String name, Long countryId, Long regionId,
			String language) {

		List<City> result = new ArrayList<>();

		if (language.equals("search_all")) {
			if (countryId == -1) {
				for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
					if (map.getKey().getName().toLowerCase().contains(name)) {
						result.add(map.getKey());
					}
				}
			} else {
				if (regionId == -1) {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getName().toLowerCase().contains(name)
								&& map.getKey().getCountryId()
										.equals(countryId)) {
							result.add(map.getKey());
						}
					}
				} else {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getName().toLowerCase().contains(name)
								&& map.getKey().getCountryId()
										.equals(countryId)
								&& map.getValue().equals(regionId)) {
							result.add(map.getKey());
						}
					}
				}
			}
		} else {
			if (countryId == -1) {
				for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
					if (map.getKey().getName().toLowerCase().contains(name)
							&& map.getKey().getLocaleId().equals(language)) {
						result.add(map.getKey());
					}
				}
			} else {
				if (regionId == -1) {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getName().toLowerCase().contains(name)
								&& map.getKey().getCountryId()
										.equals(countryId)
								&& map.getValue().equals(language)) {
							result.add(map.getKey());
						}
					}
				} else {
					for (Map.Entry<City, Long> map : Location.cityMap
							.entrySet()) {
						if (map.getKey().getName().toLowerCase().contains(name)
								&& map.getKey().getCountryId()
										.equals(countryId)
								&& map.getValue().equals(regionId)
								&& map.getKey().getLocaleId().equals(language)) {
							result.add(map.getKey());
						}
					}
				}
			}
		}
		return result;
	}

	public List<City> getCitiesList(Long regionId, String language) {

		List<City> result = new ArrayList<>();

		if (language.equals("search_all") || language == null) {
			if (regionId == -1) {
				for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
					result.add(map.getKey());
				}
			} else {
				for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
					if (map.getValue().equals(regionId)) {
						result.add(map.getKey());
					}
				}
			}
		} else {
			if (regionId == -1) {
				for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
					if (map.getKey().getLocaleId().equals(language)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {

					if (map.getKey().getLocaleId().equals(language)
							&& map.getValue().equals(regionId)) {
						result.add(map.getKey());
					}
				}
			}
		}
		return result;
	}

	public List<City> getCitiesListSelectBox(Long countryId, Long regionId,
			String language) {
		List<City> result = new ArrayList<>();
		for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
			if (map.getValue().equals(regionId)
					&& map.getKey().getCountryId().equals(countryId)
					&& map.getKey().getLocaleId().equals(language)) {
				result.add(map.getKey());
			}
		}
		return result;
	}

	@Deprecated
	public List<City> getCitiesList(Long regionId) {

		List<City> result = new ArrayList<>();

		if (regionId == -1) {
			for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {
			for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {

				if (map.getValue().equals(regionId)) {
					result.add(map.getKey());
				}
			}
		}
		return result;
	}

	public List<City> getCitiesList(String language) {

		List<City> result = new ArrayList<>();

		if (language.equals("search_all") || language == null) {
			for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {
			for (Map.Entry<City, Long> map : Location.cityMap.entrySet()) {
				if (map.getKey().getLocaleId().equals(language)) {
					result.add(map.getKey());
				}
			}
		}
		return result;
	}

	public List<Region> getRegionList(String name, String language,
			long countryId) {

		List<Region> result = new ArrayList<>();
		if (language.equals("search_all")) {
			if (countryId == -1) {

				for (Map.Entry<Region, Long> map : Location.regionMap
						.entrySet()) {
					if (map.getKey().getName().toLowerCase().contains(name)) {
						result.add(map.getKey());
					}
				}
			} else {

				for (Map.Entry<Region, Long> map : Location.regionMap
						.entrySet()) {
					if (map.getKey().getName().toLowerCase().contains(name)
							&& map.getValue().equals(countryId)) {
						result.add(map.getKey());
					}
				}
			}
		} else {
			if (countryId == -1) {

				for (Map.Entry<Region, Long> map : Location.regionMap
						.entrySet()) {
					if (map.getKey().getName().toLowerCase().contains(name)
							&& map.getKey().getLocaleId().equals(language)) {
						result.add(map.getKey());
					}
				}
			} else {
				for (Map.Entry<Region, Long> map : Location.regionMap
						.entrySet()) {
					if (map.getKey().getName().toLowerCase().contains(name)
							&& map.getKey().getLocaleId().equals(language)
							&& map.getValue().equals(countryId)) {
						result.add(map.getKey());
					}
				}
			}
		}
		return result;
	}

	public List<Region> getRegionListSelectBox(Long countryId, String language) {

		if (countryId == -1) {
			return null;
		} else {
			return getRegionList(countryId, language);

		}
	}

	public List<Region> getRegionList(Long countryId, String language) {

		List<Region> result = new ArrayList<>();
		if (countryId == -1) {
			for (Map.Entry<Region, Long> map : Location.regionMap.entrySet()) {
				if (map.getKey().getLocaleId().equals(language)) {

					result.add(map.getKey());
				}
			}
		} else {
			for (Map.Entry<Region, Long> map : Location.regionMap.entrySet()) {
				if (map.getValue().equals(countryId)
						&& map.getKey().getLocaleId().equals(language)) {

					result.add(map.getKey());
				}
			}
		}
		return result;
	}

	@Deprecated
	public List<Region> getRegionList(Long countryId) {

		List<Region> result = new ArrayList<>();
		for (Map.Entry<Region, Long> map : Location.regionMap.entrySet()) {
			if (map.getValue().equals(countryId)) {
				result.add(map.getKey());
			}
		}
		return result;
	}

	public List<Region> getRegion(Long id) {

		List<Region> result = new ArrayList<>();
		for (Map.Entry<Region, Long> map : Location.regionMap.entrySet()) {
			if (map.getKey().getId().equals(id)) {
				result.add(map.getKey());
			}
		}
		return result;
	}

	public List<Region> getRegionList(String language) {

		List<Region> result = new ArrayList<>();
		if (language == null || language.equals("search_all")) {
			for (Map.Entry<Region, Long> map : Location.regionMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {
			for (Map.Entry<Region, Long> map : Location.regionMap.entrySet()) {

				if (map.getKey().getLocaleId().equals(language)) {
					result.add(map.getKey());
				}
			}
		}
		return result;
	}

	public List<Country> getCountry(Long id) {

		List<Country> result = new ArrayList<>();
		for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
			if (map.getValue().equals(id)) {
				result.add(map.getKey());
			}
		}
		return result;
	}

	public List<Country> getCountryList(String name, String language) {
		List<Country> result = new ArrayList<>();

		if (language.equals("search_all")) {
			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				if (map.getKey().getName().toLowerCase().contains(name)) {
					result.add(map.getKey());
				}
			}
		} else {
			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				if (map.getKey().getName().toLowerCase().contains(name)
						&& map.getKey().getLocaleId().equals(language)) {

					result.add(map.getKey());
				}
			}
		}

		return result;

	}

	@Deprecated
	public List<Country> getCountryList(Long id, String language) {
		List<Country> result = new ArrayList<>();

		if (language.equals("search_all")) {
			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				if (map.getKey().getId().equals(id)) {
					result.add(map.getKey());
				}
			}
		} else {
			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				if (map.getKey().getId().equals(id)
						&& map.getKey().getLocaleId().equals(language)) {

					result.add(map.getKey());
				}
			}
		}

		return result;

	}

	@Deprecated
	public List<Country> getCountryList(Long id) {
		List<Country> result = new ArrayList<>();

		if (id == -1) {

			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {
			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				if (map.getValue().equals(id)) {
					result.add(map.getKey());
				}
			}
		}

		return result;

	}

	public List<Country> getCountryList(String language) {

		List<Country> result = new ArrayList<>();

		if (language == null || language.equals("search_all")) {

			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				result.add(map.getKey());
			}
		} else {
			for (Map.Entry<Country, Long> map : Location.countryMap.entrySet()) {
				if (map.getKey().getLocaleId().equals(language)) {
					result.add(map.getKey());
				}
			}
		}

		return result;

	}

	public List<Service> getServicesList(String key, String language) {
		List<Service> result = new ArrayList<>();
		System.out.println(key + " : " + language);
		if (language.equals("search_all")) {
			for (Map.Entry<Service, String> map : Location.serviceMap
					.entrySet()) {
				if (map.getKey().getName().toLowerCase().contains(key)) {
					result.add(map.getKey());
				}
			}
		} else {
			for (Map.Entry<Service, String> map : Location.serviceMap
					.entrySet()) {
				if (map.getValue().equals(language)
						&& map.getKey().getName().toLowerCase().contains(key)) {
					result.add(map.getKey());
				}
			}
		}
		return result;
	}

	public List<Service> getServicesList(String language, boolean selectbox) {
		List<Service> result = new ArrayList<>();
		if (language.equals("search_all")) {
			if (!selectbox) {
				for (Map.Entry<Service, String> map : Location.serviceMap
						.entrySet()) {
					result.add(map.getKey());
				}
			}
		} else {
			for (Map.Entry<Service, String> map : Location.serviceMap
					.entrySet()) {
				if (map.getValue().equals(language)) {
					result.add(map.getKey());
				}
			}
		}
		return result;

	}

	public List<Service> getService(Long id) {
		if (id == -1) {
			return null;
		}
		List<Service> result = new ArrayList<>();

		for (Map.Entry<Service, String> map : Location.serviceMap.entrySet()) {
			if (map.getKey().getId().equals(id)) {
				result.add(map.getKey());
			}
		}
		return result;

	}

	@Deprecated
	public void removeAll() {

		removeCountry();
		removeRegion();
		removedCity();
		removeStreet();

	}

	public void removeCountry() {
		countryMap = null;

	}

	public void removeRegion() {
		regionMap = null;

	}

	public void removedCity() {
		cityMap = null;

	}

	public void removeStreet() {
		streetMap = null;
	}

	@Deprecated
	public void removeService() {
		serviceMap = null;
	}

	@Deprecated
	public void removeLocale() {
		languages = null;
	}

	public void loadAll() {
		loadCountry();
		loadRegion();
		loadCity();
		loadStreet();
		loadLanguages();
		loadServices();
	}

	public void loadCountry() {
		if (countryMap == null) {
			countryMap = new CountryService().loadForLocation();
		} else {
			countryMap.clear();
			countryMap = new CountryService().loadForLocation();
		}

	}

	public void loadRegion() {
		if (regionMap == null) {
			regionMap = new RegionService().loadForLocation();
		} else {
			regionMap.clear();
			regionMap = new RegionService().loadForLocation();
		}

	}

	public void loadCity() {
		if (cityMap == null) {
			cityMap = new CityService().loadForLocation();
		} else {
			cityMap.clear();
			cityMap = new CityService().loadForLocation();
		}

	}

	public void loadStreet() {
		if (streetMap == null) {
			streetMap = new StreetService().loadForLocation();
		} else {
			streetMap.clear();
			streetMap = new StreetService().loadForLocation();
		}

	}

	public void loadLanguages() {
		if (languages == null) {
			languages = new LocaleService().read();
		} else {
			languages.clear();
			languages = new LocaleService().read();
		}
	}

	public void loadServices() {
		if (serviceMap == null) {
			serviceMap = new ServiceService().loadForLocation();
		} else {
			serviceMap.clear();
			serviceMap = new ServiceService().loadForLocation();
		}
	}

	public List<Locale> getLanguagesList() {
		return languages;
	}

	@Deprecated
	public HashMap<Country, Long> getCountryMap() {
		return countryMap;
	}

	@Deprecated
	public HashMap<Region, Long> getRegionMap() {
		return regionMap;
	}

	@Deprecated
	public HashMap<City, Long> getCityMap() {
		return cityMap;
	}

	@Deprecated
	public HashMap<Street, Long> getStreetMap() {
		return streetMap;
	}

	@Deprecated
	public HashMap<Service, String> getServiceMap() {
		return serviceMap;
	}

	public static Location getInstance() {

		if (instance == null) {
			return new Location();
		} else {
			return instance;
		}
	}
}
