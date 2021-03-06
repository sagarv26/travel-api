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
@Table(name = "district")
public class District extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_dist")
	public Long id_dist;

	@Column(name = "district_name")
	public String district_name;

	@Column(name = "dist_info")
	public String dist_info;

	@Column(name = "dist_image")
	public String dist_image;

	@Column(name = "id_state")
	public Long id_state;

	public District(SqlRow district) {
		this.id_dist = district.getLong("id_dist");
		this.id_state = district.getLong("id_state");
		this.district_name = district.getString("district_name");
		this.dist_info = district.getString("dist_info");
		this.dist_image = district.getString("dist_image");
	}

}