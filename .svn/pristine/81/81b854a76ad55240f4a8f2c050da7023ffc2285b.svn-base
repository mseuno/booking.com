package com.epam.lab.model;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "country")
public class Country {

	@Id
	@Column(name = "country.id")
	private Long id;

	@Id
	@Column(name = "country.locale_id")
	private String localeId;

	@Column(name = "country.name")
	private String name;

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

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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

		Country country = (Country) obj;
		if (id != country.id) {
			return false;
		}
		if (!localeId.equals(country.localeId)) {
			return false;
		}
		if (!name.equals(country.name)) {
			return false;
		}
		return true;
	}
}
