package com.example.school_management_system;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private JFXButton btnDash;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private Button btnCompute;

    @FXML
    private ChoiceBox<String> chComputeOp = new ChoiceBox<>();

    @FXML
    private Label labDisplay;

    @FXML
    private TextField txtScore_1;

    @FXML
    private TextField txtScore_2;

    @FXML
    private JFXButton btnProg;


    @FXML
    private Button btnLogin;

    @FXML
    private JFXButton btnRatings;

    @FXML
    private JFXButton btnShutdown;

    @FXML
    private Label labDisplay_2;


    @FXML
    private JFXButton btnHome;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;
    Alert message = new Alert(Alert.AlertType.INFORMATION);
    Stage stage = new Stage();

    @FXML
    void On_Login(ActionEvent event) throws IOException {
        String actualName = "admin";
        String actualPass = "12345";
        String enteredName = txtUsername.getText();
        String enteredPass = txtPassword.getText();
        if (actualName.equals(enteredName) && actualPass.equals(enteredPass)){
            message.setTitle("Message");
            message.setContentText("Successfully logged in");
            message.show();
            btnLogin.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home_1.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 777, 445);
            stage.setTitle("Home Page");
            stage.setScene(scene);
            stage.show();

        }else{
            message.setTitle("Message");
            message.setContentText("invalid detail, please try again");
            message.show();
            txtUsername.setText("");
            txtPassword.setText("");
        }

    }
    @FXML
    void On_Dash(ActionEvent event) throws IOException {
        btnDash.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 888, 500);
        stage.setTitle("WELCOME!");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    void On_Logout(ActionEvent event) throws IOException {
        btnLogout.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 643, 440);
        stage.setTitle("WELCOME!");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    void On_Prog(ActionEvent event) throws IOException {
        btnProg.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Programs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1164, 636);
        stage.setTitle("Explore!");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    void On_Home(ActionEvent event) throws IOException {
        btnHome.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home_1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 777, 445);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    void on_Shutdown(ActionEvent event) {
        Platform.exit();
    }


    public void on_Ratings(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Compute_Results.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 666, 393);
        stage.setTitle("Ratings");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    public void On_Compute(ActionEvent event) {
        //computation variables
        double Addition;
        double Subtraction;
        double Multiplication;
        double Division;
        //getting the first number and the second number
        double firstNum = Double.parseDouble(txtScore_1.getText());
        double secondNum = Double.parseDouble(txtScore_2.getText());

        Addition = firstNum + secondNum;
        Subtraction = firstNum - secondNum;
        Multiplication = firstNum * secondNum;
        Division = firstNum/secondNum;
        double computation = 0;
        //checking choiceBox to perform computations
        if (chComputeOp.getSelectionModel().getSelectedIndex() == 1){
            computation = Addition;
        } else if (chComputeOp.getSelectionModel().getSelectedIndex() == 2) {
            computation = Subtraction;
        } else if (chComputeOp.getSelectionModel().getSelectedIndex()== 3) {
            computation = Multiplication;
        } else if (chComputeOp.getSelectionModel().getSelectedIndex() == 4) {
            computation = Division;
        }else {
            labDisplay.setText("None selected");
        }
        //displaying the results
        labDisplay.setTextFill(Color.WHITE);
        labDisplay.setText(String.valueOf(computation));
        labDisplay_2.setTextFill(Color.WHITE);
        if (computation ==100){
            labDisplay_2.setText("A: Distinction");
        } else if (computation < 100 && computation >=80  ) {
            labDisplay_2.setText("A: Excellent");
        } else if (computation <80 && computation >= 70) {
            labDisplay_2.setText("B: Very Good");
        } else if (computation < 70 && computation >= 60) {
            labDisplay_2.setText("C: Credit");
        } else if (computation < 60 && computation > 50) {
            labDisplay_2.setText("D: Passed");
        }else {
            labDisplay_2.setText("Failed");
        }

        txtScore_1.setText("");
        txtScore_2.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chComputeOp.getItems().addAll("Select Math Operator", "Addition", "Subtraction", "Multiplication",
                "Division");
        chComputeOp.getSelectionModel().select("Select Math Operator");

    }

}
