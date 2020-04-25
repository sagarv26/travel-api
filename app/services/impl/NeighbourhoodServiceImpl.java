package services.impl;

import java.util.List;

import com.google.inject.Inject;

import dao.NeighbourhoodDAO;
import models.Neighbourhood;
import services.NeighbourhoodService;

public class NeighbourhoodServiceImpl implements NeighbourhoodService {

	private final NeighbourhoodDAO neighbourhoodDao;

	@Inject
	public NeighbourhoodServiceImpl(NeighbourhoodDAO neighbourhoodDao) {
		this.neighbourhoodDao = neighbourhoodDao;
	}

	@Override
	public List<Neighbourhood> getNeighbourhood() {

		return neighbourhoodDao.getNeighbourhood();
	}

}
