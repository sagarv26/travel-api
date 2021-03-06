package dao;

import java.util.Comparator;

import models.Places;

class PlacesComparator implements Comparator<Object> {

	public int compare(Object o1, Object o2) {
		Places p1 = (Places) o1;
		Places p2 = (Places) o2;
		return p1.place_name.compareTo(p2.place_name);
	}

}
