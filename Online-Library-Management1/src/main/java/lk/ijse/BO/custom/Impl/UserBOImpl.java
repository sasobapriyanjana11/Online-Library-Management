package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.UserBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.UserDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    private Session session;

    UserDAO userDAO= (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.USER);


    @Override
    public boolean saveUser(UserDto dto) throws SQLException {
//        session = SessionFactoryConfig.getInstance()
//                .getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            userDAO.setSession(session);
//            boolean isSaved = userDAO.save(new User(dto.getUserId(), dto.getUserName(), dto.getPassword(), dto.getEmail())); // We pass it to the repository by converting it to an entity
//            transaction.commit();
//            session.close();
//            return isSaved;
//        } catch (Exception ex) {
//            transaction.rollback();
//            session.close();
//            ex.printStackTrace();
//            return false;
//        }

        User user= new User(dto.getUserId(), dto.getUserName(), dto.getPassword(), dto.getEmail());
        return userDAO.save(user);

        //return userDAO.save(new User(dto.getUserId(), dto.getUserName(), dto.getPassword(), dto.getEmail()));

    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException {
//        session = SessionFactoryConfig.getInstance()
//                .getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            userDAO.setSession(session);
//            userDAO.update(new User(dto.getUserId(),dto.getUserName(),dto.getPassword(),dto.getEmail())); // We pass it to the repository by converting it to an entity
//            transaction.commit();
//            session.close();
//            return true;
//        } catch (Exception ex) {
//            transaction.rollback();
//            session.close();
//            ex.printStackTrace();
//            return false;
//        }

        User user = new User(dto.getUserId(), dto.getUserName(), dto.getPassword(), dto.getEmail());
        return userDAO.update(user);
        //  return userDAO.update(new User(dto.getUserId(),dto.getUserName(),dto.getPassword(),dto.getEmail()));
    }

    @Override
    public boolean deleteUser(String id) throws SQLException {
//        session = SessionFactoryConfig.getInstance()
//                .getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            userDAO.setSession(session);
//            userDAO.delete(id); // We pass it to the repository by converting it to an entity
//            transaction.commit();
//            session.close();
//            return true;
//        } catch (Exception ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//            session.close();
//            return false;
//        }
        return userDAO.delete(id);

    }

    @Override
    public UserDto searchUser(String id) throws SQLException {
        session=SessionFactoryConfig.getInstance().getSession();
        try{
            userDAO.setSession(session);
            User user= userDAO.search(id);
            session.close();
            return new UserDto(user.getUserId(),user.getUserName(), user.getPassword(), user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
       /* User user= userDAO.search(id);
        return new UserDto(user.getUserId(),user.getUserName(), user.getPassword(), user.getEmail());
    */
    }

    @Override
    public List<UserDto> getAllUser() throws SQLException {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        userDAO.setSession(session);
        List<User> allUsers = userDAO.getAll(); // Here we're getting Entity type object result
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : allUsers) {
            userDtoList.add(new UserDto(
                    user.getUserId(),
                    user.getUserName(),
                    user.getPassword(),
                    user.getEmail()
            )
            ); // We convert the Entity back to a dto type before return to the controller
        }
        return userDtoList;

    }
}
