package food_delivery.dto;


import java.util.List;

import food_delivery.model.Cart;
import food_delivery.model.CartItem;
import food_delivery.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemDTO {
	
	    private Long cartItemId;
	    private Integer quantity;
	    private Cart cart;
		
}
