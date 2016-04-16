package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.AccountbankEntity;

/**
 * Repository : Accountbank.
 */
public interface AccountbankJpaRepository extends PagingAndSortingRepository<AccountbankEntity, String> {

}
