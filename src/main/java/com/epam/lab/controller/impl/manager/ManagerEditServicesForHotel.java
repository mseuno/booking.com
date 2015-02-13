package com.epam.lab.controller.impl.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.controller.DispatcherController;
import com.epam.lab.model.Hotel;
import com.epam.lab.model.Service;
import com.epam.lab.model.helper.HotelesServices;
import com.epam.lab.service.HotelServiceService;
import com.epam.lab.service.ServiceService;

public class ManagerEditServicesForHotel extends DispatcherController {

	private final String URL = "/pages/extranet/manager_cabinet/actions/edit_services.jsp";
	private ServiceService serviceService = new ServiceService();
	private HotelServiceService hotelServiceService = new HotelServiceService();

	@Override
	public void executeGet(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {

		HttpSession session = request.getSession();
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		List<HotelesServices> hotelServices = hotelServiceService
				.getListByHotelId(hotel.getId());
		List<Service> services = serviceService.selectServiceByLocale(bundle
				.getLocale().getLanguage());
		for (Service service : services) {
			for (HotelesServices hotelSevice : hotelServices) {
				if (service.getId() == hotelSevice.getServiceId()) {
					service.setIsCheck(true);
				}
			}
		}
		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("services", services);
		forward(URL, request, response);
	}

	@Override
	public void executePost(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, Exception {
		HttpSession session = request.getSession();
		ResourceBundle bundle = (ResourceBundle) session
				.getAttribute("ResourceBundle");
		List<Service> services = serviceService.selectServiceByLocale(bundle
				.getLocale().getLanguage());
		Hotel hotel = (Hotel) session.getAttribute("hotel");

		String[] checked = request.getParameterValues("checkedRows");
		if (request.getParameter("checkedRows") != null) {
			List<HotelesServices> hotelServices = hotelServiceService
					.getListByHotelId(hotel.getId());
			for (HotelesServices hotelesService : hotelServices) {
				hotelServiceService.delete(hotelesService.getId());
			}
			if (checked != null) {
				for (Service service : services) {
					for (String string : checked) {
						if (service.getId() == Long.parseLong(string)) {

							HotelesServices hotelesServices = new HotelesServices();
							hotelesServices.setServiceId(service.getId());
							hotelesServices.setHotelId(hotel.getId());
							hotelServiceService.create(hotelesServices);

						}
					}
				}

			}

		}

		List<HotelesServices> hotelServices = hotelServiceService
				.getListByHotelId(hotel.getId());
		services = serviceService.selectServiceByLocale(bundle.getLocale()
				.getLanguage());
		for (Service service : services) {
			for (HotelesServices hotelSevice : hotelServices) {
				if (service.getId() == hotelSevice.getServiceId()) {
					service.setIsCheck(true);
				}
			}
		}
		request.setAttribute("immURL", hotel.getLogo());
		request.setAttribute("services", services);
		forward(URL, request, response);
	}

}
