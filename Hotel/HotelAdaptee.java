package Hotel;

import Room.Room;
import java.util.ArrayList;
import java.util.List;

public class HotelAdaptee{
    private List availableRooms = new ArrayList<>();

    public HotelAdaptee() {
        availableRooms.add(new Room());
        availableRooms.add(new Room());
        availableRooms.add(new Room());
        availableRooms.add(new Room());
    }

    public List getAllAvailableRooms() {
        return availableRooms;
    }

    public void bookRoom(int roomNumber) {
        Room bookedRoom = availableRooms.stream()
                .filter(room -> room.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
        if(bookedRoom != null){
            availableRooms.remove(bookedRoom);
            System.out.println("Room " + roomNumber + " has been booked.");
        }else{
            System.out.println("Requested room was not available.");
        }
    }
}