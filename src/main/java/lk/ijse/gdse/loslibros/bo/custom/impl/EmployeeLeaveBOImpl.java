package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.EmployeeLeaveBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.EmployeeLeaveDAO;
import lk.ijse.gdse.loslibros.dto.EmployeeLeaveDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeLeaveBOImpl implements EmployeeLeaveBO {

    EmployeeLeaveDAO employeeLeaveDAO = (EmployeeLeaveDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.EMPLOYEE_LEAVE);

    @Override
    public ArrayList<EmployeeLeaveDTO> getAll() throws SQLException {
        return employeeLeaveDAO.getAll();
    }

    @Override
    public String getNextId() throws SQLException {
        return employeeLeaveDAO.getNextId();
    }

    @Override
    public boolean save(EmployeeLeaveDTO dto) throws SQLException {
        return employeeLeaveDAO.save(dto);
    }

    @Override
    public boolean update(EmployeeLeaveDTO dto) throws SQLException {
        return employeeLeaveDAO.update(dto);
    }

    @Override
    public boolean delete(String leaveId) throws SQLException {
        return employeeLeaveDAO.delete(leaveId);
    }

    @Override
    public boolean updateLeaveStatus(String leaveId, String status) throws SQLException {
        return employeeLeaveDAO.updateLeaveStatus(leaveId, status);
    }
}