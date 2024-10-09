package pl.kwojcik.project_lab.order.priceStrategies;

import pl.kwojcik.project_lab.order.model.OrderPositionEntity;

import java.math.BigDecimal;
import java.util.Iterator;

public class InfoAboutCancellation extends PriceStrategy {
    @Override
    public BigDecimal calculatePrice(Iterator<OrderPositionEntity> iterator) {
        System.out.println("Order cancelled");
        return BigDecimal.ZERO;
    }
}
