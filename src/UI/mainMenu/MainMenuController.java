package UI.mainMenu;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private JFXButton logoutButton;

    @FXML
    public void logoutButtonPushed(ActionEvent actionEvent) throws IOException {

        Parent loginPageParent = FXMLLoader.load(getClass().getResource("../Login/FXLoginView.fxml"));
        Scene loginPageScene = new Scene(loginPageParent);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(loginPageScene);
        primaryStage.show();
    }
    @FXML
    public void BookingButtonPushed(ActionEvent actionEvent) throws IOException {

        Parent BookingPageParent = FXMLLoader.load(getClass().getResource("../bookingMenu/FXBookingView.fxml"));
        Scene bookingPageScene = new Scene(BookingPageParent);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(bookingPageScene);
        primaryStage.show();
    }
}
