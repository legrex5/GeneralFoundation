package tristi.general.test;

import tristi.general.bean.Uom;

public class UomFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Uom newUom() {

		String uomid = mockValues.nextString(255);

		Uom uom = new Uom();
		uom.setUomid(uomid);
		return uom;
	}
	
}
