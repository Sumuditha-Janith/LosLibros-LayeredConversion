package lk.ijse.gdse.loslibros.dao.custom.impl;

import lk.ijse.gdse.loslibros.dao.SQLUtil;
import lk.ijse.gdse.loslibros.dao.custom.SupplierDAO;
import lk.ijse.gdse.loslibros.dto.SupplierDTO;
import lk.ijse.gdse.loslibros.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {

    public ArrayList<Supplier> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from supplier");

        ArrayList<Supplier> supplierList = new ArrayList<>();

        while (rst.next()) {
            Supplier supplier = new Supplier(
                    rst.getString(1),
                    rst.getString(2)
            );
            supplierList.add(supplier);
        }
        return supplierList;
    }

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select sup_id from supplier order by sup_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("S%03d", newIdIndex);
        }
        return "S001";
    }

    public boolean save(Supplier supplier) throws SQLException {
        return SQLUtil.execute(
                "insert into supplier VALUES (?, ?)",
                supplier.getSupplierId(),
                supplier.getSupplierName()
        );
    }

    public boolean update(Supplier supplier) throws SQLException {
        return SQLUtil.execute(
                "update supplier set sup_name=? where sup_id=?",
                supplier.getSupplierName(),
                supplier.getSupplierId()
        );
    }

    public boolean delete(String supplierId) throws SQLException {
        return SQLUtil.execute("delete from supplier where sup_id=?", supplierId);
    }

    public ArrayList<String> getAllSupplierIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("select sup_id from supplier");

        ArrayList<String> supplierIds = new ArrayList<>();

        while (rst.next()) {
            supplierIds.add(rst.getString(1));
        }

        return supplierIds;
    }

    public SupplierDTO findSupplierById(String selectedSupplierId) throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from supplier where sup_id=?", selectedSupplierId);

        if (rst.next()) {
            return new SupplierDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
        }
        return null;
    }
}
