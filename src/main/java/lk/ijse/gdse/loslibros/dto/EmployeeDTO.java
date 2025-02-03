package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Employee;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeDTO {

    private String empId;
    private String empName;
    private String empRole;
    private String empSalary;
    private String empAddress;
    private String empNum;
    private String empMail;

    public EmployeeDTO(Employee employee) {
        this.empId = employee.getEmpId();
        this.empName = employee.getEmpName();
        this.empRole = employee.getEmpRole();
        this.empSalary = employee.getEmpSalary();
        this.empAddress = employee.getEmpAddress();
        this.empNum = employee.getEmpNum();
        this.empMail = employee.getEmpMail();
    }
}
