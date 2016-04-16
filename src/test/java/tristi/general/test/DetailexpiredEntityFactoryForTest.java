package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.DetailexpiredEntity;

public class DetailexpiredEntityFactoryForTest {

	public DetailexpiredEntity newDetailexpiredEntity() {

		UUID detailexpiredid = UUID.randomUUID();

		DetailexpiredEntity detailexpiredEntity = new DetailexpiredEntity();
		detailexpiredEntity.setDetailexpiredid(detailexpiredid);
		return detailexpiredEntity;
	}
	
}
