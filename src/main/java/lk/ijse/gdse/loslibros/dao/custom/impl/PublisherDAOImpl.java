package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.PublisherDAO;
import lk.ijse.gdse.loslibros.dto.PublisherDTO;
import lk.ijse.gdse.loslibros.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherDAOImpl implements PublisherDAO {

    public ArrayList<Publisher> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from publisher");

        ArrayList<Publisher> publisherList = new ArrayList<>();

        while (rst.next()) {
            Publisher publisher = new Publisher(
                    rst.getString(1),
                    rst.getString(2)
            );
            publisherList.add(publisher);
        }
        return publisherList;
    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select pub_id from publisher order by pub_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);

            if (!lastId.startsWith("PB")) {
                throw new IllegalArgumentException("Unexpected ID format: " + lastId);
            }

            String substring = lastId.substring(2);

            try {
                int i = Integer.parseInt(substring);
                int newIdIndex = i + 1;

                return String.format("PB%02d", newIdIndex);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid numeric part in ID: " + lastId, e);
            }
        }

        return "PB01";
    }

    public boolean save(Publisher publisher) throws SQLException {
        return SQLUtil.execute(
                "insert into publisher VALUES (?, ?)",
                publisher.getPublisherId(),
                publisher.getPublisherName()
        );
    }

    public boolean update(Publisher publisher) throws SQLException {
        return SQLUtil.execute(
                "update publisher set pub_name=? where pub_id=?",
                publisher.getPublisherName(),
                publisher.getPublisherId()
        );
    }

    public boolean delete(String publisherId) throws SQLException {
        return SQLUtil.execute("delete from publisher where pub_id=?", publisherId);
    }

    public ArrayList<String> getAllPublisherIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("select pub_id from publisher");

        ArrayList<String> publisherIds = new ArrayList<>();

        while (rst.next()) {
            publisherIds.add(rst.getString(1));
        }

        return publisherIds;
    }

    public PublisherDTO findPublisherById(String selectedPublisherId) throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from publisher where pub_id=?", selectedPublisherId);

        if (rst.next()) {
            return new PublisherDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
        }
        return null;
    }
}
