package food_delivery.service;

import food_delivery.model.Customer;
import food_delivery.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(Long customerId)
    {
        return customerRepository.findById(customerId);
    }
}
