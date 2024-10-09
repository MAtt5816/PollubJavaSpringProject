package pl.kwojcik.project_lab.order.orderStates;

import pl.kwojcik.project_lab.order.model.OrderEntity;

public class CompleteOrderState extends OrderState {
    public CompleteOrderState(OrderEntity order) {
        super(order);
    }

    @Override
    public void onComplete() {
        System.out.println("Order is completed.");
    }

    @Override
    public void onCancel() {
        System.out.println("Cannot cancel order. Order is completed.");
    }
}
