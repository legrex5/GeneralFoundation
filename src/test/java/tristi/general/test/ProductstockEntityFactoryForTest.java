package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.ProductstockEntity;

public class ProductstockEntityFactoryForTest {
	
	public ProductstockEntity newProductstockEntity() {

		UUID productstockid = UUID.randomUUID();

		ProductstockEntity productstockEntity = new ProductstockEntity();
		productstockEntity.setProductstockid(productstockid);
		return productstockEntity;
	}
	
}
