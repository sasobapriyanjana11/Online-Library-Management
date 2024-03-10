package lk.ijse.DAO.custom.Impl;

import lk.ijse.DAO.custom.BookDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
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
    public boolean save(Book book) throws SQLException {

        session.save(book);
        return true ;
    }

    @Override
    public boolean update(Book book) throws SQLException {

        session.update(book);
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        session.delete(id);
        return  true;
    }

    @Override
    public Book search(String id) throws SQLException {
        Book book=session.get(Book.class,id);
        return book;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        String sql = "SELECT B FROM book AS B";
        Query query = session.createQuery(sql);
        List<Book> list = query.list();
        session.close();
        return list;

    }


}
