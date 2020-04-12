package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.google.inject.Inject;

import models.District;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class GetValue extends Controller {
	private final EbeanServer db;

	@Inject
	public GetValue() {
		db = Ebean.getServer("default");
	}

	public Result getAllDist() {
		Map<String, Object> hashMap = new HashMap<>();
		List<District> distList = db.find(District.class).findList();
		hashMap.put("District", distList);
		return ok(Json.toJson(hashMap));
	}

}
