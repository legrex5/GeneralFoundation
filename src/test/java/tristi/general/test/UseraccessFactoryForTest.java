package tristi.general.test;

import tristi.general.bean.Useraccess;

public class UseraccessFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Useraccess newUseraccess() {

		String userid = mockValues.nextString(255);

		Useraccess useraccess = new Useraccess();
		useraccess.setUserid(userid);
		return useraccess;
	}
	
}
