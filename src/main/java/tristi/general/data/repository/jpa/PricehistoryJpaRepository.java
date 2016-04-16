package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.PricehistoryEntity;

/**
 * Repository : Pricehistory.
 */
public interface PricehistoryJpaRepository extends PagingAndSortingRepository<PricehistoryEntity, String> {

}
