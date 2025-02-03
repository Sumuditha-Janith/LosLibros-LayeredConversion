package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.EmployeeDAO;
import lk.ijse.gdse.loslibros.dto.EmployeeDTO;
import lk.ijse.gdse.loslibros.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

    public ArrayList<Employee> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from employee");

        ArrayList<Employee> employeeDTOS = new ArrayList<>();

        while (rst.next()) {
            Employee employeeDTO = new Employee(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)


            );
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;

    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select emp_id from employee order by emp_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("E%03d", newIdIndex);
        }
        return "E001";
    }

    public boolean save(Employee dto) throws SQLException {
        return SQLUtil.execute(
                "insert into employee values (?,?,?,?,?,?,?)",
                dto.getEmpId(),
                dto.getEmpName(),
                dto.getEmpRole(),
                dto.getEmpSalary(),
                dto.getEmpAddress(),
                dto.getEmpNum(),
                dto.getEmpMail()

        );
    }

    public boolean update(Employee dto) throws SQLException {
        return SQLUtil.execute(
                "update employee set emp_name=?, emp_role=?, emp_salary=?, emp_add=?, emp_num=?, emp_mail=? where emp_id=?",
                dto.getEmpName(),
                dto.getEmpRole(),
                dto.getEmpSalary(),
                dto.getEmpAddress(),
                dto.getEmpNum(),
                dto.getEmpMail(),
                dto.getEmpId()
        );

    }

    public boolean delete(String employeeId) throws SQLException {
        return SQLUtil.execute("delete from employee where emp_id=?", employeeId);
    }

    public EmployeeDTO findEmpById(String employeeId) throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from employee where emp_id=?", employeeId);

        if (rst.next()) {
            return new EmployeeDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
        }
        return null;
    }

    public ArrayList<String> getAllEmployIds() throws SQLException {

        ResultSet rst = SQLUtil.execute("select emp_id from employee"), selectedEmpId;
        ArrayList<String> employIds = new ArrayList<>();

        while (rst.next()) {
            employIds.add(rst.getString(1));
        }
        return employIds;
    }

}
