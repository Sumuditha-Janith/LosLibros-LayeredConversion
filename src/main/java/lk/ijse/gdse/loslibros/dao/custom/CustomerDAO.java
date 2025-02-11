package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.CustomerDTO;
import lk.ijse.gdse.loslibros.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {

    ArrayList<String> getAllCustomerIds() throws SQLException;

    CustomerDTO findCusById(String selectedCusId) throws SQLException;


}
