package DatabaseManager.Factory.Models;

import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Repository.RepositoryFactory;
import Models.CardModel;

import java.sql.ResultSet;

public class CardDBFactory extends ModelDBFactory<CardModel> {

    public CardDBFactory() throws Exception {
        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        tableName = "card";
        modelInfo = "card_type, user_id, card_name, billing_address, expiry_date, cvv_number";
        dQuery = "SELECT " + modelInfo + " " +
                 "FROM "   + tableName + " " +
                 "INNER JOIN card_type " +
                 "ON (card.card_type = card_type.card_type) ";
    }

    @Override
    public CardModel findByParameters(String... parameters) throws Exception {
        return null;
    }

    @Override
    protected CardModel resultSetToModel(CardModel item) throws Exception {
        while (resultSet.next()){
            item.setCardID(resultSet.getInt("card_id"));
            item.setUserID(resultSet.getInt("user_id"));
            item.setCardName(resultSet.getString("card_name"));
            item.setBillingAddress(resultSet.getString("billing_address"));
            item.setExpiryDate(resultSet.getString("expiry_date"));
            item.setCvvNumber(resultSet.getInt("cvv_number"));
            item.setCardType(resultSet.getInt("card_type"));
        }
        return item;
    }
}
