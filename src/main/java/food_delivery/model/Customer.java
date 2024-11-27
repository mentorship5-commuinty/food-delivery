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
@Table(name="CUSTOMER")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_ID")
    private Long id;

    @OneToMany(mappedBy ="customer" ,  fetch = FetchType.LAZY)
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name ="CUST_USER_ID")
    private User user;

    @OneToMany(mappedBy ="customer" ,  fetch = FetchType.LAZY)
    private List<Address> addresses;

}
