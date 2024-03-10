package lk.ijse.DAO.custom.Impl;

import lk.ijse.DAO.custom.UserDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session = session;
    }


    public UserDAOImpl(){
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean save(User user) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
      Transaction transaction = session.beginTransaction();
//
//        try {
//            session.save(user);
//            transaction.commit();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            return false;
//        }finally {
//            session.close();
//        }
        session.save(user);
        transaction.commit();
        session.close();
        return true ;

    }
    @Override
    public boolean update(User user) throws SQLException {

        session = SessionFactoryConfig.getInstance().getSession();
       Transaction transaction = session.beginTransaction();
//
//        try {
//            session.update(user);
//            transaction.commit();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            return false;
//        }finally {
//            session.close();
//        }

        session.update(user);
        transaction.commit();
        session.close();
        return true;



    }
    @Override
    public boolean delete(String id) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
//
//        try {
//                User user = session.get(User.class,id);
//            session.delete(user);
//            transaction.commit();
//            return true;
//        }catch (Exception e){
//            transaction.rollback();
//            return false;
//        }finally {
//            session.close();
//        }
        User user=session.get(User.class,id);
        session.delete(user);
        transaction.commit();
        session.close();
        return  true;
    }
    @Override
    public User search(String id) throws SQLException {

        session = SessionFactoryConfig.getInstance().getSession();
        User user = session.get(User.class,id);
        session.close();
        return user;

//        User user=session.get(User.class,id);
//        return user;

    }
    @Override
    public List<User> getAll() throws SQLException {
        session =SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        String sql = "SELECT U FROM User AS U";
        Query query = session.createQuery(sql);
        List<User> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }
}
