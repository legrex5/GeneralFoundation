package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.ProductEntity;

public class ProductEntityFactoryForTest {
	
	public ProductEntity newProductEntity() {

		UUID productid = UUID.randomUUID();

		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductid(productid);
		return productEntity;
	}
	
}
