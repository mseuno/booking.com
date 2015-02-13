package com.epam.lab.model;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;
import com.epam.lab.model.helper.RoomInfo;

@Table(name = "room")
public class Room {

	@Id
	@Column(name = "room.id")
	private Long id;

	@Column(name = "room.hotel_id")
	private Long hotelId;

	@Column(name = "room.cost")
	private Long cost;

	@Column(name = "room.number_of_rooms")
	private int numberOfRooms;

	@Column(name = "room.number_of_people")
	private int numberOfPeople;

	private RoomInfo roomInfo = null;

	public String getRoomName() {
		if (roomInfo != null) {
			return roomInfo.getName();
		}
		return null;
	}

	public void setRoomName(String name) {
		if (roomInfo != null) {
			roomInfo.setName(name);
		}
	}

	public String getRoomLocaleId() {
		if (roomInfo != null) {
			return roomInfo.getLocaleId();
		}
		return null;
	}

	public void setRoomLocaleId(String localeId) {
		if (roomInfo != null) {
			roomInfo.setLocaleId(localeId);
		}
	}

	public Long getRoomId() {
		if (roomInfo != null) {
			return roomInfo.getRoomId();
		}
		return null;
	}

	public void setRoomId(Long roomId) {
		if (roomInfo != null) {
			roomInfo.setRoomId(roomId);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public RoomInfo getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(RoomInfo roomInfo) {
		this.roomInfo = roomInfo;
	}

}
