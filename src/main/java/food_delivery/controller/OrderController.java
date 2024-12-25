package food_delivery.controller;

import food_delivery.mapper.OrderMapper;
import food_delivery.model.Order;
import food_delivery.request.OrderRequest;
import food_delivery.service.OrderService;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
@RestController
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<?> createOrder(
            @RequestBody OrderRequest orderRequest)
    {
        Order order = orderService.createOrder(orderRequest.getCustomerId(), orderRequest.getAddressId());
        return ResponseEntity.ok(OrderMapper.toDto(order));
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrderHistoryForCustomer(@PathVariable Long customerId) {
        List<Order> orders = orderService.getOrderHistoryForCustomer(customerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Order>> getOrderHistoryForRestaurant(@PathVariable Long restaurantId) {
        List<Order> orders = orderService.getOrderHistoryForRestaurant(restaurantId);
        return ResponseEntity.ok(orders);
    }
    
    @PutMapping("/complete/{orderId}")
    public ResponseEntity<?> comleteOrder(@NotNull @PathVariable(name="orderId", required= true) Long orderId)
    {
    	 Order order = orderService.comleteOrder(orderId);
        return ResponseEntity.ok(OrderMapper.toDto(order));
    }
	
}
