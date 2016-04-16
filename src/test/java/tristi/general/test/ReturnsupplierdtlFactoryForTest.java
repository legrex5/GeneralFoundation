package tristi.general.test;

import tristi.general.bean.Returnsupplierdtl;

public class ReturnsupplierdtlFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Returnsupplierdtl newReturnsupplierdtl() {

		String returndtlid = mockValues.nextString(255);

		Returnsupplierdtl returnsupplierdtl = new Returnsupplierdtl();
		returnsupplierdtl.setReturndtlid(returndtlid);
		return returnsupplierdtl;
	}
	
}
