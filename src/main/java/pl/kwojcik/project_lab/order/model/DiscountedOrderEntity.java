package pl.kwojcik.project_lab.order.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

// #Zadanie_3__1
//start L3 Podstawienia Liskov w 3 klasach
@Entity
public class DiscountedOrderEntity extends OrderEntity {
    public void setDiscountPercent(BigDecimal percent) {
        var strategy = super.getPriceStrategy();
        strategy.setDiscount(super.getOrderPositions().iterator(), percent);
    }
}
