package lk.ijse.gdse.loslibros.bo;

import lk.ijse.gdse.loslibros.bo.custom.impl.*;
import lk.ijse.gdse.loslibros.dao.custom.impl.SupplierDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType {
        CUSTOMER,AUTHOR,CATEGORY,PUBLISHER,SUPPLIER
    }

    public SuperBO getSuperBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
                case AUTHOR:
                    return new AuthorBOImpl();
                    case CATEGORY:
                        return new CategoryBOImpl();
                        case PUBLISHER:
                            return new PublisherBOImpl();
                            case SUPPLIER:
                                return new SupplierBOImpl();
                default:
                    return null;
        }

    }
}
