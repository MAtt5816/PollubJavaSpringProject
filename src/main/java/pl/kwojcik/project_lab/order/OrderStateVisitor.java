package pl.kwojcik.project_lab.order;

import pl.kwojcik.project_lab.order.orderStates.CanceledOrderState;
import pl.kwojcik.project_lab.order.orderStates.CompleteOrderState;
import pl.kwojcik.project_lab.order.orderStates.InProcessOrderState;
import pl.kwojcik.project_lab.order.orderStates.OrderState;
import pl.kwojcik.project_lab.order.priceStrategies.CalculatePrice;
import pl.kwojcik.project_lab.order.priceStrategies.InfoAboutCancellation;
import pl.kwojcik.project_lab.order.priceStrategies.PriceStrategy;

// #Zadanie_2__10 Visitor
//start L2 Visitor
public class OrderStateVisitor implements Visitor {
    public PriceStrategy getProperStrategy(OrderState state) {
        if (state instanceof CanceledOrderState) {
            return visitCancelledState();
        } else if (state instanceof CompleteOrderState) {
            return visitCompletedState();
        }
        else {
            return visitInProcessState();
        }
    }

    @Override
    public PriceStrategy visitCancelledState() {
        return new InfoAboutCancellation();
    }

    @Override
    public PriceStrategy visitCompletedState() {
        return new CalculatePrice();
    }

    @Override
    public PriceStrategy visitInProcessState() {
        return new CalculatePrice();
    }
}
