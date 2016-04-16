package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.LocationEntity;

/**
 * Repository : Location.
 */
public interface LocationJpaRepository extends PagingAndSortingRepository<LocationEntity, String> {

}
