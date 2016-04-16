/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Pricehistory;
import tristi.general.web.ListItem;

public class PricehistoryListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public PricehistoryListItem(Pricehistory pricehistory) {
		super();

		this.value = ""
			 + pricehistory.getPricehistoryid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = pricehistory.toString();
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
