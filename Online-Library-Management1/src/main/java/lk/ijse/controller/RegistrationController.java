package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
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
import lk.ijse.BO.custom.Impl.UserBOImpl;
import lk.ijse.BO.custom.UserBO;
import lk.ijse.dto.UserDto;


import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class RegistrationController {

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<Object, Object> colEmail;

    @FXML
    private TableColumn<Object, Object> colName;

    @FXML
    private TableColumn<Object, Object> colPassword;

    @FXML
    private TableColumn<Object, Object> colUserId;

    @FXML
    private AnchorPane paneRegistration;

    @FXML
    private TableView<UserDto> tableRegistration;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtUserName;

    UserBO userBO=new UserBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllUser();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        txtUserName.setText("");
        txtUserId.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        long id= Long.parseLong((txtUserId.getText()));
        try {

            boolean isDeleted=userBO.deleteUser(String.valueOf(id));
            if(isDeleted){
                tableRegistration.refresh();
                new Alert(Alert.AlertType.CONFIRMATION,"User deleted successfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isValidated=ValidateUser();
        if(isValidated){
            new Alert(Alert.AlertType.CONFIRMATION, "successfully added").show();

            long User_Id= Long.parseLong((txtUserId.getText()));
            String user_name=txtUserName.getText();
            String password=txtPassword.getText();
            String email=txtEmail.getText();

            UserDto dto=new UserDto(User_Id,user_name,password,email);

            try {

                boolean isSaved=userBO.saveUser(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Saved").showAndWait();
                    loadAllUser();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        boolean isValidated=ValidateUser();
        if(isValidated) {

            long User_Id= Long.parseLong((txtUserId.getText()));
            String user_name=txtUserName.getText();
            String password=txtPassword.getText();
            String email=txtEmail.getText();

            UserDto  dto=new UserDto(User_Id,user_name,password,email);

            try {

                boolean isUpdated=userBO.updateUser(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User is Updated").showAndWait();
                    loadAllUser();

                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "User details are incorrect,can't update").show();
        }


    }

    private boolean ValidateUser(){
        String id=txtUserId.getText();
        boolean isUserIdValidated= Pattern.matches("[0-9]{3,}",id);

        String userName=txtUserName.getText();
        boolean isUserNameValidated=Pattern.matches("[A-Za-z]+",userName);



        if(!isUserIdValidated){
            new Alert(Alert.AlertType.ERROR,"invalid user id").show();
            txtUserId.requestFocus();
            return false;
        }
        else if(!isUserNameValidated){
            new Alert(Alert.AlertType.ERROR,"invalid user name").show();
            txtUserName.requestFocus();
            return false;
        }

        else{
            return true;
        }
    }

    private void setCellValueFactory() {

        colUserId.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("user_password"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("user_email"));



    }

    private void loadAllUser() {

        ObservableList<UserDto> obList = FXCollections.observableArrayList();

        try {

            List<UserDto> dtoList=userBO.getAllUser();

            for(UserDto dto : dtoList) {
                obList.add(
                        new UserDto(
                                dto.getUserId(),
                                dto.getUserName(),
                                dto.getPassword(),
                                dto.getEmail()

                        )
                );
            }
            tableRegistration.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserIdOnAction(ActionEvent event) {

    }
    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

}


