package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.AuthorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthorBO extends SuperBO {

    ArrayList<AuthorDTO> getAll() throws SQLException;

    String getNextId() throws SQLException ;

    boolean save(AuthorDTO authorDTO) throws SQLException ;

    boolean update(AuthorDTO authorDTO) throws SQLException;

    boolean delete(String dto) throws SQLException;

    ArrayList<String> getAllAuthorIds() throws SQLException;

    AuthorDTO findAuthById(String selectedAuthorId) throws SQLException;
}
