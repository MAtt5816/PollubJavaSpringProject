package pl.kwojcik.project_lab.order.priceStrategies;

import pl.kwojcik.project_lab.order.model.OrderPositionEntity;

import java.math.BigDecimal;
import java.util.Iterator;

public class InfoAboutCancellation extends PriceStrategy {
    private String ORDER_CANCELED = "Order canceled";

    @Override
    public BigDecimal calculatePrice(Iterator<OrderPositionEntity> iterator) {
        System.out.println(ORDER_CANCELED);
        return BigDecimal.ZERO;
    }

    @Override
    public void setDiscount(Iterator<OrderPositionEntity> iterator, BigDecimal discountPercent) {
        System.out.println(ORDER_CANCELED);
    }
}
