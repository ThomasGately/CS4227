package DatabaseManager.Factory.Models;

import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Repository.RepositoryFactory;
import Models.CardModel;
import Models.CustomerModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDBFactory extends ModelDBFactory<CardModel> {

    public CardDBFactory() {
        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        tableName = "card";
        modelInfo = "card_type, user_id, card_name, billing_address, expiry_date, cvv_number";
        dQuery = "SELECT " + modelInfo + " " +
                 "FROM "   + tableName + " " +
                 "INNER JOIN card_type " +
                 "ON (card.card_type = card_type.card_type) ";
    }

    @Override
    public boolean existInDB(String... parameters) {
        return false;
    }

    @Override
    public CardModel findByParameters(String... parameters) {
        query = "SELECT " + modelInfo + " " +
                "FROM customer " +
                "WHERE user_name = '" + parameters[0] +
                "' AND password = '" + parameters[1] + "';";

        resultSet = repository.queryDatabaseStatement(query);
        CardModel card = new CardModel();
        try {
            if (resultSet.next()) {
                return resultSetToModel(card);
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

    @Override
    protected CardModel resultSetToModel(CardModel item) throws SQLException {
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
