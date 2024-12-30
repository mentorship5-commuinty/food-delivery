package food_delivery.controller;

import food_delivery.request.UpdateRestaurantRequest;
import food_delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/v1/restaurant")
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService ;

    @PutMapping
    public ResponseEntity<?> updateRestaurant(
            @RequestBody UpdateRestaurantRequest updateRestaurantRequest
    )
    {
        restaurantService.updateRestaurant(updateRestaurantRequest);
        return ResponseEntity.noContent().build();
    }

}
