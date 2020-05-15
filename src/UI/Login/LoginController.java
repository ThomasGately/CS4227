package UI.Login;

import DatabaseManager.Factory.ModelDBFactory;
import Facade.LoginFacade;
import Models.CustomerModel;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static DatabaseManager.Factory.ModelDBFactory.FactoryType.Customer;

public class LoginController {


    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label textDisplayed;
    @FXML
    private Hyperlink linkToRegister;
    @FXML
    private AnchorPane rootPane;


    @FXML
    public void loginButtonPushed(ActionEvent actionEvent) throws IOException {

         String message = "";
         String emailToCheck = email.getText();
         String passwordToCheck = password.getText();

         ModelDBFactory dbCustomer = ModelDBFactory.getModelDBFactory(Customer);
         CustomerModel customer = new CustomerModel();

         if (email.getText().isEmpty() || password.getText().isEmpty()){
             message = "Enter Email Address or Password";
         }
         else{

             LoginFacade newLogin = new LoginFacade(emailToCheck, passwordToCheck);
             boolean valid = newLogin.login();

             if (valid) {
                 if (dbCustomer.existInDB(email.getText(), password.getText())) {
                     message = "Logged in Successfully";

                     Parent mainMenuPageParent = FXMLLoader.load(getClass().getResource("../mainMenu/FXMainMenuView.fxml"));
                     Scene mainMenuPageScene = new Scene(mainMenuPageParent);
                     Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                     primaryStage.hide();
                     primaryStage.setScene(mainMenuPageScene);
                     primaryStage.show();
                 }
                 else {
                     message = "DB Error!";
                 }
             }
             else{
                 message = "Email or password is not valid!";
             }
         }
        this.textDisplayed.setText(message);
    }

    @FXML
    public void RegisterButtonClicked(ActionEvent actionEvent) {
        if (linkToRegister.isVisited()){
            try {
                Parent registerPageParent = FXMLLoader.load(getClass().getResource("../Registration/FXRegisterView.fxml"));
                Scene registerPageScene = new Scene(registerPageParent);
                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.hide();

                registerPageParent.setStyle("-fx-base: rgba(60, 60, 60, 255);");

                primaryStage.setScene(registerPageScene);
                primaryStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


