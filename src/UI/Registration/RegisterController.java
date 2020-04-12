package UI.Registration;

import Facade.RegisterFacade;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML
    private JFXTextField emailAddress;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField suranme;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label labelMessage;
    @FXML
    private JFXTextField mobileNumber;
    @FXML
    private JFXRadioButton maleButton;
    @FXML
    private JFXRadioButton femaleButton;
    @FXML
    private JFXButton backButton;

    private String messageDisplayed = "";

    public void registerButtonPushed(ActionEvent actionEvent) {

        boolean validRegister = false;
        labelMessage.setTextFill(Paint.valueOf("#d32c2c"));

        if (firstName.getText().isEmpty() || suranme.getText().isEmpty() || emailAddress.getText().isEmpty() || password.getText().isEmpty() || mobileNumber.getText().isEmpty()) {
            messageDisplayed = "All fields are required!";
        }
        else {

            RegisterFacade reg = new RegisterFacade(firstName.getText(), suranme.getText(), emailAddress.getText(), password.getText(), mobileNumber.getText());

             validRegister = reg.register();

            if(validRegister){
                messageDisplayed = "Registered Successfully!";
                labelMessage.setTextFill(Paint.valueOf("#40F272"));
            }
            else
            {
                messageDisplayed = "One of the fields is not Valid!";
            }
        }
        labelMessage.setText(messageDisplayed);
    }

    public void backButtonPushed(ActionEvent actionEvent) throws IOException {

        Parent loginPageParent = FXMLLoader.load(getClass().getResource("../Login/FXLoginView.fxml"));
        Scene loginPageScene = new Scene(loginPageParent);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(loginPageScene);
        primaryStage.show();

    }
}
