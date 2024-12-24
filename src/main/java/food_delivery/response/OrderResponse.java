package food_delivery.response;

import food_delivery.enums.OrderStatus;
import food_delivery.request.CartItemRequest;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private Long orderId;
    private Long customerId;
    private Long restaurantId;
    private List<CartItemRequest> items;
    private Double totalPrice;
    private LocalDateTime orderTime;
    private String deliveryAddress;
    private OrderStatus orderStatus;
}
