package lk.ijse.gdse.loslibros.bo.custom.impl;

import lk.ijse.gdse.loslibros.bo.custom.SupplierBO;
import lk.ijse.gdse.loslibros.dao.DAOFactory;
import lk.ijse.gdse.loslibros.dao.custom.SupplierDAO;
import lk.ijse.gdse.loslibros.dto.SupplierDTO;
import lk.ijse.gdse.loslibros.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SUPPLIER);

    public ArrayList<SupplierDTO> getAll() throws SQLException {
        ArrayList<SupplierDTO> supplierDTOS = new ArrayList<>();
        ArrayList<Supplier> suppliers = supplierDAO.getAll();
        for (Supplier supplier : suppliers) {
            supplierDTOS.add(new SupplierDTO(new Supplier(supplier.getSupplierId(), supplier.getSupplierName())));
        }
        return supplierDTOS;
    }

    public String getNextId() throws SQLException {
        return supplierDAO.getNextId();
    }

    public boolean save(SupplierDTO supplierDTO) throws SQLException {
        return supplierDAO.save(new Supplier(supplierDTO.getSupplierId(), supplierDTO.getSupplierName()));
    }

    public boolean update(SupplierDTO supplierDTO) throws SQLException {
        return supplierDAO.update(new Supplier(supplierDTO.getSupplierId(), supplierDTO.getSupplierName()));
    }

    public boolean delete(String supplierId) throws SQLException {
        return supplierDAO.delete(supplierId);
    }
}
