package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.SupplierproductEntity;

public class SupplierproductEntityFactoryForTest {
	
	public SupplierproductEntity newSupplierproductEntity() {

		UUID supplierproductid = UUID.randomUUID();

		SupplierproductEntity supplierproductEntity = new SupplierproductEntity();
		supplierproductEntity.setSupplierproductid(supplierproductid);
		return supplierproductEntity;
	}
	
}
