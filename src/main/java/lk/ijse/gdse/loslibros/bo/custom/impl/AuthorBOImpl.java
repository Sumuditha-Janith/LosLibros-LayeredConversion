package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.AuthorBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.AuthorDAO;
import lk.ijse.gdse.loslibros.dto.AuthorDTO;
import lk.ijse.gdse.loslibros.entity.Author;

import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorBOImpl implements AuthorBO {

AuthorDAO authorDAO = (AuthorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.AUTHOR);

    public ArrayList<AuthorDTO> getAll() throws SQLException {

        ArrayList<AuthorDTO> authorDTOS = new ArrayList<>();
        ArrayList<Author> authors = authorDAO.getAll();
        for (Author author : authors) {
            authorDTOS.add(new AuthorDTO(new Author(author.getAuthorId(), author.getAuthorName())));
        }
        return authorDTOS;
    }

    public String getNextId() throws SQLException {
      return   authorDAO.getNextId();
    }

    public boolean save(AuthorDTO authorDTO) throws SQLException {

        return authorDAO.save(new Author(authorDTO.getAuthorId(), authorDTO.getAuthorName()));
    }

    public boolean update(AuthorDTO authorDTO) throws SQLException {
     return authorDAO.update(new Author(authorDTO.getAuthorId(), authorDTO.getAuthorName()));
    }

    public boolean delete(String dto) throws SQLException {
        return authorDAO.delete(dto);
    }

    @Override
    public ArrayList<String> getAllAuthorIds() throws SQLException {
        return authorDAO.getAllAuthorIds();
    }

    @Override
    public AuthorDTO findAuthById(String selectedAuthorId) throws SQLException {
        return authorDAO.findAuthById(selectedAuthorId);
    }
}
