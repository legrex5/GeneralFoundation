package tristi.general.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.PaymentformEntity;

/**
 * Repository : Paymentform.
 */
public interface PaymentformJpaRepository extends PagingAndSortingRepository<PaymentformEntity, String> {

}
