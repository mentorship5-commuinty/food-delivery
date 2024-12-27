package food_delivery.request;

import lombok.Data;

@Data
public class OrderRequest {
    private Long customerId;
    private Long addressId;
}