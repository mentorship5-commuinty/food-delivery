package food_delivery.model;


import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "REST_DETAILS_ID" , referencedColumnName = "REST_DETAILS_ID")
    private RestaurantDetails restaurantDetails;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy ="restaurant" , fetch = FetchType.LAZY)
    private List<Menu> menus;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

}