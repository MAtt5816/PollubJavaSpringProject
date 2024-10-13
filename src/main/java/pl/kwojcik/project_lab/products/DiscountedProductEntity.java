package pl.kwojcik.project_lab.products;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

// #Zadanie_3__1
//start L3 Podstawienia Liskov w 3 klasach
// #Zadanie_3__4
//start L3 znaczących (jasnych i zrozumiałych) nazw do klas, metod i zmiennych, znaczących w całym programie to samo
@Entity
public class DiscountedProductEntity extends ProductEntity {
//    public void setDiscountPercent(BigDecimal param1) {
    public void setDiscountPercent(BigDecimal percentDiscount) {
        var price = super.getPrice();
        var discountedPrice = price.multiply(percentDiscount).divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
        super.setPrice(discountedPrice);
    }
}
