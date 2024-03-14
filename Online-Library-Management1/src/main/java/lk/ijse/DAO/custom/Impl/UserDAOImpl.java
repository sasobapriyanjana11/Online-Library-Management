package lk.ijse.DAO.custom.Impl;

import lk.ijse.DAO.custom.UserDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
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
    public long save(User user) throws SQLException {
//        session = SessionFactoryConfig.getInstance().getSession();
//      Transaction transaction = session.beginTransaction();
//        session.save(user);
//        transaction.commit();
//        session.close();
//        return true ;
      return (long) session.save(user);


    }
    @Override
    public boolean update(User user) throws SQLException {

//        session = SessionFactoryConfig.getInstance().getSession();
//       Transaction transaction = session.beginTransaction();
//        session.update(user);
//        transaction.commit();
//        session.close();
//        return true;

       session.update(user);
       return true;

    }
    @Override
    public boolean delete(long id) throws SQLException {

//        Session session = SessionFactoryConfig.getInstance().getSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        session.createNativeQuery("delete from user where user_id='"+id+"'",User.class).executeUpdate();
//
//        transaction.commit();
//        session.close();
//        return true;

         User data = session.get(User.class, id);
         session.delete(data);
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

//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        List<User> list = session.createNativeQuery("SELECT * FROM user",User.class).list();
//        transaction.commit();
//        session.close();
//        return list;

        String sql = "SELECT U FROM User AS U";
        Query queue = session.createQuery(sql);
        return (ArrayList<User>) queue.list();
    }

    @Override
    public User getData(String Id) {
        String hql = "FROM user WHERE userName = :userName";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("userName", Id);
        return query.uniqueResult();
    }
}
