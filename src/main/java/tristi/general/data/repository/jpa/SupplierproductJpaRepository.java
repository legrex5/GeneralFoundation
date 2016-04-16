package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.SupplierproductEntity;

/**
 * Repository : Supplierproduct.
 */
public interface SupplierproductJpaRepository extends PagingAndSortingRepository<SupplierproductEntity, String> {

}
