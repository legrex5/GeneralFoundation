package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.ProductuomEntity;

public class ProductuomEntityFactoryForTest {
	
	public ProductuomEntity newProductuomEntity() {

		UUID productuomid = UUID.randomUUID();

		ProductuomEntity productuomEntity = new ProductuomEntity();
		productuomEntity.setProductuomid(productuomid);
		return productuomEntity;
	}
	
}
