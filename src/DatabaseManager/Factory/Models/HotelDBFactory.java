package DatabaseManager.Factory.Models;

import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Factory.IModelDB;
import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Repository.RepositoryFactory;
import Models.HotelModel;

public class HotelDBFactory extends ModelDBFactory<HotelModel> implements IModelDB<HotelModel> {

    public HotelDBFactory() {
        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        tableName = "hotel";
        modelInfo = "hotel_id, name, address, postcode, phone, manager_id";
        dQuery = "SELECT " + modelInfo + " " +
                "FROM "   + tableName + " ";
    }

    @Override
    public HotelModel findByParameters(String... parameters) throws Exception {
        return null;
    }

    @Override
    protected HotelModel resultSetToModel(HotelModel item) throws Exception {

        item.setHotelID(resultSet.getInt("hotel_id"));
        item.setName(resultSet.getString("name"));
        item.setAddress(resultSet.getString("address"));
        item.setPostCode(resultSet.getString("postcode"));
        item.setPhone(resultSet.getInt("phone"));
        item.setManagerID(resultSet.getInt("manager_id"));
        return item;
    }
}
