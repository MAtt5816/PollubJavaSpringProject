package pl.kwojcik.project_lab.order.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.kwojcik.project_lab.user.model.UserEntity;
import pl.kwojcik.project_lab.utils.PriceCalculable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
// #Zadanie_1__6 Composite (using interface PriceCalculable)
//start L1 Composite
public class OrderEntity implements PriceCalculable {

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

    @Override
    public BigDecimal calculatePrice() {
        var sum = BigDecimal.ZERO;
        for (var orderPosition : orderPositions) {
            sum = sum.add(orderPosition.calculatePrice());
        }
        return sum;
    }
}
