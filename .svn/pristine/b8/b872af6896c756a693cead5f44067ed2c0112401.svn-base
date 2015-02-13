package com.epam.lab.controller.impl.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.service.HotelService;

public class AdminHotelsController extends DispatcherController {

	private final String URL = "/pages/extranet/admin_cabinet/actions/all_hotels.jsp";

	private HotelService hotelService = new HotelService();
	private boolean blocked = false;

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		String language = ((ResourceBundle) session
				.getAttribute("ResourceBundle")).getLocale().getLanguage();
		if (session.getAttribute("AdminHotels_hotel_list") == null) {
			session.setAttribute("AdminHotels_hotel_list", "white");
		}

		if (request.getParameter("search_block") != null) {
			Long id = toLong(request.getParameter("search_block"));
			hotelService.addToBlackList(id);
		}
		if (request.getParameter("search_unblock") != null) {
			Long id = toLong(request.getParameter("search_unblock"));
			hotelService.addToWhiteList(id);
		}

		if (session.getAttribute("AdminHotels_hotel_list").toString()
				.equals("black")) {
			session.setAttribute("AdminHotels_hotel_list", "black");
			blocked = true;
			request.setAttribute("hotels",
					hotelService.readAllByblocked(true, language));
		}
		if (session.getAttribute("AdminHotels_hotel_list").toString()
				.equals("white")) {
			session.setAttribute("AdminHotels_hotel_list", "white");
			blocked = false;
			request.setAttribute("hotels",
					hotelService.readAllByblocked(false, language));
		}
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		System.out.println("conf");
		HttpSession session = request.getSession();
		String language = ((ResourceBundle) session
				.getAttribute("ResourceBundle")).getLocale().getLanguage();

		if (request.getParameter("add_to_blacklist") != null) {
			String[] checkbox = request.getParameterValues("search_blocked");
			if (checkbox != null) {
				for (String str : checkbox) {
					hotelService.addToBlackList(toLong(str));
				}
			}
		}
		if (request.getParameter("add_to_whitelist") != null) {
			String[] checkbox = request.getParameterValues("search_blocked");
			for (String str : checkbox) {
				hotelService.addToWhiteList(toLong(str));
			}
		}
		if (request.getParameter("black_list") != null
				|| session.getAttribute("AdminHotels_hotel_list").toString()
						.equals("black")) {
			session.setAttribute("AdminHotels_hotel_list", "black");
			blocked = true;
			request.setAttribute("hotels",
					hotelService.readAllByblocked(true, language));
		}
		if (request.getParameter("white_list") != null
				|| session.getAttribute("AdminHotels_hotel_list").toString()
						.equals("white")) {
			session.setAttribute("AdminHotels_hotel_list", "white");
			blocked = false;
			request.setAttribute("hotels",
					hotelService.readAllByblocked(false, language));
		}

		if (request.getParameter("search") != null) {
			request.setAttribute(
					"hotels",
					hotelService.searchByName(
							request.getParameter("search_name"), blocked));
			request.setAttribute("search_result",
					request.getParameter("search_name"));
			forward(URL, request, response);
			return;
		}
		forward(URL, request, response);

	}

}
