/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Productuom;
import tristi.general.web.ListItem;

public class ProductuomListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ProductuomListItem(Productuom productuom) {
		super();

		this.value = ""
			 + productuom.getProductuomid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = productuom.toString();
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
