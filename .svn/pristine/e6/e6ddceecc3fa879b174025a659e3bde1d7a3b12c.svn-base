package com.epam.lab.model;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "street")
public class Street {

	@Id
	@Column(name = "street.id")
	private Long id;

	@Id
	@Column(name = "street.locale_id")
	private String localeId;

	@Column(name = "street.name")
	private String name;

	@Column(name = "street.city_id")
	private Long cityId;

	@Column(name = "street.region_id")
	private Long regionId;

	@Column(name = "street.country_id")
	private Long countryId;

	private City city;

	public Long getRegionId() {
		return regionId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

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

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 4;
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

		Street street = (Street) obj;
		if (id != street.id) {
			return false;
		}
		if (!localeId.equals(street.localeId)) {
			return false;
		}
		if (!name.equals(street.name)) {
			return false;
		}
		if (!cityId.equals(street.cityId)) {
			return false;
		}
		if (!city.equals(street.city)) {
			return false;
		}
		return true;
	}
}
