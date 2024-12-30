package food_delivery.service.impl;

import food_delivery.exception.ApplicationErrorEnum;
import food_delivery.exception.BusinessException;
import food_delivery.model.Restaurant;
import food_delivery.model.RestaurantDetails;
import food_delivery.repository.RestaurantRepository;
import food_delivery.request.UpdateRestaurantRequest;
import food_delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;


    @Override
    public void deleteRestaurantById(Long id) {

    }

    @Override
    public void updateRestaurant(UpdateRestaurantRequest updateRestaurantRequest) {
        Restaurant restaurant = restaurantRepository.findById(updateRestaurantRequest.getId()).orElseThrow(
                ()-> new BusinessException(ApplicationErrorEnum.RESTAURANT_NOT_FOUND)
        );

        RestaurantDetails restaurantDetails = restaurant.getRestaurantDetails();

        restaurant.setName(updateRestaurantRequest.getName());
        restaurant.setAddress(updateRestaurantRequest.getAddress());
        restaurant.setPhoneNumber(updateRestaurantRequest.getPhoneNumber());

        restaurantDetails.setDescription(updateRestaurantRequest.getDescription());
        restaurantDetails.setCapacity(updateRestaurantRequest.getCapacity());

        restaurant.setRestaurantDetails(restaurantDetails);

        restaurantRepository.save(restaurant);

    }
}
