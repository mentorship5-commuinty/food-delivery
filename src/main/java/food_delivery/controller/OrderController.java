package food_delivery.controller;

import food_delivery.mapper.OrderMapper;
import food_delivery.model.Order;
import food_delivery.request.OrderRequest;
import food_delivery.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
