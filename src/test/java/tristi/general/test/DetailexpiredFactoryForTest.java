package tristi.general.test;

import tristi.general.bean.Detailexpired;

public class DetailexpiredFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Detailexpired newDetailexpired() {

		String detailexpiredid = mockValues.nextString(255);

		Detailexpired detailexpired = new Detailexpired();
		detailexpired.setDetailexpiredid(detailexpiredid);
		return detailexpired;
	}
	
}
