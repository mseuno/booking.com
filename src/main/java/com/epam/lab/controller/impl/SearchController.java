package com.epam.lab.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.City;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Region;
import com.epam.lab.service.CityService;
import com.epam.lab.service.HotelService;
import com.epam.lab.service.RegionService;
import com.epam.lab.utils.MapData;
import com.epam.lab.utils.SearchEngine;
import com.epam.lab.utils.SearchPaginator;
import com.epam.lab.utils.SearchParameters;

public class SearchController extends DispatcherController {

	private final String URL = "/pages/search_results.jsp";
	private final String URL_SEARCH_FRAGMENT = "/pages/search-fragments/hotel_results.jsp";

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		HttpSession session = request.getSession(false);
		SearchEngine searchEngine = new SearchEngine();
		SearchPaginator searchPaginator = new SearchPaginator();

		Calendar beginDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");

		SearchParameters searchParameters = new SearchParameters();
		try {
			if (parameterExist(request, "id_region"))
				searchParameters.setRegionId(Long.parseLong(request
						.getParameter("id_region").trim()));
			request.setAttribute("id_region", request.getParameter("id_region"));
			if (parameterExist(request, "id_city"))
				searchParameters.setCityId(Long.parseLong(request.getParameter(
						"id_city").trim()));
			request.setAttribute("id_city", request.getParameter("id_city"));
			if (parameterExist(request, "id_hotel"))
				searchParameters.setHotelId(Long.parseLong(request
						.getParameter("id_hotel").trim()));
			searchParameters.setLocale(bundle.getLocale().getLanguage());
			if (parameterExist(request, "search_name")) {
				searchParameters.setSearchName(request.getParameter(
						"search_name").trim());
				request.setAttribute("search_name",
						searchParameters.getSearchName());
			}

			if (parameterExist(request, "unknown_date")) {
				// searchParameters.setSearchName(request.getParameter("unknown_date").trim());
				request.setAttribute("unknown_date", true);
			}

			if (parameterExist(request, "people_count")) {
				searchParameters.setNumberOfPeople(Integer.parseInt(request
						.getParameter("people_count").trim()));
				request.setAttribute("people_count",
						searchParameters.getNumberOfPeople());
			}
			if (parameterExist(request, "room_count")) {
				searchParameters.setNumberOfRooms(Integer.parseInt(request
						.getParameter("room_count").trim()));
				request.setAttribute("room_count",
						searchParameters.getNumberOfRooms());
			}

			if (parameterExist(request, "date_from")) {
				beginDate.setTime(dateFormat.parse(request
						.getParameter("date_from")));
				searchParameters.setBeginDate(beginDate);
				request.setAttribute("date_from",
						request.getParameter("date_from"));
			}
			if (parameterExist(request, "date_to")) {
				endDate.setTime(dateFormat.parse(request
						.getParameter("date_to")));
				searchParameters.setEndDate(endDate);
				request.setAttribute("date_to", request.getParameter("date_to"));
			}
		} catch (Exception e) {
			// if parameters are incorrect - go to home page
			e.printStackTrace();
			forward("home", request, response);
			return;
		}

		request.setAttribute("SearchController_autocomplete_search", "true");
		if (searchParameters.getRegionId() != null) {
			searchPaginator.setHotelList(searchEngine
					.searchByRegionId(searchParameters));
		} else if (searchParameters.getCityId() != null) {
			searchPaginator.setHotelList(searchEngine
					.searchByCityId(searchParameters));

			// } else if(searchParameters.getHotelId() != null) {
			// searchPaginator.setHotelList(searchEngine.searchByHotelId(searchParameters));
			// session.setAttribute("searchPaginatro", searchPaginator);
			// request.setAttribute("hotel",
			// searchPaginator.getNext(SearchPaginator.hotelsByPage));
		} else if (searchParameters.getSearchName() != null) {
			List<City> cities = new LinkedList<City>();
			List<Region> regions = new LinkedList<Region>();
			List<Hotel> hotels = new LinkedList<Hotel>();

			if (searchParameters.getSearchName() != null
					&& !searchParameters.getSearchName().isEmpty()) {
				cities = new CityService()
						.selectFullInfoByName(searchParameters.getSearchName());
				regions = new RegionService()
						.selectFullInfoByName(searchParameters.getSearchName());
				hotels = new HotelService()
						.selectFullInfoByName(searchParameters.getSearchName());
			}

			request.setAttribute("SearchController_cities", cities);
			request.setAttribute("SearchController_regions", regions);
			request.setAttribute("SearchController_hotels", hotels);

			request.setAttribute("SearchController_autocomplete_search",
					"false");

			System.out.println("search by name");
		}
		session.setAttribute("searchPaginator", searchPaginator);
		request.setAttribute("hotelList",
				searchPaginator.getNext(SearchPaginator.HOTEL_BY_PAGE));
		request.setAttribute("total_hotels_found",
				searchPaginator.getHotelsCount());

		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {
		HttpSession session = request.getSession(false);
		SearchPaginator searchPaginator = (SearchPaginator) session
				.getAttribute("searchPaginator");

		if (searchPaginator == null) {
			return;
		}

		String action = request.getParameter("action");

		if (action == null) {
			return;
		}

		if (action.equals("getNextResults")) {
			getNextPage(request, response, searchPaginator);
		} else if (action.equals("getHotelsForMap")) {
			PrintWriter printWriter = response.getWriter();
			printWriter
					.print(MapData.getMarkersForMap(searchPaginator.getAll()));
			printWriter.flush();
		} else if (action.equals("sort")) {
			String sortParam = request.getParameter("type");
			if (sortParam == null) {
				sortParam = "nameDesc";
			}
			searchPaginator.sort(sortParam);
			getNextPage(request, response, searchPaginator);
		}

	}

	private void getNextPage(HttpServletRequest request,
			HttpServletResponse response, SearchPaginator searchPaginator)
			throws IOException, ServletException {
		if (searchPaginator.hasNext()) {
			request.setAttribute("hotelList",
					searchPaginator.getNext(SearchPaginator.HOTEL_BY_PAGE));
			forward(URL_SEARCH_FRAGMENT, request, response);
		}
	}

	private boolean parameterExist(HttpServletRequest request, String parameter) {
		return (request.getParameter(parameter) != null)
				&& !(request.getParameter(parameter).isEmpty());
	}
}
