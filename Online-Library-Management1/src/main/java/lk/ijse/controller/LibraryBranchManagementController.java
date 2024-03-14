package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.custom.BranchBO;
import lk.ijse.BO.custom.Impl.BranchBOImpl;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.BranchDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LibraryBranchManagementController {

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colContactInfo;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colManger;

    @FXML
    private AnchorPane paneBranch;

    @FXML
    private TableView<?> tableBranch;

    @FXML
    private TextField txtBranchId;

    @FXML
    private TextField txtContactInfo;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtManager;

    @FXML
    private TextField txtName;

    BranchBO branchBO=new BranchBOImpl();

//    public void initialize() {
//        setCellValueFactory();
//        loadAllBranch();
//
//    }
//
//    private void setCellValueFactory() {
//        colBranchId.setCellValueFactory(new PropertyValueFactory<>("branchId"));
//        colBranchName.setCellValueFactory(new PropertyValueFactory<>("branchName"));
//        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
//        colManger.setCellValueFactory(new PropertyValueFactory<>("manager"));
//        colContactInfo.setCellValueFactory(new PropertyValueFactory<>("contactInformation"));
//
//    }
//
    @FXML
    void btnClearOnAction(ActionEvent event) {
//        clearFields();

    }

    private void clearFields() {
        txtBranchId.setText("");
        txtName.setText("");
        txtLocation.setText("");
        txtManager.setText("");
        txtContactInfo.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
//       long id= Long.parseLong(txtBranchId.getText());
//       try{
//         boolean isDeleted=branchBO.deleteBranch(Long.parseLong(String.valueOf(id)))  ;
//         if(isDeleted){
//             tableBranch.refresh();
//             new Alert(Alert.AlertType.CONFIRMATION,"successfully deleted").showAndWait();
//
//         }
//
//       }catch (Exception e){new Alert(Alert.AlertType.CONFIRMATION,"successfully deleted").showAndWait();
//           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
//       }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
//        long id=Long.parseLong(txtBranchId.getText());
//        String name=txtName.getText();
//        String location=txtLocation.getText();
//        String manager=txtManager.getText();
//        String contactInfo=txtContactInfo.getText();
//
//        BranchDto dto=new BranchDto(id,name,location,manager,contactInfo);
//        try{
//
//           long isSaved=branchBO.saveBranch(dto);
//            if(isSaved >0){
//                new Alert(Alert.AlertType.CONFIRMATION,"successfully added").showAndWait();
//                loadAllBranch();
//            }
//        } catch (SQLException e) {
//            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
//        }

    }
//
//    private void loadAllBranch() {
//        tableBranch.getItems().clear();
//        ObservableList<BranchDto> items= (ObservableList<BranchDto>)tableBranch.getItems();
//        try {
//            /*Get all branches*/
//            List<BranchDto> allBranches = branchBO.getAllBranches();
//            System.out.println(allBranches);
//
//            for (BranchDto b : allBranches) {
//                items.add(new BranchDto(
//                        b.getBranchId(),
//                        b.getBranchName(),
//                        b.getLocation(),
//                        b.getManager(),
//                        b.getContactInformation()
//                ));
//                System.out.println(b.getBranchName());
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
//        long id=Long.parseLong(txtBranchId.getText());
//        String name=txtName.getText();
//        String location=txtLocation.getText();
//        String manager=txtManager.getText();
//        String contactInfo=txtContactInfo.getText();
//
//        BranchDto dto=new BranchDto(id,name,location,manager,contactInfo);
//        try{
//            boolean isUpdate=branchBO.updateBranch(dto);
//            if(isUpdate){
//                new Alert(Alert.AlertType.CONFIRMATION,"successfully updated").showAndWait();
//                loadAllBranch();
//            }
//        } catch (SQLException e) {
//            new Alert(Alert.AlertType.ERROR,e.getMessage()).showAndWait();
//        }

    }
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
//        Parent root= FXMLLoader.load(this.getClass().getResource("/view/adminDashboard-form.fxml"));
//
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//        Stage stage1 = (Stage) paneBranch.getScene().getWindow();
//        stage1.close();
    }

    @FXML
    void txtBranchIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactInfoOnAction(ActionEvent event) {

    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {

    }

    @FXML
    void txtManagerOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

}
