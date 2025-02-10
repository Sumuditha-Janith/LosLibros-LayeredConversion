package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.EmployeeLeaveDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeLeaveBO extends SuperBO {
    ArrayList<EmployeeLeaveDTO> getAll() throws SQLException;
    String getNextId() throws SQLException;
    boolean save(EmployeeLeaveDTO dto) throws SQLException;
    boolean update(EmployeeLeaveDTO dto) throws SQLException;
    boolean delete(String leaveId) throws SQLException;
    boolean updateLeaveStatus(String leaveId, String status) throws SQLException;
}