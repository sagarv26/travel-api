package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import models.Places;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import services.PlaceService;

public class PlaceController extends BaseController {

	private PlaceService placeService;

	@Inject
	public PlaceController(PlaceService placeService) {
		this.placeService = placeService;
	}

	public F.Promise<Result> getAllDistrict() {
		return F.Promise.promise(() -> {
			Map<String, Object> hashMap = new HashMap<>();
			List<Places> place = placeService.getAllPlace();
			hashMap.put("Places", place);
			return ok(Json.toJson(hashMap));
		});
	}

	public Result getAllPlaceOrder() {
		Map<String, Object> hashMap = new HashMap<>();
		List<Places> place = placeService.getAllPlaceOrder();
		hashMap.put("Places", place);
		return ok(Json.toJson(hashMap));
	}

}
