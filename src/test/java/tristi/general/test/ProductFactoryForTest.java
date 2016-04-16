package tristi.general.test;

import tristi.general.bean.Product;

public class ProductFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Product newProduct() {

		String productid = mockValues.nextString(255);

		Product product = new Product();
		product.setProductid(productid);
		return product;
	}
	
}
