package lk.ijse.entity;

import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "bookId")
    private long bookId;
@Column(name = "title",nullable = false)
    private String title;
@Column(name="author",nullable = false)
    private String author;
@Column(name = "genre",nullable = false)
    private String genre;
@Column(name = "availableStatus")
    private String availableStatus;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin Admin;


//    @OneToMany(mappedBy = "book")
//    private List<Transaction> transactions;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "branch_id")
//    private Branch library_branches;



    public Book(){}

    public Book(long bookId, String title, String author, String genre, String availableStatus) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableStatus = availableStatus;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availableStatus='" + availableStatus + '\'' +
                '}';
    }
}
