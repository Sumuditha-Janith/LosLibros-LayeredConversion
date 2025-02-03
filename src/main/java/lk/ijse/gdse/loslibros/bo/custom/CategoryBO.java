package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dto.CategoryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryBO {

    public ArrayList<CategoryDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException ;

    public boolean save(CategoryDTO categoryDTO) throws SQLException ;

    public boolean update(CategoryDTO categoryDTO) throws SQLException;

    public boolean delete(String dto) throws SQLException;

}
