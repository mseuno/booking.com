package com.epam.lab.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RoomAccessibility {
	private long room_id;
	public Map<String, Integer> accessibilityMap = new HashMap<String, Integer>();
	private Calendar beginDate;
	private Calendar endDate;
	private int numberOfPeople;

	public void setDates(Calendar beginDate, Calendar endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	public Map<String, Integer> getAccessibilityMap() {
		return accessibilityMap;
	}

	public void setAccessibilityMap(Map<String, Integer> accessibilityMap) {
		this.accessibilityMap = accessibilityMap;
	}

	public HotelAccessibility getRoomAccessebility() {
		HotelAccessibility result = new HotelAccessibility();
		result.setNumberOfPeople(-1);
		result.setNumberOfRooms(-1);
		for (Entry<String, Integer> entry : accessibilityMap.entrySet()) {
			// Ініціалізація першим значенням
			if (result.getNumberOfRooms() == -1) {
				result.setNumberOfRooms(entry.getValue());
			}
			if (result.getNumberOfRooms() > entry.getValue()) {
				result.setNumberOfRooms(entry.getValue());
			}
		}
		result.setNumberOfPeople(result.getNumberOfRooms() * numberOfPeople);
		return result;
	}

	public void initiate(Calendar beginCalendar, Calendar endCalendar,
			int numberOfRooms, int numberOfPeople) {
		// Клоную об'єкти, бо інакше вони зміннються в тілі методу
		Calendar beginDate = (Calendar) beginCalendar.clone();
		Calendar endDate = (Calendar) endCalendar.clone();

		this.beginDate = beginDate;
		this.endDate = endDate;
		this.numberOfPeople = numberOfPeople;
		accessibilityMap.clear();

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		while (endDate.compareTo(beginDate) >= 0) {
			accessibilityMap.put(dateFormat.format(beginDate.getTime()),
					numberOfRooms);
			beginDate.add(Calendar.DATE, 1);
		}

	}

	public void addBooking(Calendar beginCalendar, Calendar endCalendar,
			int numberOfRooms) {
		// Клоную об'єкти, бо інакше вони зміннються в тілі методу
		Calendar beginDate = (Calendar) beginCalendar.clone();
		Calendar endDate = (Calendar) endCalendar.clone();

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		while (endDate.compareTo(beginDate) >= 0) {
			String key = dateFormat.format(beginDate.getTime());
			if (accessibilityMap.containsKey(key)) {
				accessibilityMap.put(key, accessibilityMap.get(key)
						- numberOfRooms);
			}
			beginDate.add(Calendar.DATE, 1);
		}
	}

}
