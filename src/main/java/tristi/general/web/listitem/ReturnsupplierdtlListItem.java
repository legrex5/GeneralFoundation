/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;

import tristi.general.bean.Returnsupplierdtl;
import tristi.general.web.ListItem;

public class ReturnsupplierdtlListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public ReturnsupplierdtlListItem(Returnsupplierdtl returnsupplierdtl) {
		super();

		this.value = ""
			 + returnsupplierdtl.getReturndtlid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = returnsupplierdtl.toString();
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
