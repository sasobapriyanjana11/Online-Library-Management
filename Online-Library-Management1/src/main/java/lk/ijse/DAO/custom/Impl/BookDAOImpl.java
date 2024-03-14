package lk.ijse.DAO.custom.Impl;

import lk.ijse.DAO.custom.BookDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    public BookDAOImpl(){
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public long save(Book book) throws SQLException {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(book);
//        transaction.commit();
//        session.close();
//        return true;
//

        return (long) session.save(book);

    }

    @Override
    public boolean update(Book book) throws SQLException {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        session.update(book);
//        transaction.commit();
//        session.close();
//        return true;
//
        session.update(book);
        return true;
    }

    @Override
    public boolean delete(long id) throws SQLException {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        session.createNativeQuery("delete from book where id='"+id+"'",Book.class).executeUpdate();
//
//        transaction.commit();
//        session.close();
//        return true;

        Book data = session.get(Book.class, id);
        session.delete(data);
        return true;
    }

    @Override
    public Book search(String id) throws SQLException {
        Book book=session.get(Book.class,id);
        return book;
    }

    @Override
    public List<Book> getAll() throws SQLException {

//        Session session =SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        List<Book> list = session.createNativeQuery("SELECT * FROM book", Book.class).list();
//        transaction.commit();
//        session.close();
//        return list;

        String sql = "SELECT B FROM Book AS B";
        Query queue = session.createQuery(sql);
        return (ArrayList<Book>) queue.list();

    }


}
