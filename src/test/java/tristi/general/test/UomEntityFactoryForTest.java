package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.UomEntity;

public class UomEntityFactoryForTest {
	
	public UomEntity newUomEntity() {

		UUID uomid = UUID.randomUUID();

		UomEntity uomEntity = new UomEntity();
		uomEntity.setUomid(uomid);
		return uomEntity;
	}
	
}
