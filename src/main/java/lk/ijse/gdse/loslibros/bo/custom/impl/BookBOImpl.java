package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.BookBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.BookDAO;
import lk.ijse.gdse.loslibros.dto.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookBOImpl implements BookBO {

    BookDAO bookDAO = (BookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.BOOK);

    @Override
    public ArrayList<BookDTO> getAll() throws SQLException {
        return bookDAO.getAll();
    }

    @Override
    public String getNextId() throws SQLException {
        return bookDAO.getNextId();
    }

    @Override
    public boolean save(BookDTO bookDTO) throws SQLException {
        return bookDAO.save(bookDTO);
    }

    @Override
    public boolean update(BookDTO bookDTO) throws SQLException {
        return bookDAO.update(bookDTO);
    }

    @Override
    public boolean delete(String bookId) throws SQLException {
        return bookDAO.delete(bookId);
    }

    public boolean reduceQty(String bookId, int quantity) throws SQLException {
        return bookDAO.reduceQty(bookId, quantity);
    }

    public ArrayList<String> getAllBookIds() throws SQLException {
        return bookDAO.getAllBookIds();
    }

    public BookDTO findBookById(String bookId) throws SQLException {
        return bookDAO.findBookById(bookId);
    }
}