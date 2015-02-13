package com.epam.lab.service;

import java.util.List;

import com.epam.lab.dao.impl.RoomDao;
import com.epam.lab.dao.impl.RoomInfoDao;
import com.epam.lab.model.Room;
import com.epam.lab.model.helper.Locale;
import com.epam.lab.model.helper.RoomInfo;
import com.epam.lab.utils.Location;

public class RoomService {
	private RoomInfoDao roomInfoDao = new RoomInfoDao();
	private RoomDao roomDao = new RoomDao();

	public void updateRoomsNumber(Long id, Long quantity) {
		if (id != -1) {
			roomDao.setRoomQuantity(quantity, id);
		}
	}

	public void delete(Long id) {
		Room room = new Room();
		room.setId(id);
		for (Locale language : Location.getInstance().getLanguagesList()) {
			RoomInfo roomInfo = new RoomInfo();
			roomInfo.setLocaleId(language.getId());
			roomInfo.setRoomId(id);
			roomInfoDao.delete(roomInfo);
		}
		roomDao.delete(room);
	}

	public String createFullRoom(Room room) {
		String result = null;
		if (room.getNumberOfPeople() < 128 && room.getNumberOfPeople() > 0
				&& room.getNumberOfRooms() < 128 && room.getNumberOfRooms() > 0
				&& room.getCost() > 0) {
			Long roomId = roomDao.create(room);
			// Out of rage column
			if (roomId == -22001) {
				result = "out of range - max value 127";
			} else {
				room.getRoomInfo().setRoomId(roomId);
				roomInfoDao.create(room.getRoomInfo());
			}
		} else {
			System.out.println("ELSE" + result);
		}

		return result;
	}

	public Room getFullRoom(Long id, String locale) {
		Room result = null;
		if (id != -1) {
			result = roomDao.getRoomById(id, locale);
		}
		return result;
	}

	public void updateRoom(Room room) {
		roomDao.update(room);
		roomInfoDao.update(room.getRoomInfo());
	}

	public void deleteAppartment(long id) {
		Room room = new Room();
		room.setId(id);
		roomDao.delete(room);

	}

	public List<Room> readByHotelId(long id, String locale) {
		List<Room> result = null;
		if (id != -1) {
			result = roomDao.readByHotelId(id, locale);
		}
		return result;
	}

	public RoomInfo selectRoomInfo(long id, String locale) {
		RoomInfo result = null;
		if (id != -1) {
			result = new RoomInfo();
			result.setRoomId(id);
			result.setLocaleId(locale);
			result = roomInfoDao.read(result);
			if (result == null) {
				result = new RoomInfo();
			}
		}
		return result;
	}
}
