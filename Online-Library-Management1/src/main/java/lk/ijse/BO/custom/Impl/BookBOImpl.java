package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.BookBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.BookDAO;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    private Session session;
   BookDAO bookDAO= (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.BOOK);
   Transaction transaction;

    @Override
    public long saveBook(BookDto dto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        bookDAO.setSession(session);
        long saved =  bookDAO.save(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus()));
        transaction = session.beginTransaction();
        transaction.commit();
        if (saved>0) {
            return saved;
        }
        else {
            transaction.rollback();
            return -1L;
        }

//        return bookDAO.save(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus()));
    }

    @Override
    public boolean updateBook(BookDto dto) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        bookDAO.setSession(session);
        bookDAO.update(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus()));
        transaction = session.beginTransaction();
        transaction.commit();
        return true;

//        return bookDAO.update(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus()));
    }

    @Override
    public boolean deleteBook(long id) throws SQLException {
        session = SessionFactoryConfig.getInstance().getSession();
        bookDAO.setSession(session);
        bookDAO.delete(id);
        transaction = session.beginTransaction();
        transaction.commit();
        return true;

//        return bookDAO.delete(id);
    }

    @Override
    public BookDto searchBook(String id) throws SQLException {

        Book dto=bookDAO.search(id);
        return new  BookDto(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus());

    }

    @Override
    public List<BookDto> getAllBook() throws SQLException {
        session=SessionFactoryConfig.getInstance().getSession();
        List<BookDto> allBooks= new ArrayList<>();
        List<Book> all = bookDAO.getAll();
        for (Book b : all) {
            allBooks.add(new BookDto(b.getBookId(),b.getTitle(),b.getAuthor(),b.getGenre(),b.getAvailableStatus()));
        }
        return allBooks;





    }
}
