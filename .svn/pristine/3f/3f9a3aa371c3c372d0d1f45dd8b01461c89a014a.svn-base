package com.epam.lab.model;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "hotel_gallery")
public class Gallery {

	@Id
	@Column(name = "hotel_gallery.id")
	private Long id;

	@Column(name = "hotel_gallery.hotel_id")
	private Long hotelId;

	@Column(name = "hotel_gallery.thumb")
	private String thumb;

	@Column(name = "hotel_gallery.photo")
	private String photo;

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

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
