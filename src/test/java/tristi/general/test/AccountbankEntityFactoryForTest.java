package tristi.general.test;

import java.util.UUID;
import tristi.general.bean.jpa.AccountbankEntity;

public class AccountbankEntityFactoryForTest {

	public AccountbankEntity newAccountbankEntity() {

		UUID accountbankid;
            accountbankid = UUID.randomUUID();

		AccountbankEntity accountbankEntity = new AccountbankEntity();
		accountbankEntity.setAccountbankid(accountbankid);
		return accountbankEntity;
	}
	
}
