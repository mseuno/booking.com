package com.epam.lab.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "user")
public class User {

	@Id
	@Column(name = "user.id")
	private Long id;

	@Column(name = "user.first_name")
	private String firstName;

	@Column(name = "user.last_name")
	private String lastName;

	@Column(name = "user.email")
	private String email;

	@Column(name = "user.password")
	private transient String password;

	@Column(name = "user.registration_date")
	private Date registrationDate;

	@Column(name = "user.registered")
	private Boolean registered;

	@Column(name = "user.blocked")
	private Boolean blocked;

	@Column(name = "user.last_update")
	private Timestamp lastUpdate;

	@Column(name = "user.phone")
	private String phone;

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

	public Boolean getRegistered() {
		return registered;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
