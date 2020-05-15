package UI.bookingMenu;

import DatabaseManager.Factory.ModelDBFactory;
import Models.ReservationModel;
import Models.RoomModel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static DatabaseManager.Factory.ModelDBFactory.FactoryType.*;


public class BookingMenuController implements Initializable {

    @FXML
    private JFXDatePicker check_in_date;
    @FXML
    private JFXDatePicker check_out_date;
    @FXML
    private JFXComboBox<Label> roomComboBox;
    @FXML
    private JFXTextField booking_Price;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        roomComboBox.getItems().add(new Label("Standard Room"));
        roomComboBox.getItems().add(new Label("Luxury Room"));

        Callback<DatePicker, DateCell> check_in = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        LocalDate today = LocalDate.now();
                        setDisable(empty || item.compareTo(today) < 0);
                    }

                };
            }

        };

        Callback<DatePicker, DateCell> check_out = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(empty || item.compareTo(check_in_date.getValue())-1 < 0);
                    }

                };
            }

        };
        check_in_date.setDayCellFactory(check_in);
        check_out_date.setDayCellFactory(check_out);
    }
    @FXML
    public void calculatedPricePushed(ActionEvent event){
            this.booking_Price.setText("€");
    }

    @FXML
    public void bookButtonPushed(ActionEvent event) throws IOException {

        ModelDBFactory dbReservation = ModelDBFactory.getModelDBFactory(Reservation);
        ModelDBFactory dbRoom = ModelDBFactory.getModelDBFactory(Card);
        ReservationModel reservation = new ReservationModel();
        RoomModel room = new RoomModel();
        int newRoomID;

        LocalDate localDateCheckIn = check_in_date.getValue();
        LocalDate localDateCheckout = check_out_date.getValue();


        System.out.println("" + localDateCheckIn);
        System.out.println("" + localDateCheckout);

        if (dbReservation.existInDB("" + localDateCheckIn, "" + localDateCheckout)) {
            room = (RoomModel) dbRoom.findByParameters("" + localDateCheckIn, "" + localDateCheckout);

        }
        Parent PaymentPageParent = FXMLLoader.load(getClass().getResource("../paymentMenu/FXpaymentMenuView.fxml"));
        Scene PaymentPageScene = new Scene(PaymentPageParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //primaryStage.hide();
        primaryStage.setScene(PaymentPageScene);
        primaryStage.show();
    }
    @FXML
    public void CheckOutDate(ActionEvent event) {
        System.out.println(check_in_date.getValue());
    }

    @FXML
    public void ChickInCurrentDate(ActionEvent event) {

    }


}
