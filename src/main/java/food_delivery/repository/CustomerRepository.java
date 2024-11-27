package food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import food_delivery.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
