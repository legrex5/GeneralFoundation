package tristi.general.test;

import java.util.UUID;

import tristi.general.bean.jpa.ReturnsupplierdtlEntity;

public class ReturnsupplierdtlEntityFactoryForTest {
	
	public ReturnsupplierdtlEntity newReturnsupplierdtlEntity() {

		UUID returndtlid = UUID.randomUUID();

		ReturnsupplierdtlEntity returnsupplierdtlEntity = new ReturnsupplierdtlEntity();
		returnsupplierdtlEntity.setReturndtlid(returndtlid);
		return returnsupplierdtlEntity;
	}
	
}
