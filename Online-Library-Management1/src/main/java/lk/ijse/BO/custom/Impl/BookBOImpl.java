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


    @Override
    public boolean saveBook(BookDto dto) throws SQLException {

        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookDAO.setSession(session);
            boolean isSaved = bookDAO.save(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus())); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return isSaved;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(BookDto dto) throws SQLException {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookDAO.setSession(session);
            bookDAO.update(new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus())); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(String id) throws SQLException {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookDAO.setSession(session);
            bookDAO.delete(id); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public BookDto searchBook(String id) throws SQLException {
        session=SessionFactoryConfig.getInstance().getSession();
        try{
            bookDAO.setSession(session);
           Book dto= bookDAO.search(id);
            session.close();
            return new  BookDto(dto.getBookId(), dto.getTitle(), dto.getAuthor(), dto.getGenre(),dto.getAvailableStatus());
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<BookDto> getAllBook() throws SQLException {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        bookDAO.setSession(session);
        List<Book> allBooks = bookDAO.getAll(); // Here we're getting Entity type object result
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : allBooks) {
            bookDtoList.add(new BookDto(
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getAvailableStatus()
                )
            ); // We convert the Entity back to a dto type before return to the controller
        }
        return bookDtoList;

    }
}
