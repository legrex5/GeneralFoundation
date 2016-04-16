package tristi.general.test;

import tristi.general.bean.Salesorder;

public class SalesorderFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Salesorder newSalesorder() {

		String salesorderid = mockValues.nextString(255);

		Salesorder salesorder = new Salesorder();
		salesorder.setSalesorderid(salesorderid);
		return salesorder;
	}
	
}
