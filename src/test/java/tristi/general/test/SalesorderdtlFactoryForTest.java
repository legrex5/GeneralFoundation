package tristi.general.test;

import tristi.general.bean.Salesorderdtl;

public class SalesorderdtlFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Salesorderdtl newSalesorderdtl() {

		String salesorderdtlid = mockValues.nextString(255);

		Salesorderdtl salesorderdtl = new Salesorderdtl();
		salesorderdtl.setSalesorderdtlid(salesorderdtlid);
		return salesorderdtl;
	}
	
}
