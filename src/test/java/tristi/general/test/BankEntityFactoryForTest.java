package tristi.general.test;

import java.util.UUID;
import tristi.general.bean.jpa.BankEntity;

public class BankEntityFactoryForTest {

	public BankEntity newBankEntity() {

		UUID bankid = UUID.randomUUID();

		BankEntity bankEntity = new BankEntity();
		bankEntity.setBankid(bankid);
		return bankEntity;
	}
	
}
