package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Customer;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDTO {

    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    public CustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();
        this.customerAddress = customer.getCustomerAddress();
        this.customerPhone = customer.getCustomerPhone();

    }
}
