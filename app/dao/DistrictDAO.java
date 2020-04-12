package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.google.inject.Inject;

import models.District;
import utils.Utils;

public class DistrictDAO extends BaseDao {

	@Inject
	public DistrictDAO() {
		super();
	}

	public List<District> getAllDistrict() {
		List<District> districtList = new ArrayList<>();

		try {
//			districtList = db.find(District.class).findList();

			String sql = "select * from district";
			SqlQuery query = db.createSqlQuery(sql);
			List<SqlRow> distList = query.findList();
			districtList = Utils.convertObjectList(distList, District.class);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return districtList;
	}

	public List<District> getAllDistrictsOrder() {

		List<District> districtList = db.find(District.class).findList();
		Collections.sort(districtList, new DistrictComparator());
		return districtList;
	}
}
