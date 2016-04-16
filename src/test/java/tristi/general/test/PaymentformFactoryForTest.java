package tristi.general.test;

import tristi.general.bean.Paymentform;

public class PaymentformFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Paymentform newPaymentform() {

		String paymentformid = mockValues.nextString(255);

		Paymentform paymentform = new Paymentform();
		paymentform.setPaymentformid(paymentformid);
		return paymentform;
	}
	
}
