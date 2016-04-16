/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Salesordercorrection;
import tristi.general.web.ListItem;

public class SalesordercorrectionListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public SalesordercorrectionListItem(Salesordercorrection salesordercorrection) {
		super();

		this.value = ""
			 + salesordercorrection.getSalesordercorrectionid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = salesordercorrection.toString();
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
