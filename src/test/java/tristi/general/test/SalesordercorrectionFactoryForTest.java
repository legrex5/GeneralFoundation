package tristi.general.test;

import tristi.general.bean.Salesordercorrection;

public class SalesordercorrectionFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Salesordercorrection newSalesordercorrection() {

		String salesordercorrectionid = mockValues.nextString(255);

		Salesordercorrection salesordercorrection = new Salesordercorrection();
		salesordercorrection.setSalesordercorrectionid(salesordercorrectionid);
		return salesordercorrection;
	}
	
}
