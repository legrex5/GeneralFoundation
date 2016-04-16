/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Type;
import tristi.general.web.ListItem;

public class TypeListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public TypeListItem(Type type) {
		super();

		this.value = ""
			 + type.getTypeid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = type.toString();
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
