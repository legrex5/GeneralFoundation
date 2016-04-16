package tristi.general.test;

import java.util.UUID;
import tristi.general.bean.Category;

public class CategoryFactoryForTest {

	public Category newCategory() {

		UUID categoryid = UUID.randomUUID();

		Category category = new Category();
		category.setCategoryid(categoryid.toString());
		return category;
	}
	
}
