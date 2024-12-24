package food_delivery.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CUSTOMER")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_ID")
    private Long customerId;

    @OneToOne(mappedBy ="customer")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name ="CUST_USER_ID")
    private User user;

    @OneToMany(mappedBy ="customer" ,cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private List<Address> addresses;
    
    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Order> orders;

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

}
