package tristi.general.test;

import tristi.general.bean.Productuom;

public class ProductuomFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Productuom newProductuom() {

		String productuomid = mockValues.nextString(255);

		Productuom productuom = new Productuom();
		productuom.setProductuomid(productuomid);
		return productuom;
	}
	
}
