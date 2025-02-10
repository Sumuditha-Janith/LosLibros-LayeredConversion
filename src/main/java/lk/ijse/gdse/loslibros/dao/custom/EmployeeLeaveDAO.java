package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.EmployeeLeaveDTO;

import java.sql.SQLException;

public interface EmployeeLeaveDAO extends CrudDAO<EmployeeLeaveDTO> {

    boolean updateLeaveStatus(String leaveId, String status) throws SQLException;
}