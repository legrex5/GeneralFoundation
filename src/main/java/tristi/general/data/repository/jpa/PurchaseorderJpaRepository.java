package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.PurchaseorderEntity;

/**
 * Repository : Purchaseorder.
 */
public interface PurchaseorderJpaRepository extends PagingAndSortingRepository<PurchaseorderEntity, String> {

}
