package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;

import java.sql.SQLException;

public interface EmployeePayrollDAO extends CrudDAO<EmployeePayrollDTO> {

    boolean updateEmpPayroll(String payrollId, String deductions, String bonuses) throws SQLException;

}
