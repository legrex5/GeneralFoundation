package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.SupplierEntity;

public class SupplierEntityFactoryForTest {
	
	public SupplierEntity newSupplierEntity() {

		UUID supplierid = UUID.randomUUID();

		SupplierEntity supplierEntity = new SupplierEntity();
		supplierEntity.setSupplierid(supplierid);
		return supplierEntity;
	}
	
}
