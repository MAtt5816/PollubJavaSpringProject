package pl.kwojcik.project_lab.order;

import pl.kwojcik.project_lab.order.priceStrategies.PriceStrategy;

import java.math.BigDecimal;

public interface Visitor {
    PriceStrategy visitCancelledState();
    PriceStrategy visitCompletedState();
    PriceStrategy visitInProcessState();
}
