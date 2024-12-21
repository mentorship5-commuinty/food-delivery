package food_delivery.model;

import java.time.Instant;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
    
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Float price;
    
    private int quantity;

    @ManyToOne
    @JoinColumn(name ="MENU_ID")
    private Menu menu;
    
    @ManyToOne
    @JoinColumn(name ="ORDER_ID")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name ="CARtITEM_ID")
    private CartItem cartItem;
    
    
    
    private boolean avaliable;
    
    
    //@ManyToOne
   // private Category category;
    

}