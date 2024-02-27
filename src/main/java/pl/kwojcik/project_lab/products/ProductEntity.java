package pl.kwojcik.project_lab.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;

    public ProductEntity(Long id) {
        this.id = id;
    }
}
