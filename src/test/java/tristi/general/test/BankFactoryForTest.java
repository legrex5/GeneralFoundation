package tristi.general.test;

import tristi.general.bean.Bank;

public class BankFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Bank newBank() {

		String bankid = mockValues.nextString(255);

		Bank bank = new Bank();
		bank.setBankid(bankid);
		return bank;
	}
	
}
