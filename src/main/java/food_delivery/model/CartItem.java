package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="CART_ITEM")
public class CartItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ITEM_ID")
    private Long cartItemId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name ="CART_ID")
    private Cart cart;
}
