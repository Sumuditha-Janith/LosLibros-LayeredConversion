package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.custom.CustomerDAO;
import lk.ijse.gdse.loslibros.dto.CustomerDTO;
import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public ArrayList<Customer> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from customer");

        ArrayList<Customer> customerDTOS = new ArrayList<>();

        while (rst.next()) {
            Customer customerDTO = new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select cus_id from customer order by cus_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("C0%03d", newIdIndex);
        }
        return "C0001";
    }
    public boolean save(Customer dto) throws SQLException {
        return SQLUtil.execute(
                "insert into customer values(?,?,?,?)",
                dto.getCustomerId(),
                dto.getCustomerName(),
                dto.getCustomerAddress(),
                dto.getCustomerPhone()
        );


    }

    public boolean update(Customer dto) throws SQLException {
        return SQLUtil.execute(
                "update customer set cus_name=?, cus_address=?, p_num=? where cus_id=?",
                dto.getCustomerName(),
                dto.getCustomerAddress(),
                dto.getCustomerPhone(),
                dto.getCustomerId()
        );
    }

    public boolean delete(String dto) throws SQLException {
        return SQLUtil.execute(
                "delete from customer where cus_id=?", dto
        );
    }


    public ArrayList<String> getAllCustomerIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("select cus_id from customer");

        ArrayList<String> customerIds = new ArrayList<>();

        while (rst.next()) {
            customerIds.add(rst.getString(1));
        }

        return customerIds;
    }

    public CustomerDTO findCusById(String selectedCusId) throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from customer where cus_id=?", selectedCusId);

        if (rst.next()) {
            return new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

}
