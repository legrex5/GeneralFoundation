package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.SalesordercorrectionEntity;

public class SalesordercorrectionEntityFactoryForTest {
	
	public SalesordercorrectionEntity newSalesordercorrectionEntity() {

		UUID salesordercorrectionid = UUID.randomUUID();

		SalesordercorrectionEntity salesordercorrectionEntity = new SalesordercorrectionEntity();
		salesordercorrectionEntity.setSalesordercorrectionid(salesordercorrectionid);
		return salesordercorrectionEntity;
	}
	
}
