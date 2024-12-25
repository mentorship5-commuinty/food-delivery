package food_delivery.controller;

import food_delivery.mapper.OrderMapper;
import food_delivery.model.Order;
import food_delivery.request.OrderRequest;
import food_delivery.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Cancel Order
    @PutMapping("cancel/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        boolean isCanceled = orderService.cancelOrder(orderId);
        if (isCanceled) {
            return ResponseEntity.ok("Order canceled successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Order cannot be canceled");
        }
    }
}
