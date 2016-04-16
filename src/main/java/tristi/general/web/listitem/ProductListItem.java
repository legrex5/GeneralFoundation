/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Product;
import tristi.general.web.ListItem;

public class ProductListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ProductListItem(Product product) {
		super();

		this.value = ""
			 + product.getProductid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = product.toString();
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
