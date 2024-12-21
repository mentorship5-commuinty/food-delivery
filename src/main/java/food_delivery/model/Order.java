package food_delivery.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDER")
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;
    
    private Long totalAmount ;
        
    private int totalItem ;
    
    private BigDecimal totalPrice;
    
    @ManyToOne
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;
    
    @ColumnDefault("CURRENT_TMESTAMP")
    @Column(name = "CREATED_AT")
    private Instant createdAt;
    
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;
    
    @ManyToOne
    @Column(name = "ADDRESS")
    private Address deliveryAddress;
    
    @OneToMany(mappedBy="order")
    private List<OrderItem> items;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderHistory> orderHistories;
    
}


