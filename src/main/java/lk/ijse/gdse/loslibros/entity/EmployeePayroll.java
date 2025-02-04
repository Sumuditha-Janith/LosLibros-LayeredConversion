package lk.ijse.gdse.loslibros.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeePayroll {

    private String payrollId;
    private String payrollEmpId;
    private Date payrollDate;
    private String baseSalary;
    private String deductions;
    private String bonuses;
    private String netSalary;

}
