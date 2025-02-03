package lk.ijse.gdse.loslibros.bo;

import lk.ijse.gdse.loslibros.bo.custom.impl.AuthorBOImpl;
import lk.ijse.gdse.loslibros.bo.custom.impl.CategoryBOImpl;
import lk.ijse.gdse.loslibros.bo.custom.impl.CustomerBOImpl;
import lk.ijse.gdse.loslibros.bo.custom.impl.PublisherBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType {
        CUSTOMER,AUTHOR,CATEGORY, PUBLISHER
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
                default:
                    return null;
        }

    }
}
