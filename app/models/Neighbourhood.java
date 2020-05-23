package models;

import javax.persistence.Id;

import play.db.ebean.Model;

public class Neighbourhood extends Model {

	private static final long serialVersionUID = 1L;
	@Id
	public Long id;

	public String place;

	public String neighbourhoods;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNeighbourhoods() {
		return neighbourhoods;
	}

	public void setNeighbourhoods(String neighbourhoods) {
		this.neighbourhoods = neighbourhoods;
	}

}
