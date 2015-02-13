package com.epam.lab.service;

import java.util.List;

import com.epam.lab.dao.impl.HotelServiceDao;
import com.epam.lab.model.helper.HotelesServices;

public class HotelServiceService {
	private HotelServiceDao hotelServiceDao = new HotelServiceDao();

	public void create(HotelesServices hotelesServices) {
		hotelServiceDao.create(hotelesServices);
	}

	public void delete(Long id) {
		HotelesServices hotel = new HotelesServices();
		hotel.setId(id);
		hotelServiceDao.delete(hotel);
	}

	public List<HotelesServices> getListByHotelId(Long id) {
		return hotelServiceDao.readServicesListByHotelId(id);
	}

}
