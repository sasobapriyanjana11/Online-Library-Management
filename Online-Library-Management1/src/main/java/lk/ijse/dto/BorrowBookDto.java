package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBookDto {
    private String borrowId;
    private LocalDate BorrowDate;
    private LocalDate returnDate;
    private double cost;
    private long id;
    private long bookId;



    @Override
    public String toString() {
        return "BorrowingBooksDetailDto{" +
                "borrowId='" + borrowId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", id='" + id + '\'' +
                ", BorrowDate=" + BorrowDate +
                ", returnDate=" + returnDate +
                ", cost=" + cost +
                '}';
    }
}
