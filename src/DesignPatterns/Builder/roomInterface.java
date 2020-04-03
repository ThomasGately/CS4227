package DesignPatterns.Builder;

import Models.RoomModel;

//Basic interface to module the builders off of.
public interface roomInterface {

    //roomID will be set by database.
    //void setRoomID(int roomID);
    void thePrice(double price);
    void theDescription(String description);
    void theRoomType(RoomModel.RoomType roomType);

}