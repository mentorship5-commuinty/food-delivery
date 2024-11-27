package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="ADDRESS")
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTALCODE")
    private String postalCode;

    @Column(name = "ADDRESSLINE1")
    private String addressLine1;

    @Column(name = "ADDRESSLINE2")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name ="ADDRESS_CUST_ID")
    private Customer customer;

}