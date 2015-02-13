package com.epam.lab.model;

import java.sql.Timestamp;
import java.util.List;

import com.epam.lab.dao.annotations.Column;
import com.epam.lab.dao.annotations.Id;
import com.epam.lab.dao.annotations.Table;
import com.epam.lab.model.helper.HotelInfo;

@Table(name = "hotel")
public class Hotel {

	@Id
	@Column(name = "hotel.id")
	private Long id;

	@Column(name = "hotel.address")
	private String address;

	@Column(name = "hotel.contact_information")
	private String contactInfo;

	@Column(name = "hotel.avg_rate")
	private Integer avgRate;

	@Column(name = "hotel.country_id")
	private Long countryId;

	@Column(name = "hotel.region_id")
	private Long regionId;

	@Column(name = "hotel.city_id")
	private Long cityId;

	@Column(name = "hotel.street_id")
	private Long streetId;

	@Column(name = "hotel.blocked")
	private Boolean blocked;

	@Column(name = "hotel.logo")
	private String logo;

	@Column(name = "hotel.last_update")
	private Timestamp lastUpdate;

	@Column(name = "hotel.longitude")
	private String longitude;

	@Column(name = "hotel.latitude")
	private String latitude;

	@Column(name = "hotel.stars")
	private int stars;

	private Country country;

	private Region region;

	private City city;

	private Street street;

	private List<Room> rooms;

	private List<Service> service;

	private HotelInfo hotelInfo;

	public String getHotelName() {
		if (hotelInfo != null) {
			return hotelInfo.getName();
		}
		return null;
	}

	public void setHotelName(String name) {
		if (hotelInfo != null) {
			hotelInfo.setName(name);
		}
	}

	public String getHotelLocaleId() {
		if (hotelInfo != null) {
			return hotelInfo.getLocaleId();
		}
		return null;
	}

	public void setHotelLocaleId(String localeId) {
		if (hotelInfo != null) {
			hotelInfo.setLocaleId(localeId);
		}
	}

	public String getHotelShortInfo() {
		if (hotelInfo != null) {
			return hotelInfo.getShortInfo();
		}
		return null;
	}

	public void setHotelShortInfo(String shortInfo) {
		if (hotelInfo != null) {
			hotelInfo.setShortInfo(shortInfo);
		}
	}

	public String getHotelExtendedInfo() {
		if (hotelInfo != null) {
			return hotelInfo.getExtendedInfo();
		}
		return null;
	}

	public void setHotelExtendedInfo(String extendedInfo) {
		if (hotelInfo != null) {
			hotelInfo.setExtendedInfo(extendedInfo);
		}
	}

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> room) {
		this.rooms = room;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Integer getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(Integer avgRate) {
		this.avgRate = avgRate;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getStreetId() {
		return streetId;
	}

	public void setStreetId(Long streetId) {
		this.streetId = streetId;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	/**
	 * Hotel Info
	 * 
	 * @return
	 */
	public String getShortInfo() {

		return hotelInfo.getShortInfo();
	}

	public void setShortInfo(String shortInfo) {

		hotelInfo.setShortInfo(shortInfo);
	}

	public String getExtendedInfo() {

		return hotelInfo.getExtendedInfo();
	}

	public void setExtendedInfo(String extendedInfo) {

		hotelInfo.setExtendedInfo(extendedInfo);
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Long getMinimumRoomPrice() {
		Long result = (long) 0;
		for (Room room : rooms) {
			if (room.getCost() < result) {
				result = room.getCost();
			}
		}
		return result;
	}
}
