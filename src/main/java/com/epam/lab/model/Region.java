package com.epam.lab.model;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "region")
public class Region {

	@Id
	@Column(name = "region.id")
	private Long id;

	@Column(name = "region.name")
	private String name;

	@Column(name = "region.country_id")
	private Long countryId;

	@Id
	@Column(name = "region.locale_id")
	private String localeId;

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

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCountryName() {
		if (country != null) {
			return country.getName();
		}
		return null;
	}

	public void setCountryName(String name) {
		if (country != null) {
			country.setName(name);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 2;
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

		Region region = (Region) obj;
		if (id != region.id) {
			return false;
		}
		if (!localeId.equals(region.localeId)) {
			return false;
		}
		if (!name.equals(region.name)) {
			return false;
		}
		if (!countryId.equals(region.countryId)) {
			return false;
		}
		if (!country.equals(region.getCountry())) {
			return false;
		}
		return true;
	}
}
