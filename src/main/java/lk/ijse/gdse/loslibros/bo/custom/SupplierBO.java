package lk.ijse.gdse.loslibros.bo.custom;

import lk.ijse.gdse.loslibros.bo.SuperBO;
import lk.ijse.gdse.loslibros.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {

    public ArrayList<SupplierDTO> getAll() throws SQLException;

    public String getNextId() throws SQLException;

    public boolean save(SupplierDTO supplierDTO) throws SQLException;

    public boolean update(SupplierDTO supplierDTO) throws SQLException;

    public boolean delete(String supplierId) throws SQLException;

    public ArrayList<String> getAllSupplierIds() throws SQLException;

    public SupplierDTO findSupplierById(String selectedSupplierId) throws SQLException;

}
