package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookBO extends SuperBO {

    ArrayList<BookDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    boolean save(BookDTO bookDTO) throws SQLException;

    boolean update(BookDTO bookDTO) throws SQLException;

    boolean delete(String bookId) throws SQLException;

    ArrayList<String> getAllBookIds() throws SQLException;

    BookDTO findBookById(String bookId) throws SQLException;

}