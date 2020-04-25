package models;

import play.db.ebean.Model;

public class Neighbourhood extends Model {

	private static final long serialVersionUID = 1L;

	public Long id_place;

	public String place_name;

	public String neighbourhood;

}
