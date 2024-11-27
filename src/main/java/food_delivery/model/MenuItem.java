package food_delivery.model;

@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="MENU_ITEM")
public class MenuItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ITEM_ID")
    private Long menuItemId;

    @Column(name = "ITEM_NAME")
    private String ItemName;

    @Column(name = "PRICE")
    private String price;

    @ManyToOne
    @JoinColumn(name ="MENU_ID")
    private Menu menu;

}