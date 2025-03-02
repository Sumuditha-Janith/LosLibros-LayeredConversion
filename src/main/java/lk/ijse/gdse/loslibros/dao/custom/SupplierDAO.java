package lk.ijse.gdse.loslibros.dao.custom;

import lk.ijse.gdse.loslibros.dao.CrudDAO;
import lk.ijse.gdse.loslibros.dto.SupplierDTO;
import lk.ijse.gdse.loslibros.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<Supplier> {

    ArrayList<String> getAllSupplierIds() throws SQLException;

    SupplierDTO findSupplierById(String selectedSupplierId) throws SQLException;

}
