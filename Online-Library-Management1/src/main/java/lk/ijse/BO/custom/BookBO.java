package lk.ijse.BO.custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.dto.BookDto;

import java.sql.SQLException;
import java.util.List;

public interface BookBO extends SuperBO {
    boolean saveBook(BookDto dto) throws SQLException;


    boolean updateBook(BookDto dto) throws SQLException ;


    boolean deleteBook(String id) throws SQLException ;


    BookDto searchBook(String id) throws SQLException ;


    List<BookDto> getAllBook() throws SQLException ;
}
