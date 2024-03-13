package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.custom.AdminRegisterBO;
import lk.ijse.BO.custom.Impl.AdminRegisterBOImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AdminRegistrationController implements Initializable {

    @FXML
    private PasswordField PasswordConfirm;

    @FXML
    private PasswordField PasswordFild;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private Label lblLogin;

    @FXML
    private AnchorPane paneAdminRegistration;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private JFXButton viewConfirmPass;

    @FXML
    private JFXButton viewPass;

    private final AdminRegisterBO adminRegisterBO=new AdminRegisterBOImpl();
    Boolean flag = false;
    Boolean flag1 = false;

    private boolean ValidateAdmin(){


        String userName=txtUserName.getText();
        boolean isUserNameValidated= Pattern.matches("[A-Za-z]+",userName);

        String email=txtEmail.getText();
        boolean isEmailValidated=Pattern.matches("([A-Za-z0-9]{3,}@[A-Za-z]{3,}\\.[A-Za-z]+)",email);

        String password=txtPassword.getText();
        boolean isPasswordValidated=Pattern.matches("([ -~]{6,20})",password);


        if(!isUserNameValidated){
            new Alert(Alert.AlertType.ERROR,"invalid user name").show();
            txtUserName.requestFocus();
            return false;
        }else if(!isEmailValidated){
            new Alert(Alert.AlertType.ERROR,"invalid email").show();
            txtEmail.requestFocus();
            return  false;
        }else if(!isPasswordValidated){
            new Alert(Alert.AlertType.ERROR,"invalid password").show();
            txtPassword.requestFocus();
            return  false;
        }

        else{
            return true;
        }
    }
    @FXML
    void btnRegisterOnAction(ActionEvent event) throws SQLException, IOException {
        boolean isValidated=ValidateAdmin();
        if (isValidated){
            if (PasswordFild.getText().equals(PasswordConfirm.getText())) {
                Register();
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Password Not Match").show();
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Invalid Input").show();
        }

    }

    private void Register() throws IOException, SQLException {
        boolean register =adminRegisterBO.Register(new AdminDto(1L,txtFullName.getText(),txtUserName.getText(),txtPassword.getText(),txtEmail.getText()));

        if (register){

            new Alert(Alert.AlertType.INFORMATION,"Admin Id is : A0"+register).show();

            Parent root= FXMLLoader.load(this.getClass().getResource("/view/Login-Form.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) paneAdminRegistration.getScene().getWindow();
            stage1.close();

        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Not Complete").show();
        }
    }

    @FXML
    void lblLoginOnAction(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/Login-Form.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) paneAdminRegistration.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void txtConfirmPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {

    }

    @FXML
    void txtFullNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

    @FXML
    void viewConfirmPassOnAction(ActionEvent event) {
        String Password = PasswordConfirm.getText();
        String TExtPass = txtConfirmPassword.getText();

        if (flag == false){
            PasswordConfirm.setVisible(false);
            txtConfirmPassword.setVisible(true);
            txtConfirmPassword.setText(Password);
            flag1 = true;
        }
        else {
            PasswordConfirm.setVisible(true);
            txtConfirmPassword.setVisible(false);
            PasswordConfirm.setText(TExtPass);
            flag1 = false;
        }

    }

    @FXML
    void viewPassOnAction(ActionEvent event) {
        String Password = PasswordFild.getText();
        String TExtPass = txtPassword.getText();

        if (flag == false){
            PasswordFild.setVisible(false);
            txtPassword.setVisible(true);
            txtPassword.setText(Password);
            flag = true;
        }
        else {
            PasswordFild.setVisible(true);
            txtPassword.setVisible(false);
            PasswordFild.setText(TExtPass);
            flag = false;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       txtPassword.setVisible(false);
       txtConfirmPassword.setVisible(false);
    }
}
