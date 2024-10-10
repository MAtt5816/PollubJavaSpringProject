package pl.kwojcik.project_lab.order.orderStates;

import pl.kwojcik.project_lab.order.model.OrderEntity;

// #Zadanie_2__7 State
//start L2 State
// #Zadanie_3__2
//start L3 Odwracania zależności
public abstract class OrderState {
    OrderEntity order;

    public OrderState(OrderEntity order) {
        this.order = order;
    }

    public abstract void onComplete();
    public abstract void onCancel();
}
