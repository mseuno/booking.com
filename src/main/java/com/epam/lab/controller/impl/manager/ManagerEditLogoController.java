package com.epam.lab.controller.impl.manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
import com.epam.lab.model.Hotel;
import com.epam.lab.service.HotelService;

public class ManagerEditLogoController extends DispatcherController {

	private static final Logger LOG = Logger
			.getLogger(ManagerEditLogoController.class);

	{
		PropertyConfigurator.configure(getClass().getResourceAsStream(
				"/config/log4j.properties"));
	}

	private final String URL = "/pages/extranet/manager_cabinet/actions/edit_logo.jsp";
	private String message;
	private String homeDirectory;
	private HotelService hotelService = new HotelService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		homeDirectory = servletContext.getRealPath(File.separator);
		System.out.println(servletContext.getRealPath(File.separator));

		HttpSession session = request.getSession(false);
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		// Hotel hotel =
		// hotelService.selectHotelByManagerId(bundle.getLocale().getLanguage(),(Manager)
		// session.getAttribute("user"));

		request.setAttribute("immURL", hotel.getLogo());
		forward(URL, request, response);

	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		homeDirectory = servletContext.getRealPath(File.separator);

		HttpSession session = request.getSession(false);
		Hotel hotel = (Hotel) session.getAttribute("hotel");
		// Hotel hotel = hotelService.selectHotelByManagerId("en",(Manager)
		// session.getAttribute("user"));

		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						message = "File is to big";
						if (item.getSize() < 1000000) {
							message = "File dont selected";
							if (item.getSize() > 0) {
								message = "Files type not supported";
								if (item.getContentType().equalsIgnoreCase(
										"image/jpeg")) {

									String name = "logo.jpeg";
									String relativeDirectoryForDb = "/bookingData/"
											+ hotel.getId();
									String uploadDirectory = homeDirectory
											+ relativeDirectoryForDb;

									File mkdr = new File(uploadDirectory);
									mkdr.mkdirs();
									item.write(new File(uploadDirectory + "/"
											+ name));

									BufferedImage originalImage = ImageIO
											.read(new File(uploadDirectory
													+ "/" + name));
									int type = originalImage.getType();

									int border = 70;
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
									Graphics2D graphics = resizedImage
											.createGraphics();
									graphics.drawImage(originalImage, 0, 0,
											img_width, img_height, null);
									graphics.dispose();
									ImageIO.write(resizedImage, "jpg",
											new File(uploadDirectory + "/"
													+ name));

									hotel.setLogo(relativeDirectoryForDb + "/"
											+ name);
									message = "Logo Uploaded Successfully";

								}
							}
						}
					}
				}
				System.out.println("ManagerEditLogoController " + message);
			} catch (Exception e) {
				LOG.error(e.getMessage());
				System.out.println("Logo Upload Failed due to "
						+ e.getLocalizedMessage());
			}

		}

		hotelService.updateHotel(hotel);

		System.out.println(hotel.getLogo());

		request.setAttribute("message", message);
		request.setAttribute("immURL", hotel.getLogo());

		forward(URL, request, response);

	}
}
