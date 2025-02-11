package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {

    public ArrayList<EmployeeDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException;

    public boolean save(EmployeeDTO employeeDTO) throws SQLException;

    public boolean update(EmployeeDTO employeeDTO) throws SQLException;

    public boolean delete(String empId) throws SQLException;

    public ArrayList<String> getAllEmployIds() throws SQLException;

    public EmployeeDTO findEmpById(String employeeId) throws SQLException;

}
