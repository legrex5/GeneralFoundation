package tristi.general.test;

import tristi.general.bean.Locationdtl;

public class LocationdtlFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Locationdtl newLocationdtl() {

		String locationdtlid = mockValues.nextString(255);

		Locationdtl locationdtl = new Locationdtl();
		locationdtl.setLocationdtlid(locationdtlid);
		return locationdtl;
	}
	
}
