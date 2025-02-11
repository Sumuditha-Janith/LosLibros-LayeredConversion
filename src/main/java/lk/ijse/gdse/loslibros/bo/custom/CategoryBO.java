package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.CategoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryBO extends SuperBO {

    ArrayList<CategoryDTO> getAll() throws SQLException;

    String getNextId() throws SQLException ;

    boolean save(CategoryDTO categoryDTO) throws SQLException ;

    boolean update(CategoryDTO categoryDTO) throws SQLException;

    boolean delete(String dto) throws SQLException;

    ArrayList<String> getAllCategoryIds() throws SQLException;

    CategoryDTO findCategoryById(String selectedCategoryId) throws SQLException;

}
