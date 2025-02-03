package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.PublisherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PublisherBO extends SuperBO {

    public ArrayList<PublisherDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException;

    public boolean save(PublisherDTO publisherDTO) throws SQLException;

    public boolean update(PublisherDTO publisherDTO) throws SQLException;

    public boolean delete(String dto) throws SQLException;

}
