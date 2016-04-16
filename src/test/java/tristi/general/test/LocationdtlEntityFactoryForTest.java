package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.LocationdtlEntity;

public class LocationdtlEntityFactoryForTest {

	public LocationdtlEntity newLocationdtlEntity() {

		UUID locationdtlid = UUID.randomUUID();

		LocationdtlEntity locationdtlEntity = new LocationdtlEntity();
		locationdtlEntity.setLocationdtlid(locationdtlid);
		return locationdtlEntity;
	}
	
}
