package services;

import java.util.List;

import models.District;

public interface DistrictService {

	List<District> getAllDistrict();

	List<District> getAllDistrictsOrder();

	District getDistrictByName(String name);

	District getDistrictById(Long id);

}
