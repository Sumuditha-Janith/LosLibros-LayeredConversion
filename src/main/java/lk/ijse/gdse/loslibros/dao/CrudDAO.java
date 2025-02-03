package lk.ijse.gdse.loslibros.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {

    public ArrayList<T> getAll() throws SQLException;

    public String getNextId() throws SQLException;

    public boolean save(T dto) throws SQLException;

    public boolean update(T dto) throws SQLException;

    public boolean delete(String dto) throws SQLException;

}
