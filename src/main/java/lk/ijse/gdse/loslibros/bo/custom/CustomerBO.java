package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException ;

    public String getNextCustomerId() throws SQLException ;
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException ;

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException;

    public boolean deleteCustomer(String customerId) throws SQLException ;

}
