package Hotel;

import java.util.List;

public class HotelAdapter implements HotelTarget {

    private final HotelAdaptee hotelAdaptee;

    public HotelAdapter(HotelAdaptee hotelAdaptee) {
        this.hotelAdaptee = hotelAdaptee;
    }

    @Override
    public void printAvailableRooms() {
        List allAvailableRooms = hotelAdaptee.getAllAvailableRooms();
        System.out.println("Rooms Available:");
        allAvailableRooms.forEach(room -> System.out.println(room.getRoomNumber()));
    }

    @Override
    public void bookByRoomNumber(int roomNumber) {
        hotelAdaptee.bookRoom(roomNumber);
    }
}