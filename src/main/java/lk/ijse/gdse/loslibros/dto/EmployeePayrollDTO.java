package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Employee;
import lk.ijse.gdse.loslibros.entity.EmployeePayroll;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeePayrollDTO {

    private String payrollId;
    private String payrollEmpId;
    private Date payrollDate;
    private String baseSalary;
    private String deductions;
    private String bonuses;
    private String netSalary;

    public EmployeePayrollDTO(EmployeePayroll employeePayroll) {
        this.payrollId = employeePayroll.getPayrollId();
        this.payrollEmpId = employeePayroll.getPayrollEmpId();
        this.payrollDate = employeePayroll.getPayrollDate();
        this.baseSalary = employeePayroll.getBaseSalary();
        this.deductions = employeePayroll.getDeductions();
        this.bonuses = employeePayroll.getBonuses();
        this.netSalary = employeePayroll.getNetSalary();
    }

}
