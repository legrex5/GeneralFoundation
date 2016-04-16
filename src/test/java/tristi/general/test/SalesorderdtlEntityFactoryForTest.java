package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.SalesorderdtlEntity;

public class SalesorderdtlEntityFactoryForTest {
	
	public SalesorderdtlEntity newSalesorderdtlEntity() {

		UUID salesorderdtlid = UUID.randomUUID();

		SalesorderdtlEntity salesorderdtlEntity = new SalesorderdtlEntity();
		salesorderdtlEntity.setSalesorderdtlid(salesorderdtlid);
		return salesorderdtlEntity;
	}
	
}
