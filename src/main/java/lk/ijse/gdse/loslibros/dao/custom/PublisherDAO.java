package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.PublisherDTO;
import lk.ijse.gdse.loslibros.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PublisherDAO extends CrudDAO<Publisher> {

    ArrayList<String> getAllPublisherIds() throws SQLException;

    PublisherDTO findPublisherById(String selectedPublisherId) throws SQLException;

}
