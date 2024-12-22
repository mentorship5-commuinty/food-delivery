package food_delivery.model;


import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RESTAURANT")
public class Restaurant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REST_DETAILS_ID" , referencedColumnName = "REST_DETAILS_ID")
    private RestaurantDetails restaurantDetails;

    @OneToMany(mappedBy ="restaurant" , fetch = FetchType.LAZY)
    private List<Menu> menus;
    
    @OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL)
    private List<Order> orders;

}