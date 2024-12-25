package food_delivery.controller;


import food_delivery.enums.OrderStatusEnum;
import food_delivery.request.OrderRequest;
import food_delivery.response.OrderResponse;
import food_delivery.response.OrderStatusResponse;
import food_delivery.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@Data
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")

    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long orderId) {

        OrderResponse orderResponse = orderService.getOrder(orderId);
        System.out.println("OrderResponse" + orderResponse);
        return ResponseEntity.ok(orderResponse);
    }


    @DeleteMapping("/cancel/{orderId}")

    public ResponseEntity<OrderStatusResponse> cancelOrder(@PathVariable Long orderId) {
        // a method to call the service to cancel the order
        return ResponseEntity.ok(orderService.cancel(orderId));
    }

    @GetMapping("/status/{orderId}")

    public ResponseEntity<OrderStatusResponse> getOrderStatus(@PathVariable Long orderId) {
        // a method to call the service to get the status

        //return a fake status
        return ResponseEntity.ok(orderService.getStatus(orderId));
    }

    @PutMapping("/status")
    public ResponseEntity<OrderStatusResponse> updateOrderStatus(@RequestParam Long orderId , @RequestBody OrderStatusEnum orderStatusId) {
        // a method to call the service to update the status
        return ResponseEntity.ok(orderService.updateStatus(orderId , orderStatusId));
    }

}

