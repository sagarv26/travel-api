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
import models.Places;
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

}