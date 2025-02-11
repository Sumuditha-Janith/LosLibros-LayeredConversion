package lk.ijse.gdse.loslibros.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {

    ArrayList<T> getAll() throws SQLException;

    String getNextId() throws SQLException;

    boolean save(T dto) throws SQLException;

    boolean update(T dto) throws SQLException;

    boolean delete(String dto) throws SQLException;

}
