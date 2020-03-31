package Models;

import java.util.ArrayList;

public class ReservationModel implements IModel {

    private int reservationID;
    private int userID;
    private ArrayList<Integer> RoomIDs;
    private double price;
    private boolean payed;
    private String arrivalDate;
    private String departureDate;

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public ArrayList<Integer> getRoomIDs() {
        return RoomIDs;
    }

    public void setRoomIDs(ArrayList<Integer> roomIDs) {
        RoomIDs = roomIDs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}
