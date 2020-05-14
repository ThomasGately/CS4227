//Michal
package DesignPatterns.Builder;

import java.util.ArrayList;

public interface reservationInterface {

    void theReservationID(int reservationID);
    void theUserID(int userID);
    void theRoomIDs(ArrayList<Integer> roomIDs);
    void thePrice(double price);
    void isPayed(boolean payed);
    void theArrivalDate(String arrivalDate);
    void theDepartureDate(String departureDate);
}
