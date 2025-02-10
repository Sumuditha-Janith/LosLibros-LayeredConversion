package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.EmployeeLeave;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeLeaveDTO {
    private String leaveId;
    private String leaveEmpId;
    private String leaveType;
    private Date leaveStartDate;
    private Date leaveEndDate;
    private String leaveStatus;

    public EmployeeLeaveDTO(EmployeeLeave employeeLeave) {
        this.leaveId = employeeLeave.getLeaveId();
        this.leaveEmpId = employeeLeave.getLeaveEmpId();
        this.leaveType = employeeLeave.getLeaveType();
        this.leaveStartDate = employeeLeave.getLeaveStartDate();
        this.leaveEndDate = employeeLeave.getLeaveEndDate();
        this.leaveStatus = employeeLeave.getLeaveStatus();
    }
}