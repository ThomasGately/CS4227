package Models;

public class RoomModel implements IModel {


    public enum RoomType {
        Good, bad
    }

    private int roomID;
    private double price;
    private String Description;
    private RoomType roomType;

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
}
