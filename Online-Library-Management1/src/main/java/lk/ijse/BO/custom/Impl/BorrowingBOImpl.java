package lk.ijse.BO.custom.Impl;

import lk.ijse.BO.custom.BorrowingBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.BookDAO;
import lk.ijse.DAO.custom.BorrowingDAO;
import lk.ijse.DAO.custom.BranchDAO;
import lk.ijse.DAO.custom.UserDAO;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BorrowBookDto;
import lk.ijse.entity.Book;
import lk.ijse.entity.BorrowBook;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowingBOImpl implements BorrowingBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.BOOK);
    BorrowingDAO borrowingDAO = (BorrowingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.BORROWING);
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.USER);
    BranchDAO branchDAO = (BranchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.getTypes.BRANCH);
    @Override
    public boolean addBorrowing(String borrowId, String bookId, String userId, LocalDate borrowDate, LocalDate returnDate, Double cost) throws Exception {
//        Book book = bookDAO.getBook(bookId);
//        User user = userDAO.getData(userId);
//
//        if (borrowingDAO.save(new BorrowBook(borrowId,book,user,borrowDate,returnDate,cost))) {
//
//            Branch branch = branchDAO.getBranch(String.valueOf(book.getBranch().getBranchId()));
//            book.setAvailableStatus("unAvailable");
//            return bookDAO.update(new Book(book.getBookId(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getAvailableStatus(),branch));
//
//        } else {
//            return false;
//        }
        return false;
    }

    @Override
    public boolean deleteBorrowing(String id) throws Exception {
        return false;
    }

    @Override
    public boolean updateBorrowing(String borrowId, long bookId, long userId, String borrowDate, String returnDate) throws Exception {
        return false;
    }

    @Override
    public BorrowBookDto searchBorrowing(String id) throws Exception {
        return null;
    }

    @Override
    public List<BorrowBookDto> getAllBorrowing() throws Exception {
        List<BorrowBookDto> allBook= new ArrayList<>();
        List<BorrowBook> all = borrowingDAO.getAll();
        for (BorrowBook b: all) {

            System.out.println(b.getCost());
            allBook.add(new BorrowBookDto(
                    b.getBorrowId(),
                    b.getBorrowDate(),
                    b.getReturnDate(),
                    b.getCost(),
                    b.getUser().getUserId(),
                    b.getBook().getBookId()
            ));


        }
        return allBook;
    }

    @Override
    public String getNewBorrowingId() throws Exception {
        String id = borrowingDAO.getNewBorrowingId();
        return id;
    }

    @Override
    public List<BookDto> searchBook() throws Exception {
        List<BookDto> allBook= new ArrayList<>();
        List<Book> all = bookDAO.getAll();
        for (Book b: all) {

            System.out.println(b.getAuthor());
            allBook.add(new BookDto(
                    b.getBookId(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getGenre(),
                    b.getAvailableStatus(),
                    b.getBranch().getBranchId()));
        }
        return allBook;
    }

    @Override
    public String searchBookForName(String bookName) {
        String id = bookDAO.searchBookForName(bookName);
        return id;
    }
}
