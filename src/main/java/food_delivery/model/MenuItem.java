package food_delivery.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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