/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Supplier;
import tristi.general.web.ListItem;

public class SupplierListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public SupplierListItem(Supplier supplier) {
		super();

		this.value = ""
			 + supplier.getSupplierid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = supplier.toString();
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
