package services;

import java.util.List;
import java.util.Map;

import models.Neighbourhood;

public interface NeighbourhoodService {

	List<Neighbourhood> getNeighbourhood();

	Map<String, Object> getNeighbourhoodWithDist();

}
