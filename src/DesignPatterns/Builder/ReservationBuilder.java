//Michal
package DesignPatterns.Builder;

import Models.ReservationModel;
import Models.RoomModel;
import java.util.ArrayList;

public class ReservationBuilder implements reservationInterface {

    private int reservationID;
    private int userID;
    private ArrayList<Integer> roomIDs;
    private double price;
    private boolean payed;
    private String arrivalDate;
    private String departureDate;

    @Override
    public void theReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    @Override
    public void theUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public void theRoomIDs(ArrayList<Integer> roomIDs) {
        this.roomIDs = roomIDs;
    }

    @Override
    public void thePrice(double price) {
        this.price = price;
    }

    @Override
    public void isPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public void theArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public void theDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public ReservationModel getResults() { return new ReservationModel();}
}
