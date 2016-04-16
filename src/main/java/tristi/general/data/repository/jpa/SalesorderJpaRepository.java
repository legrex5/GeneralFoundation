package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.SalesorderEntity;

/**
 * Repository : Salesorder.
 */
public interface SalesorderJpaRepository extends PagingAndSortingRepository<SalesorderEntity, String> {

}
