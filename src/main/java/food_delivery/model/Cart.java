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
@Table(name="CART")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private Long cartId;

    @ManyToOne
    @JoinColumn(name="CART_CUST_ID")
    private Customer customer;

    @OneToMany(mappedBy ="cart" , fetch = FetchType.LAZY)
    private List<CartItem> cartItems;
}
