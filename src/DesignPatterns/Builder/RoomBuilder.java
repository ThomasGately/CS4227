package DesignPatterns.Builder;


import Models.RoomModel;
import Models.RoomModel.RoomType;

public class RoomBuilder implements roomInterface {

        private int roomID;
        private double price;
        private String Description;
        private RoomModel.RoomType roomType;

        /* RoomID will be added by database.
        @Override
        public void setRoomID(int roomID) {
            this.roomID = roomID;
        }

        public int getRoomID() { return this.roomID;}
        */

        @Override
        public void thePrice(double price){
            this.price = price;
        }

        public double getPrice() { return this.price ;}

        @Override
        public void theDescription(String Description){
            this.Description = Description;
        }

        public String getDescription() { return this.Description; }

        @Override
        public void theRoomType(RoomModel.RoomType roomType){
            this.roomType = roomType;
        }

        public RoomModel.RoomType getRoomType() { return this.roomType ;}

        public RoomModel getResult(){
            return new RoomModel(price, Description, roomType);
        }

}