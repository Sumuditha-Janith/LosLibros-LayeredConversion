package lk.ijse.gdse.loslibros.dao;

import lk.ijse.gdse.loslibros.dao.custom.impl.AuhtorDAOImpl;
import lk.ijse.gdse.loslibros.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.gdse.loslibros.dao.custom.impl.SqlDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        CUSTOMER,
        SQL,AUTHOR
    }

    public SuperDAO getDAO(DAOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAOImpl();
                case SQL:
                    return new SqlDAOImpl();
                    case AUTHOR:
                        return new AuhtorDAOImpl();
            default:
                return null;
        }
    }

}
