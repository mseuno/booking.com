package com.epam.lab.model.helper;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;

@Table(name = "hotel_info")
public class HotelInfo {

	@Id
	@Column(name = "hotel_info.hotel_id")
	private Long hotelId;

	@Column(name = "hotel_info.short_info")
	private String shortInfo;

	@Column(name = "hotel_info.extended_info")
	private String extendedInfo;

	@Column(name = "hotel_info.name")
	private String name;

	@Id
	@Column(name = "hotel_info.locale_id")
	private String localeId;

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getShortInfo() {
		return shortInfo;
	}

	public void setShortInfo(String shortInfo) {
		this.shortInfo = shortInfo;
	}

	public String getExtendedInfo() {
		return extendedInfo;
	}

	public void setExtendedInfo(String extendedInfo) {
		this.extendedInfo = extendedInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

}
