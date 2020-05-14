package UI.paymentMenu;

import Facade.CreditCardFacade;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.String.valueOf;


public class paymentMenuController implements Initializable{

    @FXML
    private JFXTextField card_holder_name;
    @FXML
    private JFXTextField credit_card_number;
    @FXML
    private JFXTextField cvv_number;
    @FXML
    private Label messageLabel;
    @FXML
    private JFXComboBox expiry_month;
    @FXML
    private JFXComboBox expiry_year;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] months = {"01", "02", "03", "04",
                "05", "06", "07", "08", "09",
                "10", "11", "12"};
         expiry_month = new JFXComboBox(FXCollections.observableArrayList(months));

        int currentYear = Year.now().getValue();
        ArrayList<String> years = new ArrayList<>();
        for(int i=currentYear; i<(currentYear + 20); i++){
            years.add(Integer.toString(i));
        }

         expiry_year = new JFXComboBox(FXCollections.observableArrayList(years));
    }


    @FXML
    public void payButtonPushed(ActionEvent event) {

        String message = "";
        String cardholderToCheck = card_holder_name.getText();
        String cardNumberToCheck = credit_card_number.getText();

        if (cardholderToCheck.isEmpty() || cardNumberToCheck.isEmpty()){
            message = "Enter Credit card details!";
            messageLabel.setText(valueOf(Paint.valueOf("#d32c2c")));
        }
        else{
            CreditCardFacade cardToCheck = new CreditCardFacade(cardholderToCheck, cardNumberToCheck);
            boolean valid = cardToCheck.validateCreditCard();

            if(valid){
                message = "Credit card information are validated";
                messageLabel.setText(valueOf(Paint.valueOf("RED")));
            }
        }
        messageLabel.setText(message);

    }
}
