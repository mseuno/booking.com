package com.epam.lab.controller.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Hotel;
import com.epam.lab.service.HotelService;

public class HomeController extends DispatcherController {

	private final String URL = "/pages/home.jsp";

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		List<Hotel> hotelList = new LinkedList<Hotel>();
		HttpSession session = request.getSession(false);
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");
		hotelList = new HotelService().randomHotelList(3, bundle.getLocale()
				.getLanguage());
		request.setAttribute("hotelList", hotelList);

		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		forward(URL, request, response);
	}

}
