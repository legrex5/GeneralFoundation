package tristi.general.test;

import tristi.general.bean.Type;

public class TypeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Type newType() {

		String typeid = mockValues.nextString(255);

		Type type = new Type();
		type.setTypeid(typeid);
		return type;
	}
	
}
