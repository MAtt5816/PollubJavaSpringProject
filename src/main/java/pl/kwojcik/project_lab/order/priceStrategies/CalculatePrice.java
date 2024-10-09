package pl.kwojcik.project_lab.order.priceStrategies;

import pl.kwojcik.project_lab.order.model.OrderPositionEntity;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;

public class CalculatePrice extends PriceStrategy {

    // #Zadanie_2__3 Iterator (using Set iterator)
    //start L2 Iterator
    @Override
    public BigDecimal calculatePrice(Iterator<OrderPositionEntity> iterator) {
        var sum = BigDecimal.ZERO;

        do {
            var orderPosition = iterator.next();
            sum = sum.add(orderPosition.calculatePrice());
        } while (iterator.hasNext());

        return sum;
    }
}
