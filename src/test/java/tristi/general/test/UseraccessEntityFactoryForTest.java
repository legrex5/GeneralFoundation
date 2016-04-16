package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.UseraccessEntity;

public class UseraccessEntityFactoryForTest {
	
	public UseraccessEntity newUseraccessEntity() {

		UUID userid = UUID.randomUUID();

		UseraccessEntity useraccessEntity = new UseraccessEntity();
		useraccessEntity.setUserid(userid);
		return useraccessEntity;
	}
	
}
