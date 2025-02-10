package lk.ijse.gdse.loslibros.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private String orderId;
    private String bookId;
    private int quantity;
    private double price;
}