package pl.kwojcik.project_lab.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kwojcik.project_lab.products.dao.ProductEntityMemento;
import pl.kwojcik.project_lab.utils.Cacheable;
import pl.kwojcik.project_lab.utils.Memento;
import pl.kwojcik.project_lab.utils.PriceCalculable;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// #Zadanie__1_4 Prototype (inteface Clonable)
//start L1 Prototype
public class ProductEntity implements Cloneable, PriceCalculable, Cacheable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;

    public ProductEntity(Long id) {
        this.id = id;
    }

    @Override
    public ProductEntity clone() {
       return new ProductEntity(id, name, price, description);
    }

    @Override
    public BigDecimal calculatePrice() {
        return price;
    }

    @Override
    public Memento cache() {
        return new ProductEntityMemento(this.clone());
    }

    @Override
    public void restore(Memento memento) {
        var productEntity = ((ProductEntityMemento) memento).state;
        this.id = productEntity.getId();
        this.name = productEntity.getName();
        this.price = productEntity.getPrice();
        this.description = productEntity.getDescription();
    }
}
