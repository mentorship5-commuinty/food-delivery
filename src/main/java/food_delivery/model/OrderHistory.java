package food_delivery.model;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDER_ITEM")
public class OrderHistory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERHISTORY_ID")
    private Long orderHistoryId;
	
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private String status; //  "Created", "In Progress", "Completed"

    private String comments; 

    @Column(nullable = false)
    private LocalDateTime timestamp;

}
