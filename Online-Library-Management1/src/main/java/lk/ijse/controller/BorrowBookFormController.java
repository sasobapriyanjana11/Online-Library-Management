package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.custom.BorrowingBO;
import lk.ijse.BO.custom.Impl.BorrowingBOImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BorrowBookDto;
import lk.ijse.dto.tm.BorrowingBooksDetailsTm;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BorrowBookFormController {

    @FXML
    private TextField UserIdText;

    @FXML
    private Button btnPay;

    @FXML
    private Button btnViewBill;

    @FXML
    private Button btnAdd;

    @FXML
    private JFXComboBox<String> cmbBookName;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBorderId;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private AnchorPane paneBorrowBook;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TableView<BorrowingBooksDetailsTm> tblBorrow;

    @FXML
    private TextField txtBrwID;

    BorrowingBO borrowingBO = new BorrowingBOImpl();

    public void initialize() throws Exception {

            setCellValueFactory();
            loadAllBorrow();

        returnDate.setValue(LocalDate.now().plusDays(7));

        String id = borrowingBO.getNewBorrowingId();
        txtBrwID.setText(id);
        List<BookDto> allBooks =borrowingBO.searchBook();
        for (BookDto b: allBooks) {

            if (b.getAvailableStatus().equals("Available") || b.getAvailableStatus().equals("available")){
                cmbBookName.getItems().add(b.getTitle());
            }
        }
        cmbBookName.getItems().addAll();

    }


    private void setCellValueFactory() {

        colBorderId.setCellValueFactory(new PropertyValueFactory<>("borrow_id"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));


    }
    private void loadAllBorrow() {

        ObservableList<BorrowingBooksDetailsTm> obList = FXCollections.observableArrayList();

        try {
            List<BorrowBookDto> dtoList = borrowingBO.getAllBorrowing();

            for(BorrowBookDto dto : dtoList) {
                obList.add(
                        new BorrowingBooksDetailsTm(
                                dto.getBorrowId(),
                                dto.getBorrowDate(),
                                dto.getReturnDate(),
                                dto.getCost(),
                                dto.getId(),
                                dto.getBookId()

                        )
                );
            }

            tblBorrow.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        String borrowId = borrowingBO.getNewBorrowingId();
        String bookName = cmbBookName.getValue();
        String userId = UserIdText.getText();
        String bookId = borrowingBO.searchBookForName(bookName);
        LocalDate date = LocalDate.now();
        LocalDate returnDate = this.returnDate.getValue();
        Double cost = 50.0;


        boolean isAdded = borrowingBO.addBorrowing(borrowId, bookId, userId, date, returnDate,cost);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK).show();

        }
    }

    @FXML
    void btnPayOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewBillOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookNameOnAction(ActionEvent event) {

    }

}

