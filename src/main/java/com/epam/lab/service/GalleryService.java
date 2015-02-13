package com.epam.lab.service;

import java.util.List;

import com.epam.lab.dao.impl.GalleryDao;
import com.epam.lab.model.Gallery;

public class GalleryService {

	private GalleryDao daoGallery = new GalleryDao();

	public List<Gallery> getHotelGallery(long hotelId) {
		List<Gallery> result = null;
		if (hotelId != -1) {
			result = daoGallery.readHotelGallery(hotelId);
		}
		return result;
	}

	public void createHotelGallery(Gallery gallery) {
		daoGallery.create(gallery);
	}

	public void deleteHotelGalleryPhoto(Gallery gallery) {

		daoGallery.delete(gallery);
	}

}
