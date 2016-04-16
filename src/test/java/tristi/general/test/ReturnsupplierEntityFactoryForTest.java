package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.ReturnsupplierEntity;

public class ReturnsupplierEntityFactoryForTest {
	
	public ReturnsupplierEntity newReturnsupplierEntity() {

		UUID returnsupplierid = UUID.randomUUID();

		ReturnsupplierEntity returnsupplierEntity = new ReturnsupplierEntity();
		returnsupplierEntity.setReturnsupplierid(returnsupplierid);
		return returnsupplierEntity;
	}
	
}
