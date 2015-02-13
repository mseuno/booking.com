package com.epam.lab.controller.impl.manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Gallery;
import com.epam.lab.model.Hotel;
import com.epam.lab.service.GalleryService;

public class ManagerAddGalleryController extends DispatcherController {

	private static final Logger LOG = Logger
			.getLogger(ManagerAddGalleryController.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	private final String URL = "/pages/extranet/manager_cabinet/actions/add_gallery.jsp";
	private GalleryService galleryService = new GalleryService();
	private Gallery gallery = new Gallery();
	private String message;
	private String homeDirectory;
	private List<Gallery> galleryList = new ArrayList<Gallery>();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();

		Hotel hotel = (Hotel) session.getAttribute("hotel");

		homeDirectory = servletContext.getRealPath(File.separator);

		galleryList = galleryService.getHotelGallery(hotel.getId());
		response.reset();

		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		response.reset();
		homeDirectory = servletContext.getRealPath(File.separator);

		HttpSession session = request.getSession();

		Hotel hotel = (Hotel) session.getAttribute("hotel");

		galleryList = galleryService.getHotelGallery(hotel.getId());

		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				message = "Too many files. You gallery can contain 20 files";
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);
				if ((multiparts.size() + galleryList.size()) <= 20) {
					for (FileItem item : multiparts) {

						if (!item.isFormField()) {
							message = "File is to big";
							if (item.getSize() < 5000000) {
								message = "File dont selected";
								if (item.getSize() > 0) {
									System.out.println(item.getSize());
									Date date = new Date();
									String name = "gallery" + date.getTime()
											+ ".jpeg";
									Thread.sleep(1);
									String relativePhotoDirectory = "/bookingData/"
											+ hotel.getId() + "/gallery";
									String relativeThumbDirectory = "/bookingData/"
											+ hotel.getId() + "/gallery/Thumb";

									String uploadPhotoDirectory = homeDirectory
											+ relativePhotoDirectory;
									String uploadThumbDirectory = homeDirectory
											+ relativeThumbDirectory;

									File mkdr = new File(uploadPhotoDirectory);
									mkdr.mkdirs();
									item.write(new File(uploadPhotoDirectory
											+ "/" + name));

									File makedr = new File(uploadThumbDirectory);
									makedr.mkdirs();
									BufferedImage originalImage = ImageIO
											.read(new File(uploadPhotoDirectory
													+ "/" + name));
									int type = originalImage.getType();

									int border = 200;
									int img_width = 0;
									int img_height = 0;
									if (originalImage.getTileWidth() > border
											&& originalImage.getHeight() > border) {
										if (originalImage.getTileWidth() > originalImage
												.getHeight()) {
											float cof = (float) originalImage
													.getTileWidth() / border;
											img_width = (int) (originalImage
													.getTileWidth() / cof);
											img_height = (int) (originalImage
													.getHeight() / cof);
										} else {
											float cof = originalImage
													.getHeight() / border;
											img_width = (int) (originalImage
													.getTileWidth() / cof);
											img_height = (int) (originalImage
													.getHeight() / cof);
										}
									} else {
										img_width = originalImage
												.getTileWidth();
										img_height = originalImage.getHeight();
									}

									BufferedImage resizedImage = new BufferedImage(
											img_width, img_height, type);
									Graphics2D g = resizedImage
											.createGraphics();
									g.drawImage(originalImage, 0, 0, img_width,
											img_height, null);
									g.dispose();
									ImageIO.write(resizedImage, "jpg",
											new File(uploadThumbDirectory + "/"
													+ name));

									gallery.setPhoto(relativePhotoDirectory
											+ "/" + name);
									gallery.setThumb(relativeThumbDirectory
											+ "/" + name);
									gallery.setHotelId(hotel.getId());

									galleryService.createHotelGallery(gallery);

									message = "File Uploaded Successfully";

								}
							}
						}
					}
				}

			} catch (Exception e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
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
		request.setAttribute("message", message);

		response.sendRedirect("editgallery");

	}

}
