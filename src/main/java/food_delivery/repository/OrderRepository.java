package food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import food_delivery.model.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}
