package tristi.general.test;

import tristi.general.bean.Productstock;

public class ProductstockFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Productstock newProductstock() {

		String productstockid = mockValues.nextString(255);

		Productstock productstock = new Productstock();
		productstock.setProductstockid(productstockid);
		return productstock;
	}
	
}
