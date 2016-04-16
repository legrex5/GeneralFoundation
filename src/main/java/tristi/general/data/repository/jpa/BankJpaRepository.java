package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.BankEntity;

/**
 * Repository : Bank.
 */
public interface BankJpaRepository extends PagingAndSortingRepository<BankEntity, String> {

}
