package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.TypeEntity;

/**
 * Repository : Type.
 */
public interface TypeJpaRepository extends PagingAndSortingRepository<TypeEntity, String> {

}
