package food_delivery.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
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
@Table(name="ORDER_table")
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;


    private int totalItemCount;

    private int totalItemQuantity;
    
    private BigDecimal totalPrice;
    
    @OneToMany(mappedBy = "orderStatus")
    @Column(name = "ORDER_STATUS")
    private List<OrderStatus> orderStatus = new ArrayList<>();;
    
//    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CREATED_AT")
    private Instant createdAt;
    
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;
    
    @ManyToOne
    @JoinColumn(name = "ADDRESS")
    private Address deliveryAddress;
    
    @OneToMany(mappedBy="order" , cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderHistory> orderHistories = new ArrayList<>();;

    public void addItems(OrderItem orderItem)
    {
        items.add(orderItem);
        orderItem.setOrder(this);
    }

    public void removeItem(OrderItem orderItem) {
        items.remove(orderItem);
        orderItem.setOrder(null);
    }
}


