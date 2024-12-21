package food_delivery.service;


import java.util.List;

import org.springframework.stereotype.Service;

import food_delivery.dto.CartDTO;
import food_delivery.dto.CartItemDTO;
import food_delivery.dto.CartItemRequestDTO;
import food_delivery.mapper.CartItemMapper;
import food_delivery.mapper.cartMapper;
import food_delivery.model.Cart;
import food_delivery.model.Customer;
import food_delivery.repository.CartRepository;
import food_delivery.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartService {
	
	private final CartRepository cartRepository;
	private final CustomerRepository customerRepository;
	
	
	public CartDTO createCart(Long customerId) {
		
		Customer customer= customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
		
		Cart cart = new Cart();
		cart.setCustomer(customer);
		cart.setCartItems(null);
		Cart newcart = cartRepository.save(cart);
		
		return cartMapper.toDTO(newcart) ;	
	}
	
	public List<CartItemDTO> addItemToCart(CartItemRequestDTO cartItemRequest) {
		
		Customer customer = customerRepository.findById(cartItemRequest.getCustomerId()).orElseThrow(()-> new RuntimeException("Customer not found"));
		
		Cart cart = getCustomerCart(cartItemRequest.getCustomerId());
		
		if(cart == null) {
			Cart newCart = Cart.createCart(customer) ;
			cart = saveCart(newCart);
			
		}
		
		return CartItemMapper.toDtos(cart.getCartItems());
		
		
	}
	
	public List<CartItemDTO> viewCart(Long customerId) {
		Cart cart = getCustomerCart(customerId);
		return CartItemMapper.toDtos(cart.getCartItems());	
	}
	
	
	public Cart getCustomerCart(Long CustomerId) {
		
		Customer customer = customerRepository.findById(CustomerId).orElseThrow(()-> new RuntimeException("Customer not found"));
	    Cart cart = customer.getCart();
		return cart;	
	}
	
	public Cart saveCart(Cart newcart) {
		
		return cartRepository.save(newcart);	
	}
	
	

}
