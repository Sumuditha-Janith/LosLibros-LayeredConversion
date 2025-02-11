package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {

    ArrayList<EmployeeDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    boolean save(EmployeeDTO employeeDTO) throws SQLException;

    boolean update(EmployeeDTO employeeDTO) throws SQLException;

    boolean delete(String empId) throws SQLException;

    ArrayList<String> getAllEmployIds() throws SQLException;

    EmployeeDTO findEmpById(String employeeId) throws SQLException;

}
