package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.PublisherBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.PublisherDAO;
import lk.ijse.gdse.loslibros.dto.PublisherDTO;
import lk.ijse.gdse.loslibros.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherBOImpl implements PublisherBO {

    PublisherDAO publisherDAO = (PublisherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PUBLISHER);

    public ArrayList<PublisherDTO> getAll() throws SQLException {
        ArrayList<PublisherDTO> publisherDTOS = new ArrayList<>();
        ArrayList<Publisher> publishers = publisherDAO.getAll();
        for (Publisher publisher : publishers) {
            publisherDTOS.add(new PublisherDTO(new Publisher(publisher.getPublisherId(), publisher.getPublisherName())));
        }
        return publisherDTOS;
    }
    public String getNextId() throws SQLException {
        return publisherDAO.getNextId();
    }

    public boolean save(PublisherDTO publisherDTO) throws SQLException {
        return publisherDAO.save(new Publisher(publisherDTO.getPublisherId(), publisherDTO.getPublisherName()));
    }

    public boolean update(PublisherDTO publisherDTO) throws SQLException {
        return publisherDAO.update(new Publisher(publisherDTO.getPublisherId(), publisherDTO.getPublisherName()));
    }

    public boolean delete(String dto) throws SQLException {
        return publisherDAO.delete(dto);
    }
}
