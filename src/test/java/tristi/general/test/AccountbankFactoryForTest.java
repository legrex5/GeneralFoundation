package tristi.general.test;

import tristi.general.bean.Accountbank;

public class AccountbankFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Accountbank newAccountbank() {

		String accountbankid = mockValues.nextString(255);

		Accountbank accountbank = new Accountbank();
		accountbank.setAccountbankid(accountbankid);
		return accountbank;
	}
	
}
