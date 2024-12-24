package food_delivery.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="CART")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private Long cartId;
  
    @OneToOne
    @JoinColumn(name="CART_CUST_ID" , referencedColumnName="CUST_ID")
    private Customer customer;

    @OneToMany(mappedBy ="cart" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
    
    private BigDecimal total;
    
//    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CREATED_AT")
    private Instant createdAt;
    
//    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "UPDATED_AT")
    private Instant updateAt;
    
    public static Cart createCart(Customer customer) {
    	return Cart.builder()
    			.customer(customer)
    			.build();	
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId);
    }
}
