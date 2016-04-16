package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.SupplierEntity;

/**
 * Repository : Supplier.
 */
public interface SupplierJpaRepository extends PagingAndSortingRepository<SupplierEntity, String> {

}
