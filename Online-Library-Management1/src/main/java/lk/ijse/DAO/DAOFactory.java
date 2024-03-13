package lk.ijse.DAO;

import lk.ijse.DAO.custom.Impl.AdminDAOImpl;
import lk.ijse.DAO.custom.Impl.BookDAOImpl;
import lk.ijse.DAO.custom.Impl.BranchDAOImpl;
import lk.ijse.DAO.custom.Impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum getTypes{
        USER,BOOK,BRANCH,ADMIN
    }
    public SuperDAO getDAO(getTypes getTypes){
        switch (getTypes){
            case USER:
                return new UserDAOImpl();
            case BOOK:
                return new BookDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            case ADMIN:
                return new AdminDAOImpl();
            default:
                return  null;
        }

    }
}
