package lk.ijse.gdse.loslibros.model;

import lk.ijse.gdse.loslibros.dao.custom.BookDAO;
import lk.ijse.gdse.loslibros.dao.custom.impl.BookDAOImpl;
import lk.ijse.gdse.loslibros.dto.OrderDetailsDTO;
import lk.ijse.gdse.loslibros.dao.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsModel {
//
////    public final BookModel bookModel = new BookModel();
//    private final BookDAO bookDAO = new BookDAOImpl();
//
//
//    public boolean saveOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetailsDTOS) throws SQLException {
//        for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {
//            boolean isOrderDetailsSaved = saveOrderDetail(orderDetailsDTO);
//            if (!isOrderDetailsSaved) {
//                return false;
//            }
//
//            boolean isBookUpdated = bookDAO.reduceQty(orderDetailsDTO.getBookId(), orderDetailsDTO.getQuantity());
//            if (!isBookUpdated) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean saveOrderDetail(OrderDetailsDTO orderDetailsDTO) throws SQLException {
//        return SQLUtil.execute(
//                "insert into order_details values (?,?,?,?)",
//                orderDetailsDTO.getOrderId(),
//                orderDetailsDTO.getBookId(),
//                orderDetailsDTO.getQuantity(),
//                orderDetailsDTO.getPrice()
//                );
//    }

}
