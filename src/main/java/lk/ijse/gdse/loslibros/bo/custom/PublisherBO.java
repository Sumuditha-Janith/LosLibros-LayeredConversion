package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.PublisherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PublisherBO extends SuperBO {

    ArrayList<PublisherDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    boolean save(PublisherDTO publisherDTO) throws SQLException;

    boolean update(PublisherDTO publisherDTO) throws SQLException;

    boolean delete(String dto) throws SQLException;

    ArrayList<String> getAllPublisherIds() throws SQLException;

    PublisherDTO findPublisherById(String selectedPublisherId) throws SQLException;

}
