package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Supplier;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SupplierDTO {

    private String supplierId;
    private String supplierName;

    public SupplierDTO(Supplier supplier) {
        this.supplierId = supplier.getSupplierId();
        this.supplierName = supplier.getSupplierName();
    }
}
