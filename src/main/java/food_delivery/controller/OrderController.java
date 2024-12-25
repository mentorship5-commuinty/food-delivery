package food_delivery.controller;


import food_delivery.dto.OrderUpdateStatusDto;
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

    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = new OrderResponse();
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long orderId) {

        OrderResponse orderResponse = orderService.getOrder(orderId);
        return ResponseEntity.ok(orderResponse);
    }


    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<OrderStatusResponse> cancelOrder(@PathVariable Integer orderId) {
        // a method to call the service to cancel the order
        return ResponseEntity.ok(orderService.cancel(Long.valueOf(orderId)));
    }

    @GetMapping("/status/{orderId}")

    public ResponseEntity<OrderStatusResponse> getOrderStatus(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getStatus(orderId));
    }

    @PutMapping("/status/{orderId}")
    public ResponseEntity<OrderStatusResponse> updateOrderStatus(@PathVariable Long orderId , @RequestBody OrderUpdateStatusDto orderUpdateStatusDto) {
        return ResponseEntity.ok(orderService.updateStatus(orderId , Long.valueOf(orderUpdateStatusDto.getOrderStatusId())));
    }

}

