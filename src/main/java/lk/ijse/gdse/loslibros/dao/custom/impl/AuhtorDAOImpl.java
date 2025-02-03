package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.AuthorDAO;
import lk.ijse.gdse.loslibros.dto.AuthorDTO;
import lk.ijse.gdse.loslibros.entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuhtorDAOImpl implements AuthorDAO {

    public ArrayList<Author> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from author");

        ArrayList<Author> authorDTOS = new ArrayList<>();

        while (rst.next()) {
            Author authorDTO = new Author(
                    rst.getString(1),
                    rst.getString(2)

            );
            authorDTOS.add(authorDTO);
        }
        return authorDTOS;

    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select au_id from author order by au_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("A%03d", newIdIndex);
        }
        return "A001";
    }

    public boolean save(Author authorDTO) throws SQLException {
        return SQLUtil.execute(
                "insert into author VALUES (?,?)",
                authorDTO.getAuthorId(),
                authorDTO.getAuthorName()
        );
    }

    public boolean update(Author authorDTO) throws SQLException {
        return SQLUtil.execute(
                "update author set au_name=? where au_id=?",
                authorDTO.getAuthorName(),
                authorDTO.getAuthorId()
        );

    }

    public boolean delete(String dto) throws SQLException {
        return SQLUtil.execute("delete from author where au_id=?", dto);
    }

    public ArrayList<String> getAllAuthorIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("select au_id from author");

        ArrayList<String> authorIds = new ArrayList<>();

        while (rst.next()) {
            authorIds.add(rst.getString(1));
        }

        return authorIds;
    }

    public AuthorDTO findAuthById(String selectedAuthorId) throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from author where au_id=?", selectedAuthorId);

        if (rst.next()) {
            return new AuthorDTO(
                    rst.getString(1),
                    rst.getString(2)

            );
        }
        return null;
    }
}
