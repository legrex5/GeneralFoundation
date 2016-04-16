package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.PurchaseorderdtlEntity;

public class PurchaseorderdtlEntityFactoryForTest {
	
	public PurchaseorderdtlEntity newPurchaseorderdtlEntity() {

		UUID purchaseorderdtlid = UUID.randomUUID();

		PurchaseorderdtlEntity purchaseorderdtlEntity = new PurchaseorderdtlEntity();
		purchaseorderdtlEntity.setPurchaseorderdtlid(purchaseorderdtlid);
		return purchaseorderdtlEntity;
	}
	
}
