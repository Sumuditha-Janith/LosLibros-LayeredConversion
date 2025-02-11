package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {

    ArrayList<SupplierDTO> getAll() throws SQLException;

    String getNextId() throws SQLException;

    boolean save(SupplierDTO supplierDTO) throws SQLException;

    boolean update(SupplierDTO supplierDTO) throws SQLException;

    boolean delete(String supplierId) throws SQLException;

    ArrayList<String> getAllSupplierIds() throws SQLException;

    SupplierDTO findSupplierById(String selectedSupplierId) throws SQLException;

}
