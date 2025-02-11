package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.OrderDAO;
import lk.ijse.gdse.loslibros.dto.OrderDTO;
import lk.ijse.gdse.loslibros.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select order_id from orders order by order_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(4);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("O0%03d", newIdIndex);
        }
        return "O0001";
    }


    public boolean save(Order orderDTO) throws SQLException {

        return SQLUtil.execute(
                "insert into orders values (?,?,?)",
                orderDTO.getOrderId(),
                orderDTO.getCustomerId(),
                orderDTO.getOrderDate()
        );
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Order dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String dto) throws SQLException {
        return false;
    }



}
