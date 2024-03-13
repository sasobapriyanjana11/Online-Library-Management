package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {
    @FXML
    private JFXButton btnLogin;

    @FXML
    private Label lblCreateAccount;

    @FXML
    private AnchorPane paneLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    private String name="jk";
    private String password="1234";

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String pw=txtPassword.getText();
        String Uname=txtUserName.getText();

        if(pw.equals(password) & Uname.equals(name)) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/adminDashboard-form.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) paneLogin.getScene().getWindow();
            stage1.close();
        }else{
            System.out.println("incorrect login details");
        }
    }

    @FXML
    void createAccountOnAction(MouseEvent event) {

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }
}
