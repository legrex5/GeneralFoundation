/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Supplierproduct;
import tristi.general.web.ListItem;

public class SupplierproductListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public SupplierproductListItem(Supplierproduct supplierproduct) {
		super();

		this.value = ""
			 + supplierproduct.getSupplierproductid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = supplierproduct.toString();
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
