package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.EmployeeBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.EmployeeDAO;
import lk.ijse.gdse.loslibros.dto.EmployeeDTO;
import lk.ijse.gdse.loslibros.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.EMPLOYEE);

    public ArrayList<EmployeeDTO> getAll() throws SQLException {

        ArrayList<EmployeeDTO> employees = new ArrayList<>();
        ArrayList<Employee> employeeDTOs = employeeDAO.getAll();
        for (Employee employeeDTO : employeeDTOs) {
            employees.add(new EmployeeDTO(new Employee(employeeDTO.getEmpId(),employeeDTO.getEmpName(),employeeDTO.getEmpRole(),employeeDTO.getEmpSalary(),employeeDTO.getEmpAddress(),employeeDTO.getEmpNum(),employeeDTO.getEmpMail())));
        }
        return employees;
    }

    public String getNextId() throws SQLException {
        return employeeDAO.getNextId();
    }

    public boolean save(EmployeeDTO employeeDTO) throws SQLException {
        return employeeDAO.save(new Employee(employeeDTO.getEmpId(),employeeDTO.getEmpName(),employeeDTO.getEmpRole(),employeeDTO.getEmpSalary(),employeeDTO.getEmpAddress(),employeeDTO.getEmpNum(),employeeDTO.getEmpMail()));
    }

    public boolean update(EmployeeDTO employeeDTO) throws SQLException {
        return employeeDAO.update(new Employee(employeeDTO.getEmpId(),employeeDTO.getEmpName(),employeeDTO.getEmpRole(),employeeDTO.getEmpSalary(),employeeDTO.getEmpAddress(),employeeDTO.getEmpNum(),employeeDTO.getEmpMail()));
    }

    public boolean delete(String empId) throws SQLException {
        return employeeDAO.delete(empId);
    }

}

