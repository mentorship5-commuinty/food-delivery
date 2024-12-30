package food_delivery.service;

import food_delivery.request.UpdateRestaurantRequest;

public interface RestaurantService {

    void deleteRestaurantById(Long id);

    void updateRestaurant(UpdateRestaurantRequest updateRestaurantRequest);
}
