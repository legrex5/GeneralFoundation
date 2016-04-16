/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;


import tristi.general.bean.Detailexpired;
import tristi.general.web.ListItem;

public class DetailexpiredListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public DetailexpiredListItem(Detailexpired detailexpired) {
		super();

		this.value = ""
			 + detailexpired.getDetailexpiredid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = detailexpired.toString();
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
