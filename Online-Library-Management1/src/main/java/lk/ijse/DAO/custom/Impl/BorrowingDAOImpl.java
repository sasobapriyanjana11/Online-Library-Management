package lk.ijse.DAO.custom.Impl;

import lk.ijse.DAO.custom.BorrowingDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Book;
import lk.ijse.entity.BorrowBook;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BorrowingDAOImpl implements BorrowingDAO {
    @Override
    public long save(BorrowBook dto) throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();

        return (long) session.save(dto);
    }

    @Override
    public boolean update(BorrowBook dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return false;
    }

    @Override
    public BorrowBook search(String id) throws SQLException {
        return null;
    }

    @Override
    public List<BorrowBook> getAll() throws SQLException {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public String getNewBorrowingId() throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String lastBorrowId = null;
        Query<String> query = session.createQuery("select max(b.borrowId) from BorrowBook b", String.class);
        List<String> resultList = query.getResultList();

        if (resultList != null && !resultList.isEmpty()) {
            lastBorrowId = resultList.get(0);
        }

        transaction.commit();
        session.close();

        int numericPart = 1;
        if (lastBorrowId != null && lastBorrowId.matches(".*\\d+.*")) {
            String numericStr = lastBorrowId.replaceAll("\\D+", "");
            numericPart = Integer.parseInt(numericStr) + 1;
        }

        String newBorrowId = "BRO" + String.format("%03d", numericPart);

        return newBorrowId;
    }

    @Override
    public User getUsers(long id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        User users = session.get(User.class,id);
        System.out.println("user :" + users );
        transaction1.commit();
        session.close();
        return users;
    }

    @Override
    public Book getBook(long bookId) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        Book book = session.get(Book.class,bookId);
        System.out.println("book :" + book );
        transaction1.commit();
        session.close();
        return book;
    }
}
