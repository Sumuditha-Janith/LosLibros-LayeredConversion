package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dto.AuthorDTO;
import lk.ijse.gdse.loslibros.entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthorDAO extends CrudDAO<Author> {

    ArrayList<String> getAllAuthorIds() throws SQLException;

    AuthorDTO findAuthById(String selectedAuthorId) throws SQLException;
}
