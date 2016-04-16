package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.ProductuomEntity;

/**
 * Repository : Productuom.
 */
public interface ProductuomJpaRepository extends PagingAndSortingRepository<ProductuomEntity, String> {

}
