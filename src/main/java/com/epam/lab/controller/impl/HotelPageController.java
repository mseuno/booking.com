package com.epam.lab.controller.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Gallery;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.User;
import com.epam.lab.model.helper.HotelReview;
import com.epam.lab.service.GalleryService;
import com.epam.lab.service.HotelService;
import com.epam.lab.service.UserService;
import com.epam.lab.utils.SearchParameters;

public class HotelPageController extends DispatcherController {

	private static final Logger LOG = Logger
			.getLogger(HotelPageController.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	private final String URL = "/pages/hotel_page.jsp";
	private final String URL_404 = "/pages/common/page_404.jsp";
	private HotelService hotelService = new HotelService();
	private GalleryService galleryService = new GalleryService();

	@Override
	public void executeGet(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		String hotelIdStr = request.getParameter("id");
		if (hotelIdStr != null) {
			try {

				long hotelId = toLong(hotelIdStr);
				ResourceBundle bundle = (ResourceBundle) request.getSession()
						.getAttribute("ResourceBundle");
				getHotelData(request, response, hotelId, bundle);
			} catch (ParseException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
				forward(URL_404, request, response);
			}
		} else {
			forward(URL_404, request, response);
		}
	}

	@Override
	public void executePost(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException, Exception {

		String hotelIdStr = request.getParameter("id");
		String hotelReviewStr = request.getParameter("review_text");
		String hotelRateStr = request.getParameter("rating");
		User user = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") instanceof User) {
			user = (User) session.getAttribute("user");
		}

		if (user == null || hotelIdStr == null || hotelReviewStr == null
				|| hotelRateStr == null) {
			return;
		}

		if (hotelService.checkIfUserCanAddReview(user.getId(),
				toLong(hotelIdStr))) {
			HotelReview review = new HotelReview();
			review.setUserName(user.getFirstName());
			review.setReview(hotelReviewStr);
			review.setRating(Byte.parseByte(hotelRateStr));

			hotelService.addHotelReview(user.getId(), toLong(hotelIdStr),
					review);
		}
		redirect("hotel?id=" + hotelIdStr, response, context);
	}

	private void getHotelData(HttpServletRequest request,
			HttpServletResponse response, long hotelId, ResourceBundle bundle)
			throws IOException, ServletException, ParseException {
		String dateFrom = request.getParameter("date_from");
		String dateTo = request.getParameter("date_to");
		Hotel hotel = null;

		hotel = hotelService.selectHotelByHotelId(hotelId, bundle.getLocale()
				.getLanguage(), request.getSession().getAttribute("user"));

		if (hotel != null) {

			List<Gallery> gallery = galleryService.getHotelGallery(hotelId);
			request.setAttribute("hotel", hotel);
			request.setAttribute("gallery", gallery);
			request.setAttribute("date_from", dateFrom);
			request.setAttribute("date_to", dateTo);

			// add users reviews on page
			List<HotelReview> hotelReviews = hotelService
					.getAllHotelReview(hotelId);
			if (!hotelReviews.isEmpty()) {
				request.setAttribute("hotel_page_reviews", hotelReviews);
			}

			// block with result only for registered users
			User user = null;
			HttpSession session = request.getSession();
			if (session.getAttribute("user") instanceof User) {
				user = (User) session.getAttribute("user");
			}

			if (user != null) {
				Long userId = user.getId();
				// check if hotel is favorite
				request.setAttribute("showFavoriteButton", true);
				boolean result = new UserService().checkIfHotelIsFavorite(
						userId, hotelId);
				request.setAttribute("hotelIsFavorite", result);
				// check if user can add review
				if (hotelService.checkIfUserCanAddReview(userId, hotelId)) {
					request.setAttribute("canAddReview", true);
					HotelReview hotelRating = hotelService.getHotelReview(
							userId, hotelId);
					if (hotelRating != null) {
						request.setAttribute("review_text",
								hotelRating.getReview());
					}

				}

			}

			getRoomsInfo(request, dateFrom, dateTo, hotel);

			forward(URL, request, response);
		} else {
			forward(URL_404, request, response);
		}
	}

	private void getRoomsInfo(HttpServletRequest request, String dateFrom,
			String dateTo, Hotel hotel) throws ParseException {

		if (dateFrom != null && dateTo != null && !dateFrom.isEmpty()
				&& !dateTo.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

			Calendar beginDate = Calendar.getInstance();
			Calendar endDate = Calendar.getInstance();
			beginDate.setTime(dateFormat.parse(dateFrom));
			endDate.setTime(dateFormat.parse(dateTo));

			SearchParameters parameters = new SearchParameters();
			parameters.setBeginDate(beginDate);
			parameters.setEndDate(endDate);

			hotelService.getAvailableRoomsForBooking(hotel, parameters);
			request.setAttribute("showAvailableRooms", true);
		} else {
			request.setAttribute("showAvailableRooms", false);
		}
	}

}
