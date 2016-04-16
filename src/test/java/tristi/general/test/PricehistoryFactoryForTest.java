package tristi.general.test;

import tristi.general.bean.Pricehistory;

public class PricehistoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Pricehistory newPricehistory() {

		String pricehistoryid = mockValues.nextString(255);

		Pricehistory pricehistory = new Pricehistory();
		pricehistory.setPricehistoryid(pricehistoryid);
		return pricehistory;
	}
	
}
