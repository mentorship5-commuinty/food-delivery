package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="MENU")
public class Menu{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Long menuId;

    @ManyToOne
    @JoinColumn(name ="RESTAURANT_ID")
    private Restaurant restaurant;

    @OneToMany(mappedBy ="menu" , fetch = FetchType.LAZY)
    private List<MenuItem> menuItems;

}
