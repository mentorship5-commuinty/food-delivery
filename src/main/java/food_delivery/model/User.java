package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="USER")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @NotNull(message = "email field should not be null")
    @Column(name = "USER_EMAIL")
    private String email ;

    @NotNull(message = "mobileNumber field should not be null")
    @Column(name = "USER_MOBILENUMBER")
    private String mobileNumber;

    @OneToMany(mappedBy ="user" , fetch = FetchType.LAZY)
    private List<Customer> customers;

}
