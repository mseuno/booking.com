package com.epam.lab.controller.impl.common;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.City;
import com.epam.lab.model.Region;
import com.epam.lab.model.Street;
import com.epam.lab.utils.Location;

public class LocationSelectorController extends DispatcherController {

	private final String URL = "/pages/common/select_body.jsp";
	private Location location = new Location();

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {
		String action = request.getParameter("action");
		String language = ((ResourceBundle) request.getSession().getAttribute(
				"ResourceBundle")).getLocale().getLanguage();
		if (action == null) {
			return;
		} else if (action.equals("getRegion")) {
			long id = toLong(request.getParameter("country_id"));
			List<Region> regionList = location.getRegionList(id, language);
			request.setAttribute("elements", regionList);
		} else if (action.equals("getCity")) {
			long id = toLong(request.getParameter("region_id"));
			List<City> cityList = location.getCitiesList(id, language);
			request.setAttribute("elements", cityList);

		} else if (action.equals("getStreet")) {
			long id = toLong(request.getParameter("city_id"));
			List<Street> streetList = location.getStreetsList(id, language);
			request.setAttribute("elements", streetList);
		}
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

	}

}
