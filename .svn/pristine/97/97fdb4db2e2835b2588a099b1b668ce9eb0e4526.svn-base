package com.epam.lab.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.epam.lab.model.Hotel;

public class SearchPaginator {

	public static final int HOTEL_BY_PAGE = 5;

	private Map<String, Sort> sortSelector = new HashMap<String, Sort>();

	private List<Hotel> hotelList = new LinkedList<Hotel>();
	private int currentPosition = 0;

	public SearchPaginator() {
		super();
		sortSelector.put("nameAsc", new SortByNameAscending());
		sortSelector.put("nameDesc", new SortByNameDescending());
		sortSelector.put("priceAsc", new SortByPriceAscending());
		sortSelector.put("priceDesc", new SortByPriceDescending());
		sortSelector.put("ratingAsc", new SortByRatingAscending());
		sortSelector.put("ratingDesc", new SortByRatingDescending());
		sortSelector.put("starAsc", new SortByStarAscending());
		sortSelector.put("starDesc", new SortByStarDescending());
	}

	public int getHotelsCount() {
		return hotelList.size();
	}

	public void sort(String sortType) {
		Sort sorter = sortSelector.get(sortType);
		if (sorter != null) {
			sorter.sort();
		}
		setCurrentPosition(0);
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
		setCurrentPosition(0);
	}

	public List<Hotel> getAll() {
		return hotelList;
	}

	public boolean hasNext() {
		if (currentPosition < hotelList.size())
			return true;
		else
			return false;
	}

	public List<Hotel> getNext(int count) {
		List<Hotel> result = new LinkedList<Hotel>();

		if (hotelList.size() < (currentPosition + count)) {
			count = hotelList.size() - currentPosition;
		}

		for (int i = 0; i < count; i++) {
			result.add(hotelList.get(currentPosition + i));
		}

		setCurrentPosition(getCurrentPosition() + count);

		return result;
	}

	public interface Sort {
		public void sort();
	}

	private class SortByNameAscending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					return h1.getHotelInfo().getName()
							.compareTo(h2.getHotelInfo().getName());
				}
			});
		}

	}

	private class SortByNameDescending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					return h2.getHotelInfo().getName()
							.compareTo(h1.getHotelInfo().getName());
				}
			});
		}

	}

	private class SortByPriceAscending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					if (h1.getMinimumRoomPrice() < h2.getMinimumRoomPrice()) {
						return 1;
					}
					if (h1.getMinimumRoomPrice() > h2.getMinimumRoomPrice()) {
						return -1;
					}
					return 0;
				}
			});
		}

	}

	private class SortByPriceDescending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					if (h1.getMinimumRoomPrice() > h2.getMinimumRoomPrice()) {
						return 1;
					}
					if (h1.getMinimumRoomPrice() < h2.getMinimumRoomPrice()) {
						return -1;
					}
					return 0;
				}
			});
		}

	}

	private class SortByRatingAscending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					if (h1.getAvgRate() < h2.getAvgRate()) {
						return 1;
					}
					if (h1.getAvgRate() > h2.getAvgRate()) {
						return -1;
					}
					return 0;
				}
			});
		}

	}

	private class SortByRatingDescending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					if (h1.getAvgRate() > h2.getAvgRate()) {
						return 1;
					}
					if (h1.getAvgRate() < h2.getAvgRate()) {
						return -1;
					}
					return 0;
				}
			});
		}

	}

	private class SortByStarAscending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					if (h1.getStars() < h2.getStars()) {
						return 1;
					}
					if (h1.getStars() > h2.getStars()) {
						return -1;
					}
					return 0;
				}
			});
		}
	}

	private class SortByStarDescending implements Sort {

		@Override
		public void sort() {
			Collections.sort(hotelList, new Comparator<Hotel>() {
				@Override
				public int compare(Hotel h1, Hotel h2) {
					if (h1.getStars() > h2.getStars()) {
						return 1;
					}
					if (h1.getStars() < h2.getStars()) {
						return -1;
					}
					return 0;
				}
			});
		}

	}

	private int getCurrentPosition() {
		return currentPosition;
	}

	private void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

}
