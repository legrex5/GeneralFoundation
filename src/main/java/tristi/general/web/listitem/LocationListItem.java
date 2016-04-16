/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Location;
import tristi.general.web.ListItem;

public class LocationListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public LocationListItem(Location location) {
		super();

		this.value = ""
			 + location.getLocationid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = location.toString();
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
