/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Purchaseorderdtl;
import tristi.general.web.ListItem;

public class PurchaseorderdtlListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public PurchaseorderdtlListItem(Purchaseorderdtl purchaseorderdtl) {
		super();

		this.value = ""
			 + purchaseorderdtl.getPurchaseorderdtlid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = purchaseorderdtl.toString();
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
