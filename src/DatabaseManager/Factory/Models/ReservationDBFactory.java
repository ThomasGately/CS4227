package DatabaseManager.Factory.Models;

import DatabaseManager.Factory.IModelDB;
import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Repository.RepositoryFactory;
import Models.ReservationModel;

import java.sql.SQLException;

public class ReservationDBFactory extends ModelDBFactory<ReservationModel> implements IModelDB<ReservationModel> {

    public ReservationDBFactory() {

        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        tableName = "booking";
        modelInfo = "booking_id, user_id, , booking_date, check_in_date, " +
                "check_out_date, number_of_nights, price, payed";
        dQuery = "SELECT " + modelInfo + " " +
                 "FROM "   + tableName + " ";
    }

    @Override
    public boolean add(ReservationModel item) {

        query = "INSERT INTO " + tableName +
                " (" + modelInfo + ") " +
                "VALUES (" + item.toString() + ");";
        try{
            repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        for (int roomID: item.getRoomIDs()) {
            query = "INSERT INTO room_booking (room booking)" +
                    "VALUES ('" + roomID + "', '" + item.getReservationID() + "');";
            try{
                repository.queryDatabaseStatement(query);
            } catch (Exception ex){
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public ReservationModel findById(int id) throws Exception {

        return null;
        /*
        query = "SELECT b.booking_id as ------ " +
                "FROM booking b " +
                "JOIN room_booking rb on (b.booking_id = rb.booking_id) " +
                "JOIN room r on (rb.room_id = r.room_id) " +
                "WHERE booking_id = " + id + ";";
        try{
            resultSet = repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return resultSetToModel(clazz.newInstance());
         */
    }

    @Override
    public boolean existInDB(String... parameters) {

        query = "SELECT * " +
                "FROM booking b " +
                "JOIN room_booking rb on (b.booking_id = rb.booking) " +
                "JOIN room r on (rb.room = r.room_id) " +
                "WHERE check_in_date > '" + parameters[0] +
                "' OR check_out_date < '" + parameters[1] + "';";

        resultSet = repository.queryDatabaseStatement(query);

        try {
            return resultSet.next();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ReservationModel findByParameters(String... parameters) {
        return null;
    }

    @Override
    protected ReservationModel resultSetToModel(ReservationModel item) {
        return null;
    }
}
