package pl.kwojcik.project_lab.order.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.kwojcik.project_lab.user.model.UserEntity;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime creationDate = OffsetDateTime.now();
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderPositionEntity> orderPositions;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private UserEntity customer;

    public OrderEntity(Set<OrderPositionEntity> orderPositions, UserEntity customer) {
        this.orderPositions = orderPositions;
        this.customer = customer;
    }
}
