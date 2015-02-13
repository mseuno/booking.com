package com.epam.lab.model.helper;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "room_info")
public class RoomInfo {

	@Id
	@Column(name = "room_info.room_id")
	private Long roomId;

	@Id
	@Column(name = "room_info.locale_id")
	private String localeId;

	@Column(name = "room_info.name")
	private String name;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
