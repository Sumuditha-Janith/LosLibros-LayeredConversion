package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.EmployeePayrollDAO;
import lk.ijse.gdse.loslibros.dto.EmployeeDTO;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;
import lk.ijse.gdse.loslibros.entity.Employee;
import lk.ijse.gdse.loslibros.entity.EmployeePayroll;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeePayrollBOImpl {

    EmployeePayrollDAO employeePayrollDAO = (EmployeePayrollDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.EMPLOYEE_PAYROLL);

    ArrayList<EmployeePayrollDTO> getAll() throws SQLException {

        ArrayList<EmployeePayrollDTO> employeePayrolls = new ArrayList<>();
        ArrayList<EmployeePayrollDTO> employeePayrollDTOs = employeePayrollDAO.getAll();
        for (EmployeePayrollDTO employeePayrollDTO : employeePayrollDTOs) {
            employeePayrolls.add(new EmployeePayrollDTO(new EmployeePayroll(
                    employeePayrollDTO.getPayrollId(),
                    employeePayrollDTO.getPayrollEmpId(),
                    employeePayrollDTO.getPayrollDate(),
                    employeePayrollDTO.getBaseSalary(),
                    employeePayrollDTO.getDeductions(),
                    employeePayrollDTO.getBonuses(),
                    employeePayrollDTO.getNetSalary())));
        }
        return employeePayrolls;
    }

    public String getNextId() throws SQLException {
        return employeePayrollDAO.getNextId();
    }

    public boolean save(EmployeePayrollDTO employeePayrollDTO) throws SQLException {
        return employeePayrollDAO.save(new EmployeePayrollDTO(
                employeePayrollDTO.getPayrollId(),
                employeePayrollDTO.getPayrollEmpId(),
                employeePayrollDTO.getPayrollDate(),
                employeePayrollDTO.getBaseSalary(),
                employeePayrollDTO.getDeductions(),
                employeePayrollDTO.getBonuses(),
                employeePayrollDTO.getNetSalary()));
    }

    
}
