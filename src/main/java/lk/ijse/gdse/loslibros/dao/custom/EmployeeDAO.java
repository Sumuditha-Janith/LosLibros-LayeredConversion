package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.EmployeeDTO;
import lk.ijse.gdse.loslibros.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee> {

    ArrayList<String> getAllEmployIds() throws SQLException;

    EmployeeDTO findEmpById(String employeeId) throws SQLException;

}
