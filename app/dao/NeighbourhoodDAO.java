package dao;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.google.inject.Inject;

import models.Neighbourhood;
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
			System.out.println(list);
			placeList = Utils.convertObjectList(list, Neighbourhood.class);
			System.out.println(placeList);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return placeList;
	}

}
