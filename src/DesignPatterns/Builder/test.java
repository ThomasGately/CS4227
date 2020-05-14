package DesignPatterns.Builder;


import Models.RoomModel;
import org.junit.Test;

public class test {

    @Test
    public void roomBuilderTest(){

        //Creates a Director which is in charge of picking which builder to use to create which object.
        RoomBuilderDirector testRoomBuilderDirector = new RoomBuilderDirector();
        assert(testRoomBuilderDirector != null);

        //The director would usually get the Builder object from the client based on input.
        RoomBuilder testRoomBuilder = new RoomBuilder();
        assert(testRoomBuilder != null);

        //Method that calls the addNormalRoom to a specific builder
        testRoomBuilderDirector.addNormalRoom(testRoomBuilder);

        //Checking object was created correctly.
        assert(testRoomBuilder.getDescription().contentEquals("This is a normal room"));

        //This statement returns an room as it was created inside the builder.
        RoomModel roomModel = testRoomBuilder.getResult();

        assert (roomModel.getDescription().contentEquals("This is a normal room"));


    }
}
