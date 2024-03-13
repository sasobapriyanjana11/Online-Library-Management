package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.UserRegisterBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.UserDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class UserRegisterBOImpl implements UserRegisterBO {
    private final UserDAO userDAO= (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.USER);

    private Session session;
    private Transaction transaction;
    @Override
    public boolean saveUser(UserDto userDto) throws SQLException {
        session= SessionFactoryConfig.getInstance().getSession();
        userDAO.setSession(session);
        boolean isSaved=userDAO.save(new User(userDto.getUserId(),userDto.getUserName(),userDto.getPassword(),userDto.getEmail()));
        transaction=session.beginTransaction();
        if(isSaved){
            transaction.commit();

            return true;
        }else{
            transaction.rollback();

            return  false;
        }
    }

    @Override
    public boolean Register(UserDto dto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        userDAO.setSession(session);
        boolean saved = userDAO.save(new User(dto.getUserId(),dto.getUserName(),dto.getPassword(),dto.getEmail()));
        transaction = session.beginTransaction();
        if (saved ) {
            transaction.commit();

        }
        else {
            transaction.rollback();
        }
        return saved;
    }
}
