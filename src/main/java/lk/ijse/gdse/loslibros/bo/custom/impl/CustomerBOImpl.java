package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.CustomerBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.CustomerDAO;
import lk.ijse.gdse.loslibros.dto.CustomerDTO;
import lk.ijse.gdse.loslibros.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException {

        ArrayList<CustomerDTO> customers = new ArrayList<>();
        ArrayList<Customer> customerDTOs = customerDAO.getAll();
        for (Customer customerDTO : customerDTOs) {
            customers.add(new CustomerDTO(new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),customerDTO.getCustomerPhone())));
        }
        return customers;
    }

    public String getNextCustomerId() throws SQLException {
        return customerDAO.getNextId();

    }
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException {
        return customerDAO.save(new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),customerDTO.getCustomerPhone()));


    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException {
        return customerDAO.update(new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),customerDTO.getCustomerPhone()));

    }

    public boolean deleteCustomer(String customerId) throws SQLException {
        return customerDAO.delete(customerId);

    }

}
