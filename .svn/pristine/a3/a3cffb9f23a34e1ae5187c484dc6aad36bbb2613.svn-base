package com.epam.lab.model;

import java.sql.Date;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "admin")
public class Admin {

	@Id
	@Column(name = "admin.id")
	private Long id;

	@Column(name = "admin.first_name")
	private String firstName;

	@Column(name = "admin.last_name")
	private String lastName;

	@Column(name = "admin.email")
	private String email;

	@Column(name = "admin.password")
	private transient String password;

	@Column(name = "admin.registration_date")
	private Date registrationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

}
