package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import models.Neighbourhood;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import services.NeighbourhoodService;

public class NeighbourhoodController extends BaseController {

	private NeighbourhoodService neighbourhoodService;

	@Inject
	public NeighbourhoodController(NeighbourhoodService neighbourhoodService) {
		this.neighbourhoodService = neighbourhoodService;
	}

	public F.Promise<Result> getNeighbourhood() {
		return F.Promise.promise(() -> {
			Map<String, Object> hashMap = new HashMap<>();
			List<Neighbourhood> district = neighbourhoodService.getNeighbourhood();
			hashMap.put("Neighbourhood", district);
			return ok(Json.toJson(hashMap));
		});
	}

}