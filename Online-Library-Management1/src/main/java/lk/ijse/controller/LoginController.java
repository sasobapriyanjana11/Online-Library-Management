package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.custom.AdminBO;
import lk.ijse.BO.custom.Impl.AdminBOImpl;
import lk.ijse.BO.custom.Impl.UserBOImpl;
import lk.ijse.BO.custom.Impl.UserLoginBOImpl;
import lk.ijse.BO.custom.UserBO;
import lk.ijse.BO.custom.UserLoginBO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController<aName> implements Initializable {

    @FXML
    private CheckBox AdminCheckBox;

    @FXML
    private CheckBox UserCheckBox;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnViewPass;

    @FXML
    private Label lblCreateAccount;

    @FXML
    private AnchorPane paneLogin;

    @FXML
    private PasswordField PasswordFild;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    Boolean flag = false;

    UserBO userBO = new UserBOImpl();
    AdminBO adminBO=new AdminBOImpl();
    UserLoginBO userLoginBO=new UserLoginBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            txtPassword.setVisible(false);
    }


    @FXML
    void btnLogOutOnAction(MouseEvent event) {

    }



    @FXML
    void btnViewPassOnAction(ActionEvent event) {
        String Password = PasswordFild.getText();
        String TExtPass = txtPassword.getText();

        if ( flag == false ){
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

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        if (UserCheckBox.isSelected()){
            User_login();
        } else if (AdminCheckBox.isSelected()) {
            Admin_Login();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Please select User or Admin").show();
        }

    }

    public static String AdminName="";
    private void Admin_Login() throws IOException {
        boolean loggedIn=adminBO.getData(txtUserName.getText(),PasswordFild.getText());
        if(loggedIn){
            AdminName=txtUserName.getText();
            Parent root= FXMLLoader.load(this.getClass().getResource("/view/adminDashboard-form.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) paneLogin.getScene().getWindow();
            stage1.close();


        }
    }

    public static String Username = "";
    private void User_login() throws IOException {
        boolean loggedIn = userLoginBO.Login(txtUserName.getText(), PasswordFild.getText());
        if(loggedIn){
           Username= txtUserName.getText();
            Parent root= FXMLLoader.load(this.getClass().getResource("/view/UserDashboard.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) paneLogin.getScene().getWindow();
            stage1.close();

        }else{
            new Alert(Alert.AlertType.ERROR,"input wrong login details,try again!").showAndWait();
        }
    }

    @FXML
    void createAccountOnAction(MouseEvent event) throws IOException {
        //create user to register

        if (UserCheckBox.isSelected()){
            User_Register();
        } else if (AdminCheckBox.isSelected()) {
            Admin_Register();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Please select User or Admin").show();
        }


    }



    private void Admin_Register() {
        try{
            Parent root= FXMLLoader.load(this.getClass().getResource("/view/adminRegistration-form.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) paneLogin.getScene().getWindow();
            stage1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void User_Register() {
        try{
            Parent root= FXMLLoader.load(this.getClass().getResource("/view/userRegistration-form.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) paneLogin.getScene().getWindow();
            stage1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }


}



