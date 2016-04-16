package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.UseraccessEntity;

/**
 * Repository : Useraccess.
 */
public interface UseraccessJpaRepository extends PagingAndSortingRepository<UseraccessEntity, String> {

}
