package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="RESTAURANT")
public class Restaurant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REST_DETAILS_ID" , referencedColumnName = "restDetailsId")
    private RestaurantDetails restaurantDetails;

    @OneToMany(mappedBy ="restaurant" , fetch = FetchType.LAZY)
    private List<Menu> menus;

}