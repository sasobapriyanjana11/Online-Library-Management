package lk.ijse.DAO.custom;

import lk.ijse.DAO.CrudDAO;
import lk.ijse.entity.Book;
import lk.ijse.entity.BorrowBook;
import lk.ijse.entity.User;

public interface BorrowingDAO extends CrudDAO<BorrowBook> {
    public String getNewBorrowingId() throws Exception;
    User getUsers(long id);
    Book getBook(long bookId);
}
