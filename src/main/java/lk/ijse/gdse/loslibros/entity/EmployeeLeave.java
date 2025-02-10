package lk.ijse.gdse.loslibros.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeLeave {
    private String leaveId;
    private String leaveEmpId;
    private String leaveType;
    private Date leaveStartDate;
    private Date leaveEndDate;
    private String leaveStatus;
}