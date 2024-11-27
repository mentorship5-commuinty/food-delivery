package food_delivery.model;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_EMAIL")
    private String email ;

    @Column(name = "USER_MOBILENUMBER")
    private String mobileNumber;

    @OneToMany(mappedBy ="user" , fetch = FetchType.LAZY)
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name ="USER_TYPE_ID")
    private UserType userType;

}
