package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.CategoryDAO;
import lk.ijse.gdse.loslibros.dto.CategoryDTO;
import lk.ijse.gdse.loslibros.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAOImpl implements CategoryDAO {

    public ArrayList<Category> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from category");

        ArrayList<Category> categoryDTO = new ArrayList<>();

        while (rst.next()) {
            Category category = new Category(
                    rst.getString(1),
                    rst.getString(2)
            );
            categoryDTO.add(category);
        }
        return categoryDTO;
    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT cat_id FROM category ORDER BY cat_id DESC LIMIT 1");

        if (rst.next()) {
            String lastId = rst.getString(1);

            if (!lastId.startsWith("CT")) {
                throw new IllegalArgumentException("Unexpected ID format: " + lastId);
            }

            String substring = lastId.substring(2);

            try {
                int i = Integer.parseInt(substring);
                int newIdIndex = i + 1;

                return String.format("CT%02d", newIdIndex);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid numeric part in ID: " + lastId, e);
            }
        }

        return "CT01";
    }


    public boolean save(Category category) throws SQLException {
        return SQLUtil.execute(
                "insert into category VALUES (?, ?)",
                category.getCategoryId(),
                category.getCategoryName()
        );
    }

    public boolean update(Category category) throws SQLException {
        return SQLUtil.execute(
                "update category set cat_name=? where cat_id=?",
                category.getCategoryName(),
                category.getCategoryId()
        );
    }

    public boolean delete(String categoryId) throws SQLException {
        return SQLUtil.execute("delete from category where cat_id=?", categoryId);
    }

    public ArrayList<String> getAllCategoryIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("select cat_id from category");

        ArrayList<String> categoryIds = new ArrayList<>();

        while (rst.next()) {
            categoryIds.add(rst.getString(1));
        }

        return categoryIds;
    }

    public CategoryDTO findCategoryById(String selectedCategoryId) throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from category where cat_id=?", selectedCategoryId);

        if (rst.next()) {
            return new CategoryDTO(
                    rst.getString(1),
                    rst.getString(2)

            );
        }
        return null;
    }

}
