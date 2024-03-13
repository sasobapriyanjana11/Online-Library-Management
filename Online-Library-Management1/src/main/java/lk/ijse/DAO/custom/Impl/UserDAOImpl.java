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
        session.save(user);
        transaction.commit();
        session.close();
        return true ;

    }
    @Override
    public boolean update(User user) throws SQLException {

        session = SessionFactoryConfig.getInstance().getSession();
       Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        return true;



    }
    @Override
    public boolean delete(String id) throws SQLException {
//        session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        User user=session.get(User.class,id);
//        session.delete(user);
//        transaction.commit();
//        session.close();
//        return  true;
        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("delete from user where user_id='"+id+"'",User.class).executeUpdate();

        transaction.commit();
        session.close();
        return true;
    }
    @Override
    public User search(String id) throws SQLException {

        session = SessionFactoryConfig.getInstance().getSession();
        User user = session.get(User.class,id);
        session.close();
        return user;


    }
    @Override
    public List<User> getAll() throws SQLException {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createNativeQuery("SELECT * FROM user",User.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public User getData(String Id) {
        String hql = "FROM user WHERE userName = :userName";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("userName", Id);
        return query.uniqueResult();
    }
}
