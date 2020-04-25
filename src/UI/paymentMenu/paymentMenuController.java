package UI.paymentMenu;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class paymentMenuController implements Initializable{

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
    }
}
