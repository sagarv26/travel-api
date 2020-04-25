package services.impl;

import java.util.List;

import com.google.inject.Inject;

import dao.PlaceDAO;
import models.Places;
import services.PlaceService;

public class PlaceServiceImpl implements PlaceService {

	private final PlaceDAO placeDao;

	@Inject
	public PlaceServiceImpl(PlaceDAO placeDao) {
		this.placeDao = placeDao;
	}

	@Override
	public List<Places> getAllPlace() {

		return placeDao.getAllPlace();
	}

	@Override
	public List<Places> getAllPlaceOrder() {

		return placeDao.getAllPlaceOrder();
	}

}
