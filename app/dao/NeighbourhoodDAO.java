package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.google.inject.Inject;

import models.District;
import models.Neighbourhood;
import models.PlaceValues;
import models.Places;
import models.StateValue;
import utils.Utils;

public class NeighbourhoodDAO extends BaseDao {

	@Inject
	public NeighbourhoodDAO() {
		super();
	}

	public List<Neighbourhood> getNeighbourhood() {
		List<Neighbourhood> placeList = new ArrayList<>();

		try {
			String sql = "SELECT ID, Place, place_name \"Neighbourhoods\" from place_list INNER JOIN (SELECT  place_list.id_place \"ID\", place_list.place_name as \"Place\", neighbourhoods.id_neighbourhood \"neighbourhoodsID\" FROM place_list INNER JOIN neighbourhoods ON place_list.id_place = neighbourhoods.id_place) n \n"
					+ "on place_list.id_place = n.neighbourhoodsID";
			SqlQuery query = db.createSqlQuery(sql);
			List<SqlRow> list = query.findList();

			placeList = Utils.convertObjectList(list, Neighbourhood.class);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return placeList;
	}

	public Map<String, Object> getNeighbourhoodWithDist() {
		Map<String, Object> final_out = new HashMap<>();
		List<District> distList = db.find(District.class).findList();
		try {
			for (District district : distList) {
				Map<String, Object> dist_map = new HashMap<>();
				dist_map.put("dist_info", district);

				Map<String, Object> place_obj = new HashMap<>();
				List<Places> placeList = db.find(Places.class).where().eq("id_dist", district.id_dist).findList();
				for (Places place : placeList) {
					Map<String, Object> place_map = new HashMap<>();
					if (district.id_dist == place.id_dist) {
						place_map.put("place_info", place);
					}
					String sql = "SELECT ID, Place, place_name \"Neighbourhoods\" from place_list INNER JOIN (SELECT  place_list.id_place \"ID\", place_list.place_name as \"Place\", neighbourhoods.id_neighbourhood \"neighbourhoodsID\" FROM place_list INNER JOIN neighbourhoods ON place_list.id_place = neighbourhoods.id_place) n \n"
							+ "on place_list.id_place = n.neighbourhoodsID";
					SqlQuery query = db.createSqlQuery(sql);
					List<SqlRow> list = query.findList();
					List<Neighbourhood> neighbour = new ArrayList<>();
					neighbour = Utils.convertObjectList(list, Neighbourhood.class);
					List<String> neighbourList = new ArrayList<>();
					for (Neighbourhood value : neighbour) {
						if (place.id_place == value.getId()) {
							// place_map.put("values", value);
							neighbourList.add(value.getNeighbourhoods());
						}
					}
					place_map.put("Neighbourhood", neighbourList);
					place_obj.put(place.place_name, place_map);
				}
				dist_map.put("places", place_obj);
				final_out.put(district.district_name, dist_map);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return final_out;
	}

	public Map<String, Object> getDetails() {
		List<Map<String, Object>> final_obj = new ArrayList<Map<String, Object>>();
		Map<String, Object> final_out = new HashMap<>();
		List<District> distList = db.find(District.class).findList();
		try {
			for (District district : distList) {
				Map<String, Object> dist_map = new HashMap<>();
				dist_map.put("dist_info", district);

				List<Map<String, Object>> place_obj = new ArrayList<Map<String, Object>>();
				List<Places> placeList = db.find(Places.class).where().eq("id_dist", district.id_dist).findList();
				for (Places place : placeList) {
					Map<String, Object> place_map = new HashMap<>();
					if (district.id_dist == place.id_dist) {
						place_map.put("place_info", place);
					}
					List<PlaceValues> valueList = db.find(PlaceValues.class).findList();
					for (PlaceValues value : valueList) {
						if (place.id_place == value.id_place) {
							place_map.put("values", value);
						}
					}
					String sql = "SELECT ID, Place, place_name \"Neighbourhoods\" from place_list INNER JOIN (SELECT  place_list.id_place \"ID\", place_list.place_name as \"Place\", neighbourhoods.id_neighbourhood \"neighbourhoodsID\" FROM place_list INNER JOIN neighbourhoods ON place_list.id_place = neighbourhoods.id_place) n \n"
							+ "on place_list.id_place = n.neighbourhoodsID";
					SqlQuery query = db.createSqlQuery(sql);
					List<SqlRow> list = query.findList();
					List<Neighbourhood> neighbour = new ArrayList<>();
					neighbour = Utils.convertObjectList(list, Neighbourhood.class);
					List<String> neighbourList = new ArrayList<>();
					for (Neighbourhood value : neighbour) {
						if (place.id_place == value.getId()) {
							// place_map.put("values", value);
							neighbourList.add(value.getNeighbourhoods());
						}
					}
					place_map.put("Neighbourhood", neighbourList);
					place_obj.add(place_map);
				}
				dist_map.put("places", place_obj);
				final_obj.add(dist_map);

			}
			final_out.put("District", final_obj);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return final_out;
	}

	public Map<String, Object> getStateValue() {
		List<Map<String, Object>> state_obj = new ArrayList<Map<String, Object>>();
		Map<String, Object> state_out = new HashMap<>();
		List<StateValue> stateList = db.find(StateValue.class).findList();
		try {
			for (StateValue state : stateList) {
				Map<String, Object> state_map = new HashMap<>();
				state_map.put("state_info", state);

				List<Map<String, Object>> final_obj = new ArrayList<Map<String, Object>>();
				// Map<String, Object> final_out = new HashMap<>();
				List<District> distList = db.find(District.class).where().eq("id_state", state.id_state).findList();

				for (District district : distList) {
					Map<String, Object> dist_map = new HashMap<>();
					dist_map.put("dist_info", district);

					List<Map<String, Object>> place_obj = new ArrayList<Map<String, Object>>();
					List<Places> placeList = db.find(Places.class).where().eq("id_dist", district.id_dist).findList();
					for (Places place : placeList) {
						Map<String, Object> place_map = new HashMap<>();
						if (district.id_dist.equals(place.id_dist)) {
							place_map.put("place_info", place);
						}
						List<PlaceValues> valueList = db.find(PlaceValues.class).findList();
						for (PlaceValues value : valueList) {
							if (place.id_place.equals(value.id_place)) {
								place_map.put("values", value);
							}
						}
						String sql = "SELECT ID, Place, place_name \"Neighbourhoods\" from place_list INNER JOIN (SELECT  place_list.id_place \"ID\", place_list.place_name as \"Place\", neighbourhoods.id_neighbourhood \"neighbourhoodsID\" FROM place_list INNER JOIN neighbourhoods ON place_list.id_place = neighbourhoods.id_place) n \n"
								+ "on place_list.id_place = n.neighbourhoodsID";
						SqlQuery query = db.createSqlQuery(sql);
						List<SqlRow> list = query.findList();
						List<Neighbourhood> neighbour = new ArrayList<>();
						neighbour = Utils.convertObjectList(list, Neighbourhood.class);
						List<String> neighbourList = new ArrayList<>();
						for (Neighbourhood value : neighbour) {
							if (place.id_place.equals(value.getId())) {
								// place_map.put("values", value);
								neighbourList.add(value.getNeighbourhoods());
							}
						}
						place_map.put("Neighbourhood", neighbourList);
						place_obj.add(place_map);
					}
					dist_map.put("places", place_obj);
					final_obj.add(dist_map);
				}
				state_map.put("district", final_obj);
				state_obj.add(state_map);
			}
			state_out.put("State", state_obj);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return state_out;
	}

}
