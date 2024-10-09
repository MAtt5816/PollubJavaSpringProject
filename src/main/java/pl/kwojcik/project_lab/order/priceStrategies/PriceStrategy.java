package pl.kwojcik.project_lab.order.priceStrategies;

import pl.kwojcik.project_lab.order.model.OrderPositionEntity;

import java.math.BigDecimal;
import java.util.Iterator;

// #Zadanie_2__8 Strategy
//start L2 Strategy
public abstract class PriceStrategy {
    public abstract BigDecimal calculatePrice(Iterator<OrderPositionEntity> orderPostionIterator);
}
