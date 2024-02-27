package pl.kwojcik.project_lab.order.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;
import pl.kwojcik.project_lab.gen.api.OrdersApi;
import pl.kwojcik.project_lab.gen.api.dto.NewOrderDTO;
import pl.kwojcik.project_lab.gen.api.dto.OrderDTO;
import pl.kwojcik.project_lab.order.OrderService;

import java.util.List;

@RestController
public class OrderApiController implements OrdersApi {
    private final OrderService orderService;

    public OrderApiController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @PreAuthorize("#authentication.authenticated")
    public ResponseEntity<OrderDTO> createOrder(NewOrderDTO newOrderDTO) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var createdOrder = orderService.createOrder(newOrderDTO, auth);
        return ResponseEntity.ok(createdOrder);
    }

    @Override
    @PreAuthorize("#authentication.authenticated")
    public ResponseEntity<Void> deleteOrder(Long orderId) {
        this.orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("#authentication.authenticated")
    public ResponseEntity<List<OrderDTO>> getOrders(Long pageIndex, Long pageSize) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            throw new UsernameNotFoundException("");
        }
        var orders = this.orderService.getClientOrders(auth);
        return ResponseEntity.ok(orders);
    }
}
