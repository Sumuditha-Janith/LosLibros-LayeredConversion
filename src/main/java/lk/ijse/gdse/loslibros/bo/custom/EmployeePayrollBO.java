package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeePayrollBO extends SuperBO {

    ArrayList<EmployeePayrollDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    boolean save(EmployeePayrollDTO employeePayrollDTO) throws SQLException;

    boolean update(EmployeePayrollDTO employeePayrollDTO) throws SQLException;

    boolean delete(String payrollId) throws SQLException;

    boolean updateEmpPayroll(String payrollId, String deductions, String bonuses) throws SQLException;

}
