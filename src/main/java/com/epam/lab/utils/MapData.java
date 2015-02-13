package com.epam.lab.utils;

import java.util.List;

import com.epam.lab.model.Hotel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MapData {

	public static JsonArray getMarkersForMap(List<Hotel> hotels) {
		JsonArray result = new JsonArray();

		for (Hotel hotel : hotels) {
			JsonObject object = new JsonObject();

			object.addProperty("id", hotel.getId());
			JsonElement element = getHotelInfoForMap(hotel);
			object.add("info", element);

			result.add(object);
		}

		return result;
	}

	private static JsonElement getHotelInfoForMap(Hotel hotel) {
		JsonObject element = new JsonObject();

		element.addProperty("latitude", hotel.getLatitude());
		element.addProperty("longitude", hotel.getLongitude());
		element.addProperty("name", hotel.getHotelInfo().getName());
		element.addProperty("logo", hotel.getLogo());
		element.addProperty("stars", hotel.getStars());

		return element;
	}

}
