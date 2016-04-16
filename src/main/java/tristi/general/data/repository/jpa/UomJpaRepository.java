package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.UomEntity;

/**
 * Repository : Uom.
 */
public interface UomJpaRepository extends PagingAndSortingRepository<UomEntity, String> {

}
