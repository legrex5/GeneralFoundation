/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Uom;
import tristi.general.web.ListItem;

public class UomListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public UomListItem(Uom uom) {
		super();

		this.value = ""
			 + uom.getUomid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = uom.toString();
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
