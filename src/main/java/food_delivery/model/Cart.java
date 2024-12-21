package food_delivery.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
    @JoinColumn(name="CART_CUST_ID" , referencedColumnName	 ="customerId")
    private Customer customer;

    @OneToMany(mappedBy ="cart" , fetch = FetchType.LAZY)
    private List<CartItem> cartItems;
    
    private BigDecimal total;
    
    @ColumnDefault("CURRENT_TMESTAMP")
    @Column(name = "CREATED_AT")
    private Instant createdAt;
    
    @ColumnDefault("CURRENT_TMESTAMP")
    @Column(name = "UPDATED_AT")
    private Instant updateAt;
    
    public static Cart createCart(Customer customer) {
    	return Cart.builder()
    			.customer(customer)
    			.build();	
    }
}
