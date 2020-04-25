package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.inject.Inject;

import models.Places;

public class PlaceDAO extends BaseDao {

	@Inject
	public PlaceDAO() {
		super();
	}

	public List<Places> getAllPlace() {
		List<Places> placeList = new ArrayList<>();

		try {
			placeList = db.find(Places.class).findList();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return placeList;
	}

	public List<Places> getAllPlaceOrder() {

		List<Places> placeList = db.find(Places.class).findList();
		Collections.sort(placeList, new PlacesComparator());
		return placeList;
	}
}
