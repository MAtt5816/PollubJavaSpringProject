package pl.kwojcik.project_lab.products;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

// #Zadanie_3__1
//start L3 Podstawienia Liskov w 3 klasach
@Entity
public class DiscountedProductEntity extends ProductEntity {
    public void setDiscountPercent(BigDecimal percent) {
        var price = super.getPrice();
        var discountedPrice = price.multiply(percent).divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        super.setPrice(discountedPrice);
    }
}
