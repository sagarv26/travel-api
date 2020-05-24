package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.SqlRow;

import play.db.ebean.Model;

@Entity
@Table(name = "place_info")
public class PlaceValues extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_place")
	public Long id_place;

	@Column(name = "best_season")
	public String best_season;

	@Column(name = "place_image")
	public String place_image;

	@Column(name = "place_info")
	public String place_info;

	public PlaceValues(SqlRow placeInfo) {
		this.id_place = placeInfo.getLong("id_place");
		this.best_season = placeInfo.getString("best_season");
		this.place_info = placeInfo.getString("place_info");
		this.place_image = placeInfo.getString("place_image");
	}
}