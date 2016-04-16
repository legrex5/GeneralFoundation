package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.LocationEntity;

public class LocationEntityFactoryForTest {

	public LocationEntity newLocationEntity() {

		UUID locationid = UUID.randomUUID();

		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setLocationid(locationid);
		return locationEntity;
	}
	
}
