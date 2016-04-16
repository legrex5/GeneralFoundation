package tristi.general.test;

import tristi.general.bean.Supplier;

public class SupplierFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Supplier newSupplier() {

		String supplierid = mockValues.nextString(255);

		Supplier supplier = new Supplier();
		supplier.setSupplierid(supplierid);
		return supplier;
	}
	
}
