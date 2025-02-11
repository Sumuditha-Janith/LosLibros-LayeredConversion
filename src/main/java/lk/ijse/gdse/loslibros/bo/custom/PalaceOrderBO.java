package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.OrderDTO;
import lk.ijse.gdse.loslibros.dto.OrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PalaceOrderBO extends SuperBO {

    String getNextOrderId() throws SQLException;

    boolean saveOrder(OrderDTO orderDTO) throws SQLException;

    boolean placeOrder(OrderDTO orderDTO) throws SQLException;

    boolean saveOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetailsDTOS) throws SQLException ;

    boolean saveOrderDetail(OrderDetailsDTO orderDetailsDTO) throws SQLException;

}
