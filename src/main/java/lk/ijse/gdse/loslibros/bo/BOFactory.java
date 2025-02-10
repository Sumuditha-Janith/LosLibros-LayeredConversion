package lk.ijse.gdse.loslibros.bo;

import lk.ijse.gdse.loslibros.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType {
        CUSTOMER,AUTHOR,CATEGORY,PUBLISHER,SUPPLIER,EMPLOYEE,EMPLOYEE_PAYROLL,EMPLOYEE_LEAVE,BOOK,ORDER,ORDER_DETAILS
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
                                case EMPLOYEE:
                                    return new EmployeeBOImpl();
                                    case EMPLOYEE_PAYROLL:
                                        return new EmployeePayrollBOImpl();
                                        case EMPLOYEE_LEAVE:
                                            return new EmployeeLeaveBOImpl();
                                            case BOOK:
                                                return new BookBOImpl();
                default:
                    return null;
        }

    }
}
