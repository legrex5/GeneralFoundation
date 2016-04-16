package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.ProductEntity;

/**
 * Repository : Product.
 */
public interface ProductJpaRepository extends PagingAndSortingRepository<ProductEntity, String> {

}
