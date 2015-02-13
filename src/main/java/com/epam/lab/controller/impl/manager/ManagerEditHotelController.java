package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Manager;
import com.epam.lab.model.helper.HotelInfo;
import com.epam.lab.service.HotelService;
import com.epam.lab.utils.Location;

public class ManagerEditHotelController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/edit_hotel.jsp";

	private HotelService hotelService = new HotelService();
	private String language = "en";
	private Location location = Location.getInstance();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		if (request.getParameter("language") == null) {
			language = ((ResourceBundle) session.getAttribute("ResourceBundle"))
					.getLocale().getLanguage();
		} else {
			language = request.getParameter("language");
		}

		Hotel hotel = (Hotel) session.getAttribute("hotel");
		HotelInfo hotelInfo = hotelService.readHotelInfoByLocale(hotel.getId(),
				language);

		if (hotel.getCountryId() != null) {
			request.setAttribute("ManagerEditHotel_country_id",
					hotel.getCountryId());
			if (hotel.getRegionId() != null) {
				request.setAttribute("ManagerEditHotel_region_id",
						hotel.getRegionId());
				request.setAttribute("regions",
						location.getRegionList(hotel.getCountryId(), language));
				if (hotel.getCityId() != null) {
					request.setAttribute("ManagerEditHotel_city_id",
							hotel.getCityId());
					request.setAttribute("cities", location.getCitiesList(
							hotel.getRegionId(), language));
					if (hotel.getStreetId() != null) {
						request.setAttribute("ManagerEditHotel_street_id",
								hotel.getStreetId());
						request.setAttribute("streets", location
								.getStreetsList(hotel.getCityId(), language));
					}
				}
			}
		}
		session.setAttribute("ManagerEditHotel_page_language", language);
		request.setAttribute("countries", location.getCountryList(language));
		request.setAttribute("hotel_info", hotelInfo);
		request.setAttribute("name", session.getAttribute("name"));
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HotelService hotelService = new HotelService();
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		if (request.getParameter("search_locale_id") != null) {
			language = ((ResourceBundle) session.getAttribute("ResourceBundle"))
					.getLocale().getLanguage();
		} else {
			language = (String) session
					.getAttribute("ManagerEditHotel_page_language");
		}

		if (hotel.getCountryId() != null) {
			request.setAttribute("ManagerEditHotel_country_id",
					hotel.getCountryId());
			if (hotel.getRegionId() != null) {
				request.setAttribute("ManagerEditHotel_region_id",
						hotel.getRegionId());
				request.setAttribute("regions",
						location.getRegionList(hotel.getCountryId(), language));
				if (hotel.getCityId() != null) {
					request.setAttribute("ManagerEditHotel_city_id",
							hotel.getCityId());
					request.setAttribute("cities", location.getCitiesList(
							hotel.getRegionId(), language));
					if (hotel.getStreetId() != null) {
						request.setAttribute("ManagerEditHotel_street_id",
								hotel.getStreetId());
						request.setAttribute("streets", location
								.getStreetsList(hotel.getCityId(), language));
					}
				}
			}
		}

		Long hotelId = ((Manager) session.getAttribute("user")).getHotelId();
		HotelInfo hotelInfo = hotelService.readHotelInfoByLocale(hotelId,
				language);

		if (request.getParameter("update") != null) {

			hotel.setCountryId(toLong(request.getParameter("search_country_id")));
			hotel.setRegionId(toLong(request.getParameter("search_region_id")));
			hotel.setCityId(toLong(request.getParameter("search_city_id")));
			hotel.setStreetId(toLong(request.getParameter("search_street_id")));
			hotel.setContactInfo(request.getParameter("hotel_contact_info"));
			hotel.setLatitude(request.getParameter("latitude"));
			hotel.setLongitude(request.getParameter("longitude"));
			session.setAttribute("hotel", hotel);
			if (hotelInfo == null) {
				hotelInfo = new HotelInfo();
			}

			hotelInfo.setName(request.getParameter("hotel_name"));
			hotelInfo.setShortInfo(request.getParameter("hotel_short_info"));
			hotelInfo.setExtendedInfo(request
					.getParameter("hotel_extended_info"));
			hotelInfo.setLocaleId(language);
			hotel.setHotelInfo(hotelInfo);
			hotelService.updateFullHotel(hotel);
		}

		request.setAttribute("countries", location.getCountryList(language));
		request.setAttribute("hotel_info", hotelInfo);
		request.setAttribute("countries", location.getCountryList(language));
		request.setAttribute("name", session.getAttribute("name"));
		forward(URL, request, response);

	}

}
