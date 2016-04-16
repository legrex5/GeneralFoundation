package tristi.general.test;

import tristi.general.bean.Purchaseorderdtl;

public class PurchaseorderdtlFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Purchaseorderdtl newPurchaseorderdtl() {

		String purchaseorderdtlid = mockValues.nextString(255);

		Purchaseorderdtl purchaseorderdtl = new Purchaseorderdtl();
		purchaseorderdtl.setPurchaseorderdtlid(purchaseorderdtlid);
		return purchaseorderdtl;
	}
	
}
