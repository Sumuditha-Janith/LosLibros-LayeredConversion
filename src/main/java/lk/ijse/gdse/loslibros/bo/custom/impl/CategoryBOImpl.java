package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.CategoryBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.CategoryDAO;
import lk.ijse.gdse.loslibros.dto.CategoryDTO;
import lk.ijse.gdse.loslibros.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryBOImpl implements CategoryBO {

    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CATEGORY);

    @Override
    public ArrayList<CategoryDTO> getAll() throws SQLException {

            ArrayList<CategoryDTO> categoryDTOS = new ArrayList<>();
            ArrayList<Category> categories = categoryDAO.getAll();
            for (Category category : categories) {
                categoryDTOS.add(new CategoryDTO(new Category(category.getCategoryId(), category.getCategoryName())));
            }
            return categoryDTOS;
        }

    @Override
    public String getNextId() throws SQLException {
        return categoryDAO.getNextId();
    }

    @Override
    public boolean save(CategoryDTO categoryDTO) throws SQLException {

        //        return authorDAO.save(new Author(authorDTO.getAuthorId(), authorDTO.getAuthorName()));

        return categoryDAO.save(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
    }

    @Override
    public boolean update(CategoryDTO categoryDTO) throws SQLException {
        return categoryDAO.update(new Category(categoryDTO.getCategoryId(), categoryDTO.getCategoryName()));
    }

    @Override
    public boolean delete(String dto) throws SQLException {
        return categoryDAO.delete(dto);
    }
}
