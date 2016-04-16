package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.SalesorderEntity;

public class SalesorderEntityFactoryForTest {
	
	public SalesorderEntity newSalesorderEntity() {

		UUID salesorderid = UUID.randomUUID();

		SalesorderEntity salesorderEntity = new SalesorderEntity();
		salesorderEntity.setSalesorderid(salesorderid);
		return salesorderEntity;
	}
	
}
