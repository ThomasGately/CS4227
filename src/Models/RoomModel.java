package Models;

public class RoomModel implements IModel {

    public enum RoomType {
        GOOD,
        BAD;

        public static RoomType fromInteger(int x) {
            switch(x) {
                case 0:
                    return GOOD;
                case 1:
                    return BAD;
            }
            return null;
        }
    }

    private int roomID;
    private int hotelID;
    private String roomName;
    private double price;
    private String Description;
    private RoomType roomType;

    public RoomModel(){

    }

    public RoomModel(int roomID, double price, String Description, RoomType roomType){

        this.roomID = roomID;
        this.price = price;
        this.Description = Description;
        this.roomType = roomType;

    }

    public RoomModel(double price, String Description, RoomType roomType){

        this.price = price;
        this.Description = Description;
        this.roomType = roomType;

    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "'" +
                hotelID + "', '" +
                roomName + "', '" +
                price + "', '" +
                Description + "', '" +
                roomType + "'";
    }
}
