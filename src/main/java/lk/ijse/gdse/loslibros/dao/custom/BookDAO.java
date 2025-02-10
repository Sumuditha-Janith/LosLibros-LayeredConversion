package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDAO extends CrudDAO<BookDTO> {

    boolean reduceQty(String bookId, int quantity) throws SQLException;

    ArrayList<String> getAllBookIds() throws SQLException;

    BookDTO findBookById(String bookId) throws SQLException;
}