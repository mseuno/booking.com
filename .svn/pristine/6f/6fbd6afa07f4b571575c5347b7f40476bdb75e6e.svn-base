package com.epam.lab.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.City;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Region;
import com.epam.lab.service.CityService;
import com.epam.lab.service.HotelService;
import com.epam.lab.service.RegionService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AutocompleteController extends DispatcherController {

	private RegionService regionService = new RegionService();
	private CityService cityService = new CityService();

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {
		String name = request.getParameter("term");

		ResourceBundle bundle = (ResourceBundle) request.getSession()
				.getAttribute("ResourseBundle");

		JsonArray result = new JsonArray();
		getCities(name, result, bundle);
		getRegions(name, result, bundle);
		getHotels(name, result, bundle);

		PrintWriter printWriter = response.getWriter();
		printWriter.print(result);
		printWriter.flush();
	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

	}

	private void getHotels(String name, JsonArray result, ResourceBundle bundle) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		if (name != null && !name.isEmpty()) {
			hotels = new HotelService().selectFullInfoByName(name);
		}

		if (hotels == null) {
			return;
		}

		for (Hotel hotel : hotels) {
			JsonObject jsonObject = new JsonObject();
			StringBuilder builder = new StringBuilder();
			builder.append(hotel.getHotelInfo().getName());
			builder.append(", ");
			builder.append(hotel.getCity().getName());
			builder.append(", ");
			builder.append(hotel.getRegion().getName());
			builder.append(", ");
			builder.append(hotel.getCountry().getName());

			jsonObject.addProperty("id", hotel.getId());
			jsonObject.addProperty("value", builder.toString());
			jsonObject.addProperty("type", "hotel");

			result.add(jsonObject);
		}
	}

	private void getRegions(String name, JsonArray result, ResourceBundle bundle) {
		List<Region> regions = new ArrayList<Region>();
		if (name != null && !name.isEmpty()) {
			regions = regionService.selectFullInfoByName(name);
		}

		if (regions == null) {
			return;
		}

		for (Region region : regions) {
			JsonObject jsonObject = new JsonObject();
			StringBuilder builder = new StringBuilder();
			builder.append(region.getName());
			builder.append(", ");
			builder.append(region.getCountry().getName());

			jsonObject.addProperty("id", region.getId());
			jsonObject.addProperty("value", builder.toString());
			jsonObject.addProperty("type", "region");

			result.add(jsonObject);
		}
	}

	private void getCities(String name, JsonArray result, ResourceBundle bundle) {
		List<City> cities = new ArrayList<City>();
		if (name != null && !name.isEmpty()) {
			cities = cityService.selectFullInfoByName(name);
		}
		if (cities == null) {
			return;
		}

		for (City city : cities) {
			JsonObject jsonObject = new JsonObject();
			StringBuilder builder = new StringBuilder();
			builder.append(city.getName());
			builder.append(", ");
			builder.append(city.getRegion().getName());
			builder.append(", ");
			builder.append(city.getCountry().getName());

			jsonObject.addProperty("id", city.getId());
			jsonObject.addProperty("value", builder.toString());
			jsonObject.addProperty("type", "city");

			result.add(jsonObject);
		}
	}

}
