/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Productstock;
import tristi.general.web.ListItem;

public class ProductstockListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ProductstockListItem(Productstock productstock) {
		super();

		this.value = ""
			 + productstock.getProductstockid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = productstock.toString();
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
