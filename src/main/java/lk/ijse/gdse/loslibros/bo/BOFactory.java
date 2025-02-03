package lk.ijse.gdse.loslibros.bo;

import lk.ijse.gdse.loslibros.bo.custom.impl.AuhtorBOmpl;
import lk.ijse.gdse.loslibros.bo.custom.impl.CustomerBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType {
        CUSTOMER,AUTHOR
    }

    public SuperBO getSuperBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
                case AUTHOR:
                    return new AuhtorBOmpl();
                default:
                    return null;
        }

    }
}
