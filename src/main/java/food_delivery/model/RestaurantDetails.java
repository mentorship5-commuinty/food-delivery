package food_delivery.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="restaurant_details")
public class RestaurantDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "capacity")
    private Integer capacity;

}