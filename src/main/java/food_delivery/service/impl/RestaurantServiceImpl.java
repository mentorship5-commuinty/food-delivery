package food_delivery.service.impl;

import food_delivery.exception.ApplicationErrorEnum;
import food_delivery.exception.BusinessException;
import food_delivery.model.Address;
import food_delivery.model.Restaurant;
import food_delivery.model.RestaurantDetails;
import food_delivery.repository.RestaurantRepository;
import food_delivery.request.RestaurantRequest;
import food_delivery.service.AddressService;
import food_delivery.service.RestaurantDetailsService;
import food_delivery.exception.ApplicationErrorEnum;
import food_delivery.exception.BusinessException;
import food_delivery.request.UpdateRestaurantRequest;
import food_delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private final RestaurantRepository restaurantRepository;
	@Autowired
	private final AddressService addressService;
	@Autowired
	private final RestaurantDetailsService restaurantDetailsService;

	@Override
	public void createRestaurant(RestaurantRequest req) {

		Address address =addressService.createAddress(req.getAddress());

		RestaurantDetails restaurantDetails  = restaurantDetailsService.createRestaurantDetails(req);

		Restaurant restaurant = new Restaurant();

		restaurant.setName(req.getName());
		restaurant.setPhoneNumber(req.getPhoneNumber());
		restaurant.setAddress(address);
		restaurant.setRestaurantDetails(restaurantDetails);

		restaurantRepository.save(restaurant);
	}

    @Override
    public void deleteRestaurantById(Long id) {

    }

    @Override
    public void updateRestaurant(UpdateRestaurantRequest updateRestaurantRequest) {
        Restaurant restaurant = restaurantRepository.findById(updateRestaurantRequest.getId()).orElseThrow(
                ()-> new BusinessException(ApplicationErrorEnum.RESTAURANT_NOT_FOUND)
        );

		Address address = restaurant.getAddress();
		if(address == null) {
            address = new Address();
			address.setRestaurant(restaurant);
        }
		address.setCity(updateRestaurantRequest.getAddress().getCity());
		address.setCountry(updateRestaurantRequest.getAddress().getCountry());
		address.setPostalCode(updateRestaurantRequest.getAddress().getPostalCode());
		address.setAddressLine1(updateRestaurantRequest.getAddress().getAddressLine1());

        RestaurantDetails restaurantDetails = restaurant.getRestaurantDetails();
		if(restaurantDetails == null)
		{
			restaurantDetails = new RestaurantDetails();
			restaurantDetails.setRestaurant(restaurant);
		}

		restaurantDetails.setDescription(updateRestaurantRequest.getRestaurantDetails().getDescription());
        restaurantDetails.setCapacity(updateRestaurantRequest.getRestaurantDetails().getCapacity());


        restaurant.setName(updateRestaurantRequest.getName());
        restaurant.setPhoneNumber(updateRestaurantRequest.getPhoneNumber());

        restaurant.setRestaurantDetails(restaurantDetails);
		restaurant.setAddress(address);

        restaurantRepository.save(restaurant);
	}
}
