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

	@Column(name = "place_desc")
	public String place_desc;

	@Column(name = "timings")
	public String timings;

	@Column(name = "location")
	public String location;

	@Column(name = "insta_link")
	public String insta_link;

	@Column(name = "place_type")
	public String place_type;

	@Column(name = "trending")
	public String trending;

	@Column(name = "time_required")
	public String time_required;

	public PlaceValues(SqlRow placeInfo) {
		this.id_place = placeInfo.getLong("id_place");
		this.best_season = placeInfo.getString("best_season");
		this.place_desc = placeInfo.getString("place_desc");
		this.place_image = placeInfo.getString("place_image");
		this.timings = placeInfo.getString("timings");
		this.location = placeInfo.getString("location");
		this.insta_link = placeInfo.getString("insta_link");
		this.place_type = placeInfo.getString("place_type");
		this.trending = placeInfo.getString("trending");
		this.time_required = placeInfo.getString("time_required");
	}
}