package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.EmployeePayrollDAO;
import lk.ijse.gdse.loslibros.dto.EmployeePayrollDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeePayrollDAOImpl implements EmployeePayrollDAO {

    public ArrayList<EmployeePayrollDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from employee_payroll");

        ArrayList<EmployeePayrollDTO> employeePayrollDTOS = new ArrayList<>();

        while (rst.next()) {
            EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
            employeePayrollDTOS.add(employeePayrollDTO);
        }
        return employeePayrollDTOS;
    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select payroll_id from employee_payroll order by payroll_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(4);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("PR%03d", newIdIndex);
        }
        return "PR001";
    }


    public boolean save(EmployeePayrollDTO employeePayrollDTO) throws SQLException {
        return SQLUtil.execute(
                "insert into employee_payroll (payroll_id, emp_id, payroll_date, basic_salary, deductions, bonuses) values (?, ?, ?, ?, ?, ?)",
                employeePayrollDTO.getPayrollId(),
                employeePayrollDTO.getPayrollEmpId(),
                employeePayrollDTO.getPayrollDate(),
                employeePayrollDTO.getBaseSalary(),
                employeePayrollDTO.getDeductions(),
                employeePayrollDTO.getBonuses()
        );
    }

    @Override
    public boolean update(EmployeePayrollDTO dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(String payrollId, String deductions, String bonuses) throws SQLException {
        return SQLUtil.execute(
                "update employee_payroll set deductions = ?, bonuses = ? where payroll_id = ?",
                deductions,
                bonuses,
                payrollId
        );
    }


    public boolean delete(String payrollId) throws SQLException {
        return SQLUtil.execute(
                "delete from employee_payroll where payroll_id = ?",
                payrollId
        );
    }

}
