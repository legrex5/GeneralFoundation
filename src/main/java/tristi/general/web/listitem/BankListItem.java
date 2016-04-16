/*
 * Created on 6 Dec 2015
 */
package tristi.general.web.listitem;


import tristi.general.bean.Bank;
import tristi.general.web.ListItem;

public class BankListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public BankListItem(Bank bank) {
		super();

		this.value = ""
			 + bank.getBankid()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = bank.toString();
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
