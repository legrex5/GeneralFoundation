package tristi.general.data.repository.jpa;

import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import tristi.general.bean.jpa.CategoryEntity;

/**
 * Repository : Category.
 */
public interface CategoryJpaRepository extends PagingAndSortingRepository<CategoryEntity, UUID> {

}
