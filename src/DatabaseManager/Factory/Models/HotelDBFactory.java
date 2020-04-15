package DatabaseManager.Factory.Models;

import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Factory.IModelDB;
import Models.HotelModel;

public class HotelDBFactory extends ModelDBFactory<HotelModel> implements IModelDB<HotelModel> {
    @Override
    public HotelModel findByParameters(String... parameters) throws Exception {
        return null;
    }

    @Override
    protected HotelModel resultSetToModel(HotelModel item) throws Exception {
        return null;
    }
}
