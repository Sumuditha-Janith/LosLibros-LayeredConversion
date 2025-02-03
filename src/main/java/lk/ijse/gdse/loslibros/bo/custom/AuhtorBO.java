package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.AuthorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AuhtorBO extends SuperBO {

    public ArrayList<AuthorDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException ;

    public boolean save(AuthorDTO authorDTO) throws SQLException ;

    public boolean update(AuthorDTO authorDTO) throws SQLException;
    public boolean delete(String dto) throws SQLException;
}
