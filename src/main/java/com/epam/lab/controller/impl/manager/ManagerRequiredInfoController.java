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
import com.epam.lab.service.ManagerService;
import com.epam.lab.utils.Location;

public class ManagerRequiredInfoController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/manager_required_info.jsp";
	private Location location = Location.getInstance();
	private String language = "en";
	private HotelService hotelService = new HotelService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		language = ((ResourceBundle) request.getSession().getAttribute(
				"ResourceBundle")).getLocale().getLanguage();
		request.setAttribute("countries", location.getCountryList(language));
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		language = ((ResourceBundle) request.getSession().getAttribute(
				"ResourceBundle")).getLocale().getLanguage();
		boolean create = true;

		if (request.getParameter("hotel_name").isEmpty()) {
			create = false;
		}
		if (request.getParameter("hotel_contact_info").isEmpty()) {
			create = false;
		}
		if (request.getParameter("hotel_short_info").isEmpty()) {
			create = false;
		}

		if (create) {
			Hotel hotel = new Hotel();

			hotel.setCountryId(toLong(request.getParameter("search_country_id")));
			hotel.setRegionId(toLong(request.getParameter("search_region_id")));
			hotel.setCityId(toLong(request.getParameter("search_city_id")));
			hotel.setStreetId(toLong(request.getParameter("search_street_id")));
			hotel.setContactInfo(request.getParameter("hotel_contact_info"));
			if (request.getParameter("latitude") != null) {
				hotel.setLatitude(request.getParameter("latitude"));
			}
			if (request.getParameter("latitude") != null) {
				hotel.setLongitude(request.getParameter("longitude"));
			}

			HotelInfo hotelInfo = new HotelInfo();
			hotelInfo.setName(request.getParameter("hotel_name"));
			hotelInfo.setShortInfo(request.getParameter("hotel_short_info"));
			hotelInfo
					.setExtendedInfo(request.getParameter("hotel_extend_info"));
			hotel.setHotelInfo(hotelInfo);

			Long hotelId = hotelService.requiredHotel(hotel);
			if (hotelId != null) {
				Manager manager = (Manager) session.getAttribute("user");
				manager.setHotelId(hotelId);
				session.setAttribute("user", manager);
				new ManagerService().update(manager);
				session.removeAttribute("hotel");
				forward("manager", request, response);
				return;
			}
		}
		request.setAttribute("countries", location.getCountryList(language));
		request.setAttribute("hotel_name", request.getParameter("hotel_name"));
		request.setAttribute("hotel_contact_info",
				request.getParameter("hotel_contact_info"));
		request.setAttribute("hotel_short_info",
				request.getParameter("hotel_short_info"));
		request.setAttribute("hotel_extend_info",
				request.getParameter("hotel_extend_info"));
		request.setAttribute("hotel_latitude", request.getParameter("latitude"));
		request.setAttribute("hotel_longitude",
				request.getParameter("longitude"));
		forward(URL, request, response);
	}
}
