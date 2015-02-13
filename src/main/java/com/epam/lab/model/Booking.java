package com.epam.lab.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;
import com.epam.lab.model.helper.BookingRoom;
import com.epam.lab.model.helper.HotelInfo;

@Table(name = "booking")
public class Booking {

	@Id
	@Column(name = "booking.id")
	private Long id;

	@Column(name = "booking.user_id")
	private Long userId;

	@Column(name = "booking.hotel_id")
	private Long hotelId;

	@Column(name = "booking.begin_date")
	private Date beginDate;

	@Column(name = "booking.end_date")
	private Date endDate;

	@Column(name = "booking.total_cost")
	private Long totalCost;

	@Column(name = "booking.status")
	private Integer status;

	@Column(name = "booking.last_update")
	private Timestamp lastUpdate;

	private List<BookingRoom> bookingRoom;

	private User user;

	private HotelInfo hotelInfo;

	private Hotel hotel;

	public String getUserFirstName() {
		if (user != null) {
			return user.getFirstName();
		}
		return null;
	}

	public void setUserFirstName(String firstName) {
		if (user != null) {
			user.setFirstName(firstName);
		}
	}

	public String getUserLastName() {
		if (user != null) {
			return user.getLastName();
		}
		return null;
	}

	public void setUserLastName(String lastName) {
		if (user != null) {
			user.setLastName(lastName);
		}
	}

	public Boolean getUserBlocked() {
		if (user != null) {
			return user.getBlocked();
		}
		return null;
	}

	public void setUserBlocked(Boolean blocked) {
		if (user != null) {
			user.setBlocked(blocked);
		}
	}

	public String getUserEmail() {
		if (user != null) {
			return user.getEmail();
		}
		return null;
	}

	public void setUserEmail(String email) {
		if (user != null) {
			user.setEmail(email);
		}
	}

	public Timestamp getUserLastUpdate() {
		if (user != null) {
			return user.getLastUpdate();
		}
		return null;
	}

	public void setUserLastUpdate(Timestamp lastUpdate) {
		if (user != null) {
			user.setLastUpdate(lastUpdate);
			;
		}
	}

	public String getUserPhone() {
		if (user != null) {
			return user.getPhone();
		}
		return null;
	}

	public void setUserPhone(String phone) {
		if (user != null) {
			user.setPhone(phone);
		}
	}

	public Boolean getUserRegistered() {
		if (user != null) {
			return user.getRegistered();
		}
		return null;
	}

	public void setUserRegistered(Boolean registered) {
		if (user != null) {
			user.setRegistered(registered);
		}
	}

	public Date getUserRegistrationDate() {
		if (user != null) {
			return user.getRegistrationDate();
		}
		return null;
	}

	public void setUserRegistrationDate(Date registrationDate) {
		if (user != null) {
			user.setRegistrationDate(registrationDate);
		}
	}

	public String getUserPassword() {
		if (user != null) {
			return user.getPassword();
		}
		return null;
	}

	public void setUserPassword(String password) {
		if (user != null) {
			user.setPassword(password);
		}
	}

	public List<BookingRoom> getBookingRoom() {
		return bookingRoom;
	}

	public void setBookingRoom(List<BookingRoom> bookingRoom) {
		this.bookingRoom = bookingRoom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
