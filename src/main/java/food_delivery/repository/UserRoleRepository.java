package food_delivery.repository;

import food_delivery.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole , Long> {
}
