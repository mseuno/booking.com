package com.epam.lab.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;
import com.epam.lab.model.helper.HotelInfo;

@Table(name = "manager")
public class Manager {

	@Id
	@Column(name = "manager.id")
	private Long id;

	@Column(name = "manager.first_name")
	private String firstName;

	@Column(name = "manager.last_name")
	private String lastName;

	@Column(name = "manager.email")
	private String email;

	@Column(name = "manager.admin_id")
	private Long adminId;

	@Column(name = "manager.last_update")
	private Timestamp lastUpdate;

	@Column(name = "manager.password")
	private transient String password;

	@Column(name = "manager.phone")
	private String phone;

	@Column(name = "manager.registration_date")
	private Date registrationDate;

	@Column(name = "manager.hotel_id")
	private Long hotelId;

	private HotelInfo hotelInfo;

	public void setHotelInfoName(String name) {
		if (hotelInfo != null) {
			hotelInfo.setName(name);
		}
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	private List<Hotel> hotels;

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

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

}
