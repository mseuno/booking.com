package com.epam.lab.service;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.dao.impl.HotelDao;
import com.epam.lab.dao.impl.UserDao;
import com.epam.lab.dao.mapping.Mapping;
import com.epam.lab.exceptions.DuplicateUniqueKeyException;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.User;

public class UserService {

	private static final Logger LOG = Logger.getLogger(Mapping.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	private UserDao daoUser = new UserDao();

	public User selectUserByEmailAndPassword(String email, String password) {
		return daoUser.readByEmailAndPassword(email, password);
	}

	public String registerNewUser(User user) {
		String result = null;
		try {
			daoUser.registerNewUser(user);
		} catch (DuplicateUniqueKeyException e) {
			result = "User with such email exist!";
			LOG.warn(result);
		}
		return result;
	}

	public List<Hotel> selectFavorites(long id, ResourceBundle bundle) {
		List<Hotel> result = null;
		if (id != -1) {
			result = new HotelDao().readUsersFavorites(id, bundle.getLocale()
					.getLanguage());
		}
		return result;

	}

	public Long getUserIdForBooking(User user) {
		Long result = null;
		User selectedUser = daoUser.readByEmail(user.getEmail());
		if (selectedUser != null) {
			result = selectedUser.getId();
		} else {
			result = daoUser.create(user);
		}
		return result;
	}

	public void updateUser(User user) {
		daoUser.updateUser(user);
	}

	public boolean setFavoriteHotel(Long userId, Long hotelId) {
		return daoUser.setFavoriteHotel(userId, hotelId);
	}

	public boolean checkIfHotelIsFavorite(Long userId, Long hotelId) {
		return daoUser.checkIfHotelIsFavorite(userId, hotelId);
	}

	public boolean deleteHotelFromFavorite(Long userId, Long hotelId) {
		return daoUser.deleteHotelFromFavorite(userId, hotelId);
	}
}
