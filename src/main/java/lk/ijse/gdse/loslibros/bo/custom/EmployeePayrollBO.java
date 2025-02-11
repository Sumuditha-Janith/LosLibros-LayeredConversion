package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeePayrollBO extends SuperBO {

    ArrayList<EmployeePayrollDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException;

    public boolean save(EmployeePayrollDTO employeePayrollDTO) throws SQLException;

    public boolean update(EmployeePayrollDTO employeePayrollDTO) throws SQLException;

    public boolean delete(String payrollId) throws SQLException;

    public boolean updateEmpPayroll(String payrollId, String deductions, String bonuses) throws SQLException;

}
