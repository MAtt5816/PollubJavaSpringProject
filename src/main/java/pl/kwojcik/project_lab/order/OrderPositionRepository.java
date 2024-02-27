package pl.kwojcik.project_lab.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwojcik.project_lab.order.model.OrderPositionEntity;

@Repository
public interface OrderPositionRepository extends JpaRepository<OrderPositionEntity, Long> {
}
