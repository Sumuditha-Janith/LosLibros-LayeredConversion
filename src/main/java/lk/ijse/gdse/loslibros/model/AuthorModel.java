package lk.ijse.gdse.loslibros.model;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dto.AuthorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorModel {

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
