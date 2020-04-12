package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import models.District;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import services.DistrictService;

public class DistrictController extends BaseController {

	private final DistrictService districtService;

	@Inject
	public DistrictController(DistrictService districtService) {
		super();
		this.districtService = districtService;
	}

	public F.Promise<Result> getAllDistrict() {
		System.out.println("Calling Controller");

		return F.Promise.promise(() -> {
			Map<String, Object> hashMap = new HashMap<>();
			List<District> district = districtService.getAllDistrict();
			hashMap.put("District", district);
			return ok(Json.toJson(hashMap));
		});
	}

	public Result getAllDistrictsOrder() {
		Map<String, Object> hashMap = new HashMap<>();
		List<District> district = districtService.getAllDistrictsOrder();
		hashMap.put("District", district);
		return ok(Json.toJson(hashMap));
	}
}