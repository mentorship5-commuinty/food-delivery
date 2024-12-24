package food_delivery.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDER_ITEM")
@Builder
public class OrderItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long orderItemId;
	
	private int quantity;
	
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "menu_item_id")
	private MenuItem menuItem;
	
	
}
