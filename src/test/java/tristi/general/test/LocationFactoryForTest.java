package tristi.general.test;

import tristi.general.bean.Location;

public class LocationFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Location newLocation() {

		String locationid = mockValues.nextString(255);

		Location location = new Location();
		location.setLocationid(locationid);
		return location;
	}
	
}
