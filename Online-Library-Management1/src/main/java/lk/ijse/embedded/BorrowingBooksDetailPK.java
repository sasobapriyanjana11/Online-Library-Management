package lk.ijse.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BorrowingBooksDetailPK implements Serializable {
    @Column(name = "userId")
    private long userId;

    @Column(name = "bookId")
    private long bookId;

    public BorrowingBooksDetailPK() {
    }

    public BorrowingBooksDetailPK(long userId, long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BorrowingBooksDetailPK{" +
                "userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
