/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Purchaseorder;
import tristi.general.web.ListItem;

public class PurchaseorderListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public PurchaseorderListItem(Purchaseorder purchaseorder) {
		super();

		this.value = ""
			 + purchaseorder.getPurchaseorderid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = purchaseorder.toString();
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
