package com.epam.lab.controller.helper;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.epam.lab.controller.Controller;
import com.epam.lab.controller.impl.AboutController;
import com.epam.lab.controller.impl.AutocompleteController;
import com.epam.lab.controller.impl.ExtranetController;
import com.epam.lab.controller.impl.FavoriteController;
import com.epam.lab.controller.impl.HomeController;
import com.epam.lab.controller.impl.HotelPageController;
import com.epam.lab.controller.impl.SearchController;
import com.epam.lab.controller.impl.SignOutController;
import com.epam.lab.controller.impl.admin.AdminCityController;
import com.epam.lab.controller.impl.admin.AdminCountryController;
import com.epam.lab.controller.impl.admin.AdminHomeController;
import com.epam.lab.controller.impl.admin.AdminHotelsController;
import com.epam.lab.controller.impl.admin.AdminLocaleController;
import com.epam.lab.controller.impl.admin.AdminLoginController;
import com.epam.lab.controller.impl.admin.AdminManagerResponsController;
import com.epam.lab.controller.impl.admin.AdminNewAdminController;
import com.epam.lab.controller.impl.admin.AdminProfileController;
import com.epam.lab.controller.impl.admin.AdminRegionController;
import com.epam.lab.controller.impl.admin.AdminServiceController;
import com.epam.lab.controller.impl.admin.AdminStreetController;
import com.epam.lab.controller.impl.common.BookingController;
import com.epam.lab.controller.impl.common.LocationSelectorController;
import com.epam.lab.controller.impl.manager.ManagerAddGalleryController;
import com.epam.lab.controller.impl.manager.ManagerAddNewRoomController;
import com.epam.lab.controller.impl.manager.ManagerAdminRequestController;
import com.epam.lab.controller.impl.manager.ManagerBookingController;
import com.epam.lab.controller.impl.manager.ManagerEditGalleryController;
import com.epam.lab.controller.impl.manager.ManagerEditHotelController;
import com.epam.lab.controller.impl.manager.ManagerEditLogoController;
import com.epam.lab.controller.impl.manager.ManagerEditRoomsController;
import com.epam.lab.controller.impl.manager.ManagerEditServicesForHotel;
import com.epam.lab.controller.impl.manager.ManagerHomeController;
import com.epam.lab.controller.impl.manager.ManagerLoginController;
import com.epam.lab.controller.impl.manager.ManagerMessageListController;
import com.epam.lab.controller.impl.manager.ManagerNewBookingController;
import com.epam.lab.controller.impl.manager.ManagerProfileController;
import com.epam.lab.controller.impl.manager.ManagerRegistrationController;
import com.epam.lab.controller.impl.manager.ManagerRequiredInfoController;
import com.epam.lab.controller.impl.user.UserFavoritesController;
import com.epam.lab.controller.impl.user.UserHistoryController;
import com.epam.lab.controller.impl.user.UserHomeController;
import com.epam.lab.controller.impl.user.UserLoginController;
import com.epam.lab.controller.impl.user.UserProfileController;
import com.epam.lab.controller.impl.user.UserRegistrationController;

/*
 *  Фабрика містить хешмапу <адресса, котролер> 
 *  
 * */

public class FactoryController {

	public static FactoryController INSTANCE = new FactoryController();

	private HashMap<String, Class<? extends Controller>> controllers = new HashMap<String, Class<? extends Controller>>();

	public FactoryController() {
		controllers.put("/", HomeController.class);
		controllers.put("/autocomplete", AutocompleteController.class);
		controllers.put("/hotel", HotelPageController.class);
		controllers.put("/home", HomeController.class);
		controllers.put("/signout", SignOutController.class);

		controllers.put("/adminlogin", AdminLoginController.class);
		controllers.put("/userregistration", UserRegistrationController.class);
		controllers.put("/extranet", ExtranetController.class);
		controllers.put("/about", AboutController.class);
		controllers.put("/search", SearchController.class);
		controllers.put("/book-room", BookingController.class);
		controllers.put("/hotel-page-favorites", FavoriteController.class);
		controllers.put("/review", FavoriteController.class);
		controllers
				.put("/managerrequired", ManagerRequiredInfoController.class);

		/*
		 * Manager
		 */
		controllers.put("/managerregistration",
				ManagerRegistrationController.class);
		controllers.put("/managerlogin", ManagerLoginController.class);
		controllers.put("/edithotel", ManagerEditHotelController.class);
		controllers.put("/cabinetbooking", ManagerBookingController.class);
		controllers.put("/newbooking", ManagerNewBookingController.class);
		controllers.put("/manager", ManagerHomeController.class);
		controllers.put("/editgallery", ManagerEditGalleryController.class);
		controllers.put("/managerprofile", ManagerProfileController.class);
		controllers.put("/managerrequest", ManagerAdminRequestController.class);
		controllers.put("/editlogo", ManagerEditLogoController.class);
		controllers.put("/addgallery", ManagerAddGalleryController.class);
		controllers.put("/addnewroom", ManagerAddNewRoomController.class);
		controllers.put("/editrooms", ManagerEditRoomsController.class);
		controllers.put("/editservices", ManagerEditServicesForHotel.class);
		controllers.put("/messagelist", ManagerMessageListController.class);

		/*
		 * Admin
		 */
		controllers.put("/adminhome", AdminHomeController.class);
		controllers.put("/adminhotels", AdminHotelsController.class);
		controllers.put("/admincountry", AdminCountryController.class);
		controllers.put("/adminregion", AdminRegionController.class);
		controllers.put("/admincity", AdminCityController.class);
		controllers.put("/adminstreet", AdminStreetController.class);
		controllers.put("/adminreply", AdminManagerResponsController.class);
		controllers.put("/adminservice", AdminServiceController.class);
		controllers.put("/newadmin", AdminNewAdminController.class);
		controllers.put("/adminprofile", AdminProfileController.class);
		controllers.put("/adminlocale", AdminLocaleController.class);
		/*
		 * User
		 */
		controllers.put("/user", UserHomeController.class);
		controllers.put("/userfavorites", UserFavoritesController.class);
		controllers.put("/userhistory", UserHistoryController.class);
		controllers.put("/userlogin", UserLoginController.class);
		controllers.put("/userprofile", UserProfileController.class);

		// Common
		controllers.put("/location-selector", LocationSelectorController.class);

	}

	public static Controller getController(HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		String command = request.getRequestURI().substring(
				request.getContextPath().length());
		Controller controller = INSTANCE.controllers.get(command).newInstance();
		return controller;
	}

	public static Controller getController(String url)
			throws InstantiationException, IllegalAccessException {
		Controller controller = INSTANCE.controllers.get(url).newInstance();
		return controller;
	}
}
