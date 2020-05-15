package DatabaseManager.Factory.Models;

import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Factory.IModelDB;
import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.RepositoryFactory;
import Models.RoomModel;

import java.sql.SQLException;
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
    public boolean existInDB(String... parameters) {
        return false;
    }

    @Override
    public RoomModel findByParameters(String... parameters) {

        query = "SELECT room_id " +
                "FROM booking b " +
                "JOIN room_booking rb on (b.booking_id = rb.booking) " +
                "JOIN room r on (rb.room = r.room_id) " +
                "WHERE check_in_date > '" + parameters[0] +
                "' OR check_out_date < '" + parameters[1] + "';";

        resultSet = repository.queryDatabaseStatement(query);
        RoomModel room = new RoomModel();
        try {
            if (resultSet.next()) {
                room.setRoomID(resultSet.getInt("room_id"));
                return resultSetToModel(room);
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<RoomModel> findManyByParameters(String... parameters) {

        query = dQuery +
                "INNER JOIN room_booking " +
                "ON (booking.booking_id = room_booking.booking)" +
                "INNER JOIN room" +
                "ON (room_booking.room = room.room_id)" +
                "WHERE check_in_date > '" + parameters[0] + "' " +
                "OR check_out_date < '" + parameters[1] + "';";

        resultSet = repository.queryDatabaseStatement(query);
        ArrayList<RoomModel> rooms = new ArrayList<RoomModel>();

        try {
            while (resultSet.next()) {
                RoomModel room = new RoomModel();
                rooms.add(resultSetToModel(room));
            }
            return rooms;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    protected RoomModel resultSetToModel(RoomModel item) throws SQLException {

        item.setRoomID(resultSet.getInt("room_id"));
        item.setHotelID(resultSet.getInt("hotel_id"));
        item.setRoomName(resultSet.getString("name"));
        item.setPrice(resultSet.getDouble("price"));
        item.setRoomType(RoomModel.RoomType.fromInteger(resultSet.getInt("room_type")));
        return item;
    }
}

