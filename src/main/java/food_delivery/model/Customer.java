package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="CUSTOMER")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUST_ID")
    private Long id;

    @OneToMany(mappedBy ="customer" ,  fetch = FetchType.LAZY)
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name ="CUST_USER_ID")
    private User user;

    @OneToMany(mappedBy ="customer" ,  fetch = FetchType.LAZY)
    private List<Address> addresses;

}
