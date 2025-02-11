package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.PalaceOrderBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.BookDAO;
import lk.ijse.gdse.loslibros.dao.custom.OrderDAO;
import lk.ijse.gdse.loslibros.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.loslibros.db.DBConnection;
import lk.ijse.gdse.loslibros.dto.OrderDTO;
import lk.ijse.gdse.loslibros.dto.OrderDetailsDTO;
import lk.ijse.gdse.loslibros.entity.Order;
import lk.ijse.gdse.loslibros.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PalaceOrderBOImpl implements PalaceOrderBO {

    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ORDER_DETAILS);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ORDER);
    BookDAO bookDAO = (BookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.BOOK);


    public String getNextOrderId() throws SQLException {
        return orderDAO.getNextId();

    }

    public boolean saveOrder(OrderDTO orderDTO) throws SQLException {
        return orderDAO.save(new Order(orderDTO.getOrderId(),orderDTO.getCustomerId(),orderDTO.getOrderDate()));
    }

    public boolean saveOrderDetail(OrderDetailsDTO orderDetailsDTO) throws SQLException {
        return orderDetailsDAO.save(new OrderDetails(orderDetailsDTO.getOrderId(),orderDetailsDTO.getBookId(),orderDetailsDTO.getQuantity(),orderDetailsDTO.getPrice()));
    }



    public boolean placeOrder(OrderDTO orderDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            boolean isOrderSaved = saveOrder(orderDTO);

            if (isOrderSaved) {
                boolean isOrderDetailListSaved = saveOrderDetailsList(orderDTO.getOrderDetailsDTOS());
                if (isOrderDetailListSaved) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }


    public boolean saveOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetailsDTOS) throws SQLException {

        for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {
            boolean isOrderDetailsSaved = saveOrderDetail(orderDetailsDTO);
            if (!isOrderDetailsSaved) {
                return false;
            }

            boolean isBookUpdated = bookDAO.reduceQty(orderDetailsDTO.getBookId(), orderDetailsDTO.getQuantity());
            if (!isBookUpdated) {
                return false;
            }
        }
        return true;
    }

}
