/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Salesorder;
import tristi.general.web.ListItem;

public class SalesorderListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public SalesorderListItem(Salesorder salesorder) {
		super();

		this.value = ""
			 + salesorder.getSalesorderid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = salesorder.toString();
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
