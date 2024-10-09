package pl.kwojcik.project_lab.order.orderStates;

import pl.kwojcik.project_lab.order.model.OrderEntity;

public class InProcessOrderState extends OrderState {
    public InProcessOrderState(OrderEntity order) {
        super(order);
    }

    @Override
    public void onComplete() {
        var newState = new CompleteOrderState(order);
        super.order.changeState(newState);
    }

    @Override
    public void onCancel() {
        var newState = new CanceledOrderState(order);
        super.order.changeState(newState);
    }
}
