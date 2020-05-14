package Models;

public class RoomModel implements IModel {

    private int roomID;
    private int hotelID;
    private String roomName;
    private double price;
    private String Description;
    private int roomType;

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

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
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
