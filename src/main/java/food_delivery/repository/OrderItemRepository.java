package food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import food_delivery.model.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long>{

}
