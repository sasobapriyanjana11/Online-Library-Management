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

        return userDAO.save(new User(dto.getUserId(), dto.getUserName(), dto.getPassword(), dto.getEmail()));

    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException {

        return userDAO.update(new User(dto.getUserId(), dto.getUserName(), dto.getPassword(), dto.getEmail()));

    }

    @Override
    public boolean deleteUser(String id) throws SQLException {
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

    }

    @Override
    public List<UserDto> getAllUser() throws SQLException {


        List<UserDto> allUsers= new ArrayList<>();
        List<User> all = userDAO.getAll();
        for (User u : all) {
            allUsers.add(new UserDto(u.getUserId(),u.getUserName(),u.getPassword(),u.getEmail()));
        }
        return allUsers;

    }
}
