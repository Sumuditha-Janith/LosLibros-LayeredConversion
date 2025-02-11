package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    ArrayList<CustomerDTO> getAll() throws SQLException ;

    String getNextId() throws SQLException ;

    boolean save(CustomerDTO customerDTO) throws SQLException ;

    boolean update(CustomerDTO customerDTO) throws SQLException;

    boolean delete(String customerId) throws SQLException ;

    ArrayList<String> getAllCustomerIds() throws SQLException;

    CustomerDTO findCusById(String selectedCusId) throws SQLException;

}
