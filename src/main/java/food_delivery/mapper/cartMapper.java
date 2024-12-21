package food_delivery.mapper;

import food_delivery.dto.CartDTO;
import food_delivery.model.Cart;

public class cartMapper {
	
	
	public  static CartDTO toDTO (Cart cart) {
		
		return CartDTO.builder().id(cart.getCartId()).build() ;
	}

}
