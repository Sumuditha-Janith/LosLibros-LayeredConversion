package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;
import lk.ijse.gdse.loslibros.entity.EmployeePayroll;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeePayrollBO extends SuperBO {

    ArrayList<EmployeePayrollDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException;

    public boolean save(EmployeePayrollDTO employeePayrollDTO) throws SQLException;

    public boolean update(EmployeePayrollDTO employeePayrollDTO) throws SQLException;

    public boolean delete(String payrollId) throws SQLException;
}
