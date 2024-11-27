package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="CART")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private Long cartId;

    @ManyToOne
    @JoinColumn(name="CART_CUST_ID")
    private Customer customer;

    @OneToMany(mappedBy ="cart" , fetch = FetchType.LAZY)
    private List<CartItem> cartItems;
}
