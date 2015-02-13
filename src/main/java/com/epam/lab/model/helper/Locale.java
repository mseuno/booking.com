package com.epam.lab.model.helper;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Table;

@Table(name = "locale")
public class Locale {

	@Column(name = "locale.id")
	private String id;

	@Column(name = "locale.locale")
	private String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
