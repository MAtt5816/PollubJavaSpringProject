package pl.kwojcik.project_lab.order.orderStates;

import pl.kwojcik.project_lab.order.model.OrderEntity;

public class CanceledOrderState extends OrderState {
    public CanceledOrderState(OrderEntity order) {
        super(order);
    }

    @Override
    public void onComplete() {
        System.out.println("Cannot complete order. Order is canceled.");
    }

    @Override
    public void onCancel() {
        System.out.println("Order is canceled.");
    }
}
