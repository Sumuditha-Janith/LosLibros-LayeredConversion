package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.CategoryDTO;
import lk.ijse.gdse.loslibros.entity.Category;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryDAO extends CrudDAO<Category> {

    public ArrayList<String> getAllCategoryIds() throws SQLException;

    public CategoryDTO findCategoryById(String selectedCategoryId) throws SQLException;

}
