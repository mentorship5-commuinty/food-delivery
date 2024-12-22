package food_delivery.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDER_STATUS")
public class OrderStatus {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_STATUS_ID")
    private Long orderStatusId;
	
	private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

}
