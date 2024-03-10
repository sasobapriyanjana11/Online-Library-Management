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

public class UserLoginController {

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

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(this.getClass().getResource("/view/registration-form.fxml"));
        Scene scene=new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) paneLogin.getScene().getWindow();
        stage1.close();
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


