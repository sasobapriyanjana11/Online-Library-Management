package lk.ijse.dto.tm;

import java.time.LocalDate;

public class BorrowingBooksDetailsTm {
    private String borrowId;

    private LocalDate BorrowDate ;

    private LocalDate returnDate ;
    private double cost;
    private long bookId;

    private long userId;

    public BorrowingBooksDetailsTm(String borrowId, LocalDate borrowDate, LocalDate returnDate, double cost, long userId,long bookId) {
        this.borrowId = borrowId;
        this.BorrowDate = borrowDate;
        this.returnDate = returnDate;
        this.cost =cost;
        this.bookId = bookId;
        this.userId = userId;
    }

    public BorrowingBooksDetailsTm() {
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BorrowingBooksDetailsTM{" +
                "borrowId='" + borrowId + '\'' +
                ", BorrowDate=" + BorrowDate +
                ", returnDate=" + returnDate +
                ", cost=" + cost +
                '}';
    }
}
