package com.epam.lab.controller.impl.manager;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Gallery;
import com.epam.lab.model.Hotel;
import com.epam.lab.service.GalleryService;

public class ManagerEditGalleryController extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/edit_gallery.jsp";

	private List<Gallery> galleryList = new ArrayList<Gallery>();
	private GalleryService galleryService = new GalleryService();
	private File file;
	String homeDirectory;

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		homeDirectory = servletContext.getRealPath(File.separator);

		galleryList = galleryService.getHotelGallery(hotel.getId());

		if (request.getParameter("edit_delete") != null) {
			long galleryId = toLong(request.getParameter("edit_id"));
			for (Gallery gallery : galleryList) {
				if (gallery.getId() == galleryId) {

					galleryService.deleteHotelGalleryPhoto(gallery);
					file = new File(homeDirectory + gallery.getPhoto());
					file.delete();
					file = new File(homeDirectory + gallery.getThumb());
					file.delete();

				}

			}
		}

		galleryList = galleryService.getHotelGallery(hotel.getId());

		String howManyMessage = 20 - galleryList.size()
				+ " Photos You can still add";
		if (galleryList.size() >= 20) {
			howManyMessage = "Your Gallery is Full";
		}

		request.setAttribute("howManyMessage", howManyMessage);
		request.setAttribute("galleryList", galleryList);
		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		homeDirectory = servletContext.getRealPath(File.separator);
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		galleryList = galleryService.getHotelGallery(hotel.getId());

		String[] checked = request.getParameterValues("checkedRows");

		if (request.getParameter("delete") != null) {
			if (checked != null) {
				for (Gallery gallery : galleryList) {
					for (String string : checked) {
						if (gallery.getId() == Long.parseLong(string)) {

							galleryService.deleteHotelGalleryPhoto(gallery);

							file = new File(gallery.getPhoto());
							System.out
									.println(gallery.getPhoto() + "hhhhhhhhh");
							file.delete();

							file = new File(gallery.getThumb());
							file.delete();
						}
					}
				}

			}
		}

		galleryList = galleryService.getHotelGallery(hotel.getId());

		String howManyMessage = 20 - galleryList.size()
				+ " Photos You can still add";
		if (galleryList.size() >= 20) {
			howManyMessage = "Your Gallery is Full";
		}
		request.setAttribute("howManyMessage", howManyMessage);
		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("galleryList", galleryList);
		forward(URL, request, response);

	}
}
