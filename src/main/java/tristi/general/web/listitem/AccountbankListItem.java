/*
 * Created on 6 Dec 2015 
 */
package tristi.general.web.listitem;

import tristi.general.bean.Accountbank;
import tristi.general.web.ListItem;

public class AccountbankListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public AccountbankListItem(Accountbank accountbank) {
		super();

		this.value = ""
			 + accountbank.getAccountbankid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = accountbank.toString();
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
