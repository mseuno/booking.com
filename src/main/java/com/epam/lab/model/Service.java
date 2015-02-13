package com.epam.lab.model;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "service")
public class Service {

	@Id
	@Column(name = "service.id")
	private Long id;

	@Column(name = "service.name")
	private String name;

	@Id
	@Column(name = "service.locale_id")
	private String localeId;

	private Boolean isCheck;

	public Boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
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

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 5;
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

		Service service = (Service) obj;
		if (id != service.id) {
			return false;
		}
		if (!localeId.equals(service.localeId)) {
			return false;
		}
		if (!name.equals(service.name)) {
			return false;
		}
		return true;
	}
}
