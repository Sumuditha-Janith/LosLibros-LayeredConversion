package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    public ArrayList<CustomerDTO> getAll() throws SQLException ;

    public String getNextId() throws SQLException ;

    public boolean save(CustomerDTO customerDTO) throws SQLException ;

    public boolean update(CustomerDTO customerDTO) throws SQLException;

    public boolean delete(String customerId) throws SQLException ;

}
