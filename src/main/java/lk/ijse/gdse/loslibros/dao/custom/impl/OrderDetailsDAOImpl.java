package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.loslibros.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException {
        return null;
    }

    public boolean save(OrderDetails orderDetailsDTO) throws SQLException {
        return SQLUtil.execute(
                "insert into order_details values (?,?,?,?)",
                orderDetailsDTO.getOrderId(),
                orderDetailsDTO.getBookId(),
                orderDetailsDTO.getQuantity(),
                orderDetailsDTO.getPrice()
        );
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String dto) throws SQLException {
        return false;
    }

}
