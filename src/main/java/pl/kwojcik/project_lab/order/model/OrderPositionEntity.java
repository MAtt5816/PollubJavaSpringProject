package pl.kwojcik.project_lab.order.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kwojcik.project_lab.products.ProductEntity;
import pl.kwojcik.project_lab.utils.PriceCalculable;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class OrderPositionEntity implements PriceCalculable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int productAmount;
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private ProductEntity product;
    @ManyToOne(fetch = FetchType.EAGER)
    private OrderEntity order;

    public OrderPositionEntity(int productAmount, ProductEntity product, OrderEntity order) {
        this.productAmount = productAmount;
        this.product = product;
        this.order = order;
    }

    @Override
    public BigDecimal calculatePrice() {
        return product.calculatePrice().multiply(BigDecimal.valueOf(productAmount));
    }
}
