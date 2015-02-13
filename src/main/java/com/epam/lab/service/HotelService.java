package com.epam.lab.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.lab.dao.impl.HotelDao;
import com.epam.lab.dao.impl.HotelInfoDao;
import com.epam.lab.dao.impl.ServiceDao;
import com.epam.lab.model.Admin;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Manager;
import com.epam.lab.model.Room;
import com.epam.lab.model.Service;
import com.epam.lab.model.User;
import com.epam.lab.model.helper.HotelInfo;
import com.epam.lab.model.helper.HotelReview;
import com.epam.lab.utils.RoomAccessibility;
import com.epam.lab.utils.SearchEngine;
import com.epam.lab.utils.SearchParameters;
import com.epam.lab.utils.Validator;

public class HotelService {

	private ServiceDao serviceDao = new ServiceDao();
	private HotelInfoDao hotelInfoDao = new HotelInfoDao();

	private HotelDao hotelDao = new HotelDao();

	public List<Hotel> randomHotelList(int quantity, String locale) {
		return hotelDao.readRandom(quantity, locale);

	}

	public void getAvailableRoomsForBooking(Hotel hotel,
			SearchParameters searchParameters) {
		if (hotel == null) {
			return;
		}
		List<Room> rooms = new ArrayList<Room>();
		Map<Long, RoomAccessibility> availableRoomsMap = new SearchEngine()
				.getRoomsAccessibilities(hotel, searchParameters);
		for (Room room : hotel.getRooms()) {
			RoomAccessibility availableRoom = availableRoomsMap.get(room
					.getId());
			if (availableRoom == null) {
				continue;
			}

			if (availableRoom.getRoomAccessebility().getNumberOfRooms() > 0) {
				room.setNumberOfRooms(availableRoom.getRoomAccessebility()
						.getNumberOfRooms());
				rooms.add(room);
			}
		}
		hotel.setRooms(rooms);
	}

	public void updateHotel(Hotel hotel) {
		hotelDao.update(hotel);
	}

	public Hotel selectHotelByHotelId(long id, String locale, Object user) {

		Hotel result = null;
		if (id != -1) {
			if (user != null) {
				if (user instanceof Admin) {
					result = hotelDao.readByHotelIdAdmin(id, locale);
				} else if (user instanceof Manager) {
					result = hotelDao.readByHotelIdAdmin(id, locale);
					if (result != null) {
						if (result.getBlocked()
								&& !(((Manager) user).getHotelId()
										.equals(result.getId()))
								|| ((Manager) user).getAdminId() == null
								&& !(((Manager) user).getHotelId()
										.equals(result.getId()))) {
							return null;
						}
					}
				} else if (user instanceof User) {
					result = hotelDao.readByHotelId(id, locale);
				}
			} else {
				result = hotelDao.readByHotelId(id, locale);
			}
			if (result != null) {
				List<Service> listService = serviceDao
						.readHotelServiceByIdByLocale(result.getId(), locale);
				result.setService(listService);
			}
		}
		return result;
	}

	public Hotel selectHotelByHotelId(long id, String locale) {
		Hotel result = null;
		if (id != -1) {
			result = hotelDao.readByHotelId(id, locale);
			if (result != null) {
				List<Service> listService = serviceDao
						.readHotelServiceByIdByLocale(result.getId(), locale);
				result.setService(listService);
			}
		}
		return result;
	}

	public List<Hotel> selectHotelByCityId(long id, String locale) {
		List<Hotel> result = null;
		if (id != -1) {
			result = hotelDao.readByCityId(id, locale);
		}
		return result;
	}

	public List<Hotel> selectHotelByRegionId(long id, String locale) {
		List<Hotel> result = null;
		if (id != -1) {
			result = hotelDao.readByRegionId(id, locale);
		}
		return result;
	}

	public Hotel selectHotelByManagerId(Manager manager) {
		Hotel hotel = hotelDao.readByManagerId(manager.getHotelId());
		return hotel;
	}

	public void updateFullHotel(Hotel hotel) {

		if (hotel.getHotelName() != null) {
			hotel.setHotelName(Validator.DELETE_FORBIDDEN_CHARACTERS
					.deleteForbiddenCharacter(hotel.getHotelName()));
		}
		if (hotel.getShortInfo() != null) {
			hotel.setHotelShortInfo(Validator.DELETE_FORBIDDEN_CHARACTERS
					.deleteForbiddenCharacter(hotel.getShortInfo()));
		}
		if (hotel.getContactInfo() != null) {
			hotel.setContactInfo(Validator.DELETE_FORBIDDEN_CHARACTERS
					.deleteForbiddenCharacter(hotel.getContactInfo()));
		}
		if (hotel.getExtendedInfo() != null) {
			hotel.setHotelExtendedInfo(Validator.DELETE_FORBIDDEN_CHARACTERS
					.deleteForbiddenCharacter(hotel.getExtendedInfo()));
		}
		hotel.getHotelInfo().setHotelId(hotel.getId());
		hotelInfoDao.update(hotel.getHotelInfo());
		hotelDao.update(hotel);
	}

	public HotelInfo readHotelInfoByLocale(final long id, String language) {

		HotelInfo result = new HotelInfo();
		result.setHotelId(id);
		result.setLocaleId(language);
		result = hotelInfoDao.read(result);
		if (result == null) {
			HotelInfo ne = new HotelInfo();
			ne.setHotelId(id);
			ne.setLocaleId(language);
			hotelInfoDao.create(ne);
		}
		return result;
		// return hotelInfoDao.readByLocale(id,language);
	}

	public List<Hotel> selectFullInfoByName(String name) {
		return hotelDao.readFullInfoByName(name);
	}

	public void addToBlackList(long id) {
		hotelDao.addToBlackList(id, true);
	}

	public void addToWhiteList(long id) {
		hotelDao.addToBlackList(id, false);
	}

	public List<HotelInfo> readAllByblocked(boolean blocked, String language) {
		return new HotelInfoDao().readByBlocked(blocked, language);
	}

	public HotelReview getHotelReview(Long userId, Long hotelId) {
		return hotelDao.getHotelReview(userId, hotelId);
	}

	public void addHotelReview(Long userId, Long hotelId,
			HotelReview hotelReview) {
		hotelDao.addHotelReview(userId, hotelId, hotelReview);
	}

	public boolean checkIfUserCanAddReview(Long userId, Long hotelId) {
		return hotelDao.checkIfUserCanAddReview(userId, hotelId);
	}

	public List<HotelReview> getAllHotelReview(Long hotelId) {
		return hotelDao.getAllHotelReview(hotelId);
	}

	public List<HotelInfo> searchByName(String key, boolean blocked) {
		return new HotelInfoDao().search(key, blocked);
	}

	public Long requiredHotel(Hotel hotel) {

		hotel.setHotelName(Validator.DELETE_FORBIDDEN_CHARACTERS
				.deleteForbiddenCharacter(hotel.getHotelName()));
		hotel.setHotelShortInfo(Validator.DELETE_FORBIDDEN_CHARACTERS
				.deleteForbiddenCharacter(hotel.getShortInfo()));
		hotel.setContactInfo(Validator.DELETE_FORBIDDEN_CHARACTERS
				.deleteForbiddenCharacter(hotel.getContactInfo()));
		if (hotel.getExtendedInfo() != null) {
			hotel.setHotelExtendedInfo(Validator.DELETE_FORBIDDEN_CHARACTERS
					.deleteForbiddenCharacter(hotel.getExtendedInfo()));
		}

		Long hotelId = new HotelDao().create(hotel);
		hotel.getHotelInfo().setHotelId(hotelId);
		hotel.getHotelInfo().setLocaleId("en");
		new HotelInfoDao().create(hotel.getHotelInfo());

		return hotelId;
	}
}
