package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public interface EmployeePayrollDAO extends CrudDAO<EmployeePayrollDTO> {

    public boolean updateEmpPayroll(String payrollId, String deductions, String bonuses) throws SQLException;

}
