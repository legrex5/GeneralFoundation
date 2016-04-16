/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.web.listitem;

import tristi.general.bean.Category;
import tristi.general.web.ListItem;

public class CategoryListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public CategoryListItem(Category category) {
		super();

		this.value = ""
			 + category.getCategoryid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = category.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
