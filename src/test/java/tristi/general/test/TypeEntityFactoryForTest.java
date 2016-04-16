package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.TypeEntity;

public class TypeEntityFactoryForTest {
	
	public TypeEntity newTypeEntity() {

		UUID typeid = UUID.randomUUID();

		TypeEntity typeEntity = new TypeEntity();
		typeEntity.setTypeid(typeid);
		return typeEntity;
	}
	
}
