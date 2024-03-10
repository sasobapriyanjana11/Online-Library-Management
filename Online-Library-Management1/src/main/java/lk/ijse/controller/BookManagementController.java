package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.custom.BookBO;
import lk.ijse.BO.custom.Impl.BookBOImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class BookManagementController {

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookStatus;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private AnchorPane paneBookManagement;

    @FXML
    private TableView<BookDto> tableBook;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookGenre;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookStatus;

    @FXML
    private TextField txtTitle;

    BookBO bookBO=new BookBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllBook();

    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtBookId.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtBookGenre.setText("");
        txtBookStatus.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        long id= Long.parseLong((txtBookId.getText()));
        try {

            boolean isDeleted=bookBO.deleteBook(String.valueOf(id));
            if(isDeleted){
                tableBook.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"Book details deleted successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isValidated=ValidateBook();
        if(isValidated){
            new Alert(Alert.AlertType.CONFIRMATION, "successfully added").show();

            long Id= Long.parseLong((txtBookId.getText()));
            String title=txtTitle.getText();
            String genre=txtBookGenre.getText();
            String author=txtAuthor.getText();
            String status=txtBookStatus.getText();

            BookDto dto=new BookDto(Id,title,author,genre,status);

            try {

                boolean isSaved=bookBO.saveBook(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Book Saved").showAndWait();

                    loadAllBook();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }


    }

    private boolean ValidateBook() {

        String id=txtBookId.getText();
        boolean isBookIdValidated= Pattern.matches("[0-9]{3,}+",id);

        String title=txtTitle.getText();
        boolean isTitleValidated=Pattern.matches("[A-Za-z]+",title);

        String author=txtAuthor.getText();
        boolean isAuthorValidated=Pattern.matches("[A-Za-z]+",author);

        if(!isBookIdValidated){
            return false;
        } else if (!isTitleValidated) {
            return  false;
        } else if(!isAuthorValidated){
            return false;
        }
        else {

            return true;
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        boolean isValidated=ValidateBook();
        if(isValidated) {
            long Id= Long.parseLong((txtBookId.getText()));
            String title=txtTitle.getText();
            String genre=txtBookGenre.getText();
            String author=txtAuthor.getText();
            String status=txtBookStatus.getText();

            BookDto dto=new BookDto(Id,title,author,genre,status);

            try {

                boolean isUpdated=bookBO.updateBook(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Book is Updated").showAndWait();
                    loadAllBook();

                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "Book details are incorrect,can't update").show();
        }

    }

    private void setCellValueFactory() {

        colBookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("book_title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("book's_author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("book_genre"));
        colBookStatus.setCellValueFactory(new PropertyValueFactory<>("book_availableStatus"));


    }

    private void loadAllBook() {
        ObservableList<BookDto> obList = FXCollections.observableArrayList();

        try {

            List<BookDto> dtoList=bookBO.getAllBook();

            for(BookDto dto : dtoList) {
                obList.add(
                        new BookDto(
                                dto.getBookId(),
                                dto.getTitle(),
                                dto.getGenre(),
                                dto.getAuthor(),
                                dto.getAvailableStatus()

                        )
                );
            }
            tableBook.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void tableBookOnAction(MouseEvent event) {

    }

    @FXML
    void txtAuthorOnAction(ActionEvent event) {

    }

    @FXML
    void txtBookGenreOnAction(ActionEvent event) {

    }

    @FXML
    void txtBookIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtBookStatusOnAction(ActionEvent event) {

    }

    @FXML
    void txtTitleOnAction(ActionEvent event) {

    }

}

