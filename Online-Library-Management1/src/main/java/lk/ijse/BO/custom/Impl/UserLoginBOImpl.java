package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.UserLoginBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.UserDAO;
import lk.ijse.config.SessionFactoryConfig;
import org.hibernate.Session;

public class UserLoginBOImpl implements UserLoginBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.USER);

    private Session session;
    @Override
    public boolean Login(String Username, String Password) {
        session= SessionFactoryConfig.getInstance().getSession();
        userDAO.setSession(session);


        return false;
    }
}
