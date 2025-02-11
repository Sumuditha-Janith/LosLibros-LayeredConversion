package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.CategoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryBO extends SuperBO {

    public ArrayList<CategoryDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException ;

    public boolean save(CategoryDTO categoryDTO) throws SQLException ;

    public boolean update(CategoryDTO categoryDTO) throws SQLException;

    public boolean delete(String dto) throws SQLException;

    public ArrayList<String> getAllCategoryIds() throws SQLException;

    public CategoryDTO findCategoryById(String selectedCategoryId) throws SQLException;

}
