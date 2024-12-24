package food_delivery.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="CART_ITEM")
public class CartItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ITEM_ID")
    private Long cartItemId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name ="CART_ID")
    private Cart cart;
    
    @OneToOne
    @JoinColumn(name ="MENU_ITEM_ID")
	private MenuItem menuItem;
    
    
    public static CartItem createCartItem(Customer customer) {
    	return CartItem.builder()
    			
    			.build();
    	
    }
}
