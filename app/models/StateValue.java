package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import play.db.ebean.Model;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "state")
public class StateValue extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_state")
	public Long id_state;

	@Column(name = "state_name")
	public String state_name;

	@Column(name = "state_info")
	public String state_info;

	@Column(name = "state_image")
	public String state_image;

	@Column(name = "dist_map")
	public String dist_map;

	@Column(name = "official_info")
	public String official_info;

	@Column(name = "state_slogan")
	public String state_slogan;

	@Column(name = "state_dance")
	public String state_dance;

	@Column(name = "state_dance_icon")
	public String state_dance_icon;

	@Column(name = "state_food")
	public String state_food;

	@Column(name = "state_food_icon")
	public String state_food_icon;

	public StateValue(SqlRow district) {
		this.id_state = district.getLong("id_state");
		this.state_name = district.getString("state_name");
		this.state_info = district.getString("state_info");
		this.state_image = district.getString("state_image");
		this.dist_map = district.getString("dist_map");
		this.official_info = district.getString("official_info");
		this.state_slogan = district.getString("state_slogan");
		this.state_dance = district.getString("state_dance");
		this.state_dance_icon = district.getString("state_dance_icon");
		this.state_food = district.getString("state_food");
		this.state_food_icon = district.getString("state_food_icon");
	}

}