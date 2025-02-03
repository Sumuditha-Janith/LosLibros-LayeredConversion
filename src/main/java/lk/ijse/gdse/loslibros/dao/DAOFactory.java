package lk.ijse.gdse.loslibros.dao;

import lk.ijse.gdse.loslibros.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        CUSTOMER,
        SQL, CATEGORY, PUBLISHER, AUTHOR, SUPPLIER
    }

    public SuperDAO getDAO(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
                case SQL:
                    return new SqlDAOImpl();
                    case AUTHOR:
                        return new AuthorDAOImpl();
                        case CATEGORY:
                            return new CategoryDAOImpl();
                            case PUBLISHER:
                                return new PublisherDAOImpl();
                                case SUPPLIER:
                                    return new SupplierDAOImpl();
            default:
                return null;
        }
    }

}
