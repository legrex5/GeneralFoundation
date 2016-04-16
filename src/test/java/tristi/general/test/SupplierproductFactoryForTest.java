package tristi.general.test;

import tristi.general.bean.Supplierproduct;

public class SupplierproductFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Supplierproduct newSupplierproduct() {

		String supplierproductid = mockValues.nextString(255);

		Supplierproduct supplierproduct = new Supplierproduct();
		supplierproduct.setSupplierproductid(supplierproductid);
		return supplierproduct;
	}
	
}
