package lk.ijse.gdse.loslibros.entity;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderId;
    private String customerId;
    private String orderDate;
    private ArrayList<OrderDetails> orderDetails;

    public Order(String orderId, String customerId, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate.toString();
    }
}