package lk.ijse.gdse.loslibros.view.tdm;

import java.sql.Date;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeLeaveTM {

    private String leaveId;
    private String leaveEmpId;
    private String leaveType;
    private Date leaveStartDate;
    private Date leaveEndDate;
    private String leaveStatus;

}
