package food_delivery.model;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
