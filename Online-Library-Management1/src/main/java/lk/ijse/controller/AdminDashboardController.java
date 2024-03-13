package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private JFXButton btnBook;

    @FXML
    private JFXButton btnBranch;

    @FXML
    private JFXButton btnUser;

    @FXML
    private Label lblBook;

    @FXML
    private Label lblBranch;

    @FXML
    private Label lblUser;

    @FXML
    private AnchorPane paneAdminDashboard;

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/book-management.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) paneAdminDashboard.getScene().getWindow();
        stage1.close();


    }

    @FXML
    void btnBranchOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/branch-management.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) paneAdminDashboard.getScene().getWindow();
        stage1.close();

    }

    @FXML
    void btnUserOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/user-management.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) paneAdminDashboard.getScene().getWindow();
        stage1.close();

    }

}

