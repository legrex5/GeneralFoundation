package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.ProductstockEntity;

/**
 * Repository : Productstock.
 */
public interface ProductstockJpaRepository extends PagingAndSortingRepository<ProductstockEntity, String> {

}
