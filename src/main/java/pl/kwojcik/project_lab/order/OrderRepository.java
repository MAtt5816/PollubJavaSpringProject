package pl.kwojcik.project_lab.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwojcik.project_lab.order.model.OrderEntity;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

   List<OrderEntity> findAllByCustomerId(Long id);

}
