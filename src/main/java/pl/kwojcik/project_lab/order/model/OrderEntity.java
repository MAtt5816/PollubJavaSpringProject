package pl.kwojcik.project_lab.order.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.kwojcik.project_lab.order.OrderStateVisitor;
import pl.kwojcik.project_lab.order.orderStates.InProcessOrderState;
import pl.kwojcik.project_lab.order.orderStates.OrderState;
import pl.kwojcik.project_lab.order.priceStrategies.PriceStrategy;
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

    @Transient
    private OrderState state;
    @Transient
    private PriceStrategy priceStrategy;

    public OrderEntity(Set<OrderPositionEntity> orderPositions, UserEntity customer) {
        this.orderPositions = orderPositions;
        this.customer = customer;
        this.state = new InProcessOrderState(this);
    }

    public void changeState(OrderState state) {
        this.state = state;
    }

    public void OnComplete() {
        this.state.onComplete();
    }

    public void OnCancel() {
        this.state.onCancel();
    }

    @Override
    public BigDecimal calculatePrice() {
        this.CheckStrategy();
        return priceStrategy.calculatePrice(orderPositions.iterator());
    }

    private void CheckStrategy() {
        var visitor = new OrderStateVisitor();
        this.priceStrategy = visitor.getProperStrategy(this.state);
    }
}
