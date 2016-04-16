package tristi.general.test;

import tristi.general.bean.Purchaseorder;

public class PurchaseorderFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Purchaseorder newPurchaseorder() {

		String purchaseorderid = mockValues.nextString(255);

		Purchaseorder purchaseorder = new Purchaseorder();
		purchaseorder.setPurchaseorderid(purchaseorderid);
		return purchaseorder;
	}
	
}
