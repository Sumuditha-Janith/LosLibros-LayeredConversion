package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeePayrollDAO extends CrudDAO<EmployeePayrollDTO> {

    public ArrayList<EmployeePayrollDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException;

    public boolean save(EmployeePayrollDTO employeePayrollDTO) throws SQLException;

    public boolean update(String payrollId, String deductions, String bonuses) throws SQLException;

    public boolean delete(String payrollId) throws SQLException;

}
