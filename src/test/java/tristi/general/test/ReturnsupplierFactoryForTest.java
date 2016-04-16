package tristi.general.test;

import tristi.general.bean.Returnsupplier;

public class ReturnsupplierFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Returnsupplier newReturnsupplier() {

		String returnsupplierid = mockValues.nextString(255);

		Returnsupplier returnsupplier = new Returnsupplier();
		returnsupplier.setReturnsupplierid(returnsupplierid);
		return returnsupplier;
	}
	
}
