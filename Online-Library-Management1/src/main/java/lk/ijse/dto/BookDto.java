package lk.ijse.dto;

public class BookDto {
    private long bookId;

    private String title;

    private String author;

    private String genre;

    private String availableStatus;

    public BookDto(){}

    public BookDto(long bookId, String title, String author, String genre, String availableStatus) {
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
        return "BookDto{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availableStatus='" + availableStatus + '\'' +
                '}';
    }
}
