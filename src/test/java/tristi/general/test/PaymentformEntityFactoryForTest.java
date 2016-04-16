package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.PaymentformEntity;

public class PaymentformEntityFactoryForTest {
	
	public PaymentformEntity newPaymentformEntity() {

		UUID paymentformid = UUID.randomUUID();

		PaymentformEntity paymentformEntity = new PaymentformEntity();
		paymentformEntity.setPaymentformid(paymentformid);
		return paymentformEntity;
	}
	
}
