package com.epam.lab.model.helper;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;
import com.epam.lab.model.Room;

@Table(name = "booking_room")
public class BookingRoom {

	@Id
	@Column(name = "booking_room.id")
	private Long id;

	@Column(name = "booking_room.booking_id")
	private Long bookingId;

	@Column(name = "booking_room.room_id")
	private Long roomId;

	@Column(name = "booking_room.hotel_id")
	private Long hotelId;

	@Column(name = "booking_room.number_of_rooms")
	private int numberOfRooms;

	@Column(name = "booking_room.cost")
	private Long cost;

	private Room room;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int number_of_rooms) {
		this.numberOfRooms = number_of_rooms;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
