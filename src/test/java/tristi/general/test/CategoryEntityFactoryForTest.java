package tristi.general.test;

import java.util.UUID;
import tristi.general.bean.jpa.CategoryEntity;

public class CategoryEntityFactoryForTest {

	public CategoryEntity newCategoryEntity() {

		UUID categoryid = UUID.randomUUID();

		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryid(categoryid);
		return categoryEntity;
	}
	
}
