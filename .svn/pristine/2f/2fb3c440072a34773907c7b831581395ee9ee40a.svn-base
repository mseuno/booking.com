package com.epam.lab.model;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "city")
public class City {

	@Id
	@Column(name = "city.id")
	private Long id;

	@Id
	@Column(name = "city.locale_id")
	private String localeId;

	@Column(name = "city.name")
	private String name;

	@Column(name = "city.country_id")
	private Long countryId;

	@Column(name = "city.region_id")
	private Long regionId;

	private Region region;

	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 3;
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + localeId.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		City city = (City) obj;
		if (id != city.id) {
			return false;
		}
		if (!localeId.equals(city.localeId)) {
			return false;
		}
		if (!name.equals(city.name)) {
			return false;
		}
		if (!countryId.equals(city.countryId)) {
			return false;
		}
		if (!regionId.equals(city.regionId)) {
			return false;
		}
		if (!country.equals(city.getCountry())) {
			return false;
		}
		if (!region.equals(city.getRegion())) {
			return false;
		}
		return true;
	}
}
