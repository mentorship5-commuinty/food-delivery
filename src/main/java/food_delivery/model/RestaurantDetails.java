package food_delivery.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RESTAURANT_DETAILS")
public class RestaurantDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REST_DETAILS_ID")
    private Long restDetailsId;

    @Column(name = "REST_DETAILS_DESC")
    private String restDetailsDESC;

    @OneToOne(mappedBy = "restaurantDetails")
    private Restaurant restaurant;
    
   // @OneToMany
   // private Address address;

}