package pl.kwojcik.project_lab.order;

import pl.kwojcik.project_lab.order.model.OrderEntity;
import pl.kwojcik.project_lab.order.priceStrategies.PriceStrategy;

import java.util.List;


// #Zadanie_3__3
//start L3 Segregacja interfejsów

// !!! OrderInterface split to Visitor & OrderRepository interfaces

/*
public interface OrderInterface {
    //Visitor
    PriceStrategy visitCancelledState();
    PriceStrategy visitCompletedState();
    PriceStrategy visitInProcessState();
    //OrderRepository
    List<OrderEntity> findAllByCustomerId(Long id);
}
*/