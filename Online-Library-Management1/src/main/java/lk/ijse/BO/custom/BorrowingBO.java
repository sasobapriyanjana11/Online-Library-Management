package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BorrowBookDto;

import java.time.LocalDate;
import java.util.List;

public interface BorrowingBO extends SuperBO {
    public boolean addBorrowing(String borrowId, String bookId, String userId, LocalDate borrowDate, LocalDate returnDate, Double cost) throws Exception;
    public boolean deleteBorrowing(String id) throws Exception;
    public boolean updateBorrowing(String borrowId, long bookId, long userId, String borrowDate, String returnDate) throws Exception;
    public BorrowBookDto searchBorrowing(String id) throws Exception;
    public List<BorrowBookDto> getAllBorrowing() throws Exception;
    public String getNewBorrowingId() throws Exception;
    public List<BookDto> searchBook() throws Exception;
    String searchBookForName(String bookName);
}
