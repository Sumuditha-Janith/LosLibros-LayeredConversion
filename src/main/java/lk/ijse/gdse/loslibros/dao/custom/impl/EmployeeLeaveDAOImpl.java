package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.EmployeeLeaveDAO;
import lk.ijse.gdse.loslibros.dto.EmployeeLeaveDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeLeaveDAOImpl implements EmployeeLeaveDAO {

    @Override
    public ArrayList<EmployeeLeaveDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM employee_leave");
        ArrayList<EmployeeLeaveDTO> employeeLeaves = new ArrayList<>();

        while (rst.next()) {
            employeeLeaves.add(new EmployeeLeaveDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDate(4),
                    rst.getDate(5),
                    rst.getString(6)
            ));
        }
        return employeeLeaves;
    }

    @Override
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT leave_id FROM employee_leave ORDER BY leave_id DESC LIMIT 1");
        if (rst.next()) {
            String lastId = rst.getString(1);
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("L%03d", newId);
        }
        return "L001";
    }

    @Override
    public boolean save(EmployeeLeaveDTO dto) throws SQLException {
        return SQLUtil.execute(
                "INSERT INTO employee_leave VALUES (?, ?, ?, ?, ?, ?)",
                dto.getLeaveId(),
                dto.getLeaveEmpId(),
                dto.getLeaveType(),
                dto.getLeaveStartDate(),
                dto.getLeaveEndDate(),
                dto.getLeaveStatus()
        );
    }

    @Override
    public boolean update(EmployeeLeaveDTO dto) throws SQLException {
        return SQLUtil.execute(
                "UPDATE employee_leave SET leave_type = ?, start_date = ?, end_date = ?, status = ? WHERE leave_id = ?",
                dto.getLeaveType(),
                dto.getLeaveStartDate(),
                dto.getLeaveEndDate(),
                dto.getLeaveStatus(),
                dto.getLeaveId()
        );
    }

    @Override
    public boolean delete(String leaveId) throws SQLException {
        return SQLUtil.execute("DELETE FROM employee_leave WHERE leave_id = ?", leaveId);
    }

    @Override
    public boolean updateLeaveStatus(String leaveId, String status) throws SQLException {
        return SQLUtil.execute(
                "UPDATE employee_leave SET status = ? WHERE leave_id = ?",
                status,
                leaveId
        );
    }
}