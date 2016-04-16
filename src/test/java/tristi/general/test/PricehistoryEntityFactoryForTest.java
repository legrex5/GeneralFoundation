package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.PricehistoryEntity;

public class PricehistoryEntityFactoryForTest {
	
	public PricehistoryEntity newPricehistoryEntity() {

		UUID pricehistoryid = UUID.randomUUID();

		PricehistoryEntity pricehistoryEntity = new PricehistoryEntity();
		pricehistoryEntity.setPricehistoryid(pricehistoryid);
		return pricehistoryEntity;
	}
	
}
