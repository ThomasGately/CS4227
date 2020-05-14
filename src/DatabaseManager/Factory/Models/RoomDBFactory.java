package DatabaseManager.Factory.Models;

import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Factory.IModelDB;
import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.RepositoryFactory;
import Models.RoomModel;

import java.util.ArrayList;

public class RoomDBFactory extends ModelDBFactory<RoomModel> implements IModelDB<RoomModel> {

    public RoomDBFactory() {
        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        tableName = "room";
        modelInfo = "room_id, hotel_id, name, price, description, room_type";
        dQuery = "SELECT " + modelInfo + " " +
                 "FROM "   + tableName + " " +
                 "INNER JOIN room_type " +
                 "ON (room.room_type = room_type.room_type) ";
    }

    @Override
    public RoomModel findByParameters(String... parameters) throws Exception {
        return null;
    }

    public ArrayList<RoomModel> findManyByParameters(String... parameters) throws Exception {

        query = dQuery +
                "INNER JOIN room_booking " +
                "ON (booking.booking_id = room_booking.booking)" +
                "INNER JOIN room" +
                "ON (room_booking.room = room.room_id)" +
                "WHERE check_in_date > '" + parameters[0] + "' " +
                "OR check_out_date < '" + parameters[1] + "';";
        try{
            resultSet = repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        ArrayList<RoomModel> rooms = new ArrayList<RoomModel>();
        while (resultSet.next()) {
            RoomModel room = new RoomModel();
            rooms.add(resultSetToModel(room));
        }
        return rooms;
    }

    @Override
    protected RoomModel resultSetToModel(RoomModel item) throws Exception {

        item.setRoomID(resultSet.getInt("room_id"));
        item.setHotelID(resultSet.getInt("hotel_id"));
        item.setRoomName(resultSet.getString("name"));
        item.setPrice(resultSet.getDouble("price"));
        item.setRoomType(resultSet.getInt("room_type"));
        return item;
    }
}

