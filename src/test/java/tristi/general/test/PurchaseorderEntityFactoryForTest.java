package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.PurchaseorderEntity;

public class PurchaseorderEntityFactoryForTest {
	
	public PurchaseorderEntity newPurchaseorderEntity() {

		UUID purchaseorderid = UUID.randomUUID();

		PurchaseorderEntity purchaseorderEntity = new PurchaseorderEntity();
		purchaseorderEntity.setPurchaseorderid(purchaseorderid);
		return purchaseorderEntity;
	}
	
}
