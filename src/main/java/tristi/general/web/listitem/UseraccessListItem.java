/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Useraccess;
import tristi.general.web.ListItem;

public class UseraccessListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public UseraccessListItem(Useraccess useraccess) {
		super();

		this.value = ""
			 + useraccess.getUserid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = useraccess.toString();
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
