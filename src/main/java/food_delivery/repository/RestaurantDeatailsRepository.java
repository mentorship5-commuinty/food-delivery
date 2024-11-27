package food_delivery.repository;

import food_delivery.model.RestaurantDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDeatailsRepository extends JpaRepository<RestaurantDetails, Long>{
}
