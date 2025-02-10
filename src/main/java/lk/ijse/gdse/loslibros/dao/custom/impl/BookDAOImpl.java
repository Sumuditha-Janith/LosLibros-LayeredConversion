package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.BookDAO;
import lk.ijse.gdse.loslibros.dto.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {

    @Override
    public ArrayList<BookDTO> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM book");
        ArrayList<BookDTO> books = new ArrayList<>();

        while (rst.next()) {
            books.add(new BookDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            ));
        }
        return books;
    }

    @Override
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT b_id FROM book ORDER BY b_id DESC LIMIT 1");
        if (rst.next()) {
            String lastId = rst.getString(1);
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("B%03d", newId);
        }
        return "B001";
    }

    @Override
    public boolean save(BookDTO dto) throws SQLException {
        return SQLUtil.execute(
                "INSERT INTO book VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                dto.getBookId(),
                dto.getBookName(),
                dto.getAuthId(),
                dto.getCatId(),
                dto.getPubId(),
                dto.getSupId(),
                dto.getBookPrice(),
                dto.getBookQuantity()
        );
    }

    @Override
    public boolean update(BookDTO dto) throws SQLException {
        return SQLUtil.execute(
                "UPDATE book SET b_name = ?, au_id = ?, cat_id = ?, pub_id = ?, sup_id = ?, price = ?, qty = ? WHERE b_id = ?",
                dto.getBookName(),
                dto.getAuthId(),
                dto.getCatId(),
                dto.getPubId(),
                dto.getSupId(),
                dto.getBookPrice(),
                dto.getBookQuantity(),
                dto.getBookId()
        );
    }

    @Override
    public boolean delete(String bookId) throws SQLException {
        return SQLUtil.execute("DELETE FROM book WHERE b_id = ?", bookId);
    }

    @Override
    public boolean reduceQty(String bookId, int quantity) throws SQLException {
        return SQLUtil.execute(
                "UPDATE book SET qty = qty - ? WHERE b_id = ?",
                quantity,
                bookId
        );
    }

    @Override
    public ArrayList<String> getAllBookIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT b_id FROM book");
        ArrayList<String> bookIds = new ArrayList<>();

        while (rst.next()) {
            bookIds.add(rst.getString(1));
        }
        return bookIds;
    }

    @Override
    public BookDTO findBookById(String bookId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM book WHERE b_id = ?", bookId);

        if (rst.next()) {
            return new BookDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
        }
        return null;
    }
}