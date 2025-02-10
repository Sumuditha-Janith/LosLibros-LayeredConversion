package lk.ijse.gdse.loslibros.entity;

import lombok.*;

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
}