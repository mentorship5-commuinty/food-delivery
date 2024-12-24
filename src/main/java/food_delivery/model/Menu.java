package food_delivery.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuId, menu.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menuId);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                '}';
    }
}
