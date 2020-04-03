package DesignPatterns.Builder;

import Models.RoomModel;

//This class holds the presets for creating rooms. **Potentially add GUI based custom function.
public class RoomBuilderDirector {

    public void addNormalRoom(RoomBuilder builder){

        builder.thePrice(50.0);
        builder.theDescription("This is a normal room");
        builder.theRoomType(RoomModel.RoomType.bad);
    }

    public void addFancyRoom(RoomBuilder builder){

        builder.thePrice(250.0);
        builder.theDescription("This is a fancy room");
        builder.theRoomType(RoomModel.RoomType.Good);
    }


}