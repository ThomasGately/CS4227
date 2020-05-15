package DatabaseManager.Factory.Models;

import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Factory.IModelDB;
import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.RepositoryFactory;
import Models.CustomerModel;

import java.sql.SQLException;

public class CustomerDBFactory extends ModelDBFactory<CustomerModel> implements IModelDB<CustomerModel> {

    public CustomerDBFactory() {

        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        tableName = "customer";
        modelInfo = "user_name, password, first_name, last_name, address, " +
                        "email_address, phone, loyalty_level, membership_type";
        dQuery = "SELECT " + modelInfo + " " +
                 "FROM "   + tableName + " " +
                 "INNER JOIN customer_membership " +
                 "ON customer.membership_type = customer_membership.membership_type ";
    }

    @Override
    public CustomerModel findByParameters(String... parameters) {

        query = "SELECT " + modelInfo + " " +
                "FROM customer " +
                "WHERE email_address = '" + parameters[0] +
                "' AND password = '" + parameters[1] + "';";

        resultSet = repository.queryDatabaseStatement(query);
        CustomerModel customer = new CustomerModel();
        try {
            if (resultSet.next()) {
                return resultSetToModel(customer);
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
    public boolean existInDB(String... parameters) {

        query = "SELECT email_address, password " +
                "FROM customer " +
                "WHERE email_address = '" + parameters[0] +
                "' AND password = '" + parameters[1] + "';";

        resultSet = repository.queryDatabaseStatement(query);

        try {
            if (resultSet.next()) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    protected CustomerModel resultSetToModel(CustomerModel item) throws SQLException {

        item.setUserName(resultSet.getString("user_name"));
        item.setFirstName(resultSet.getString("first_name"));
        item.setLastName(resultSet.getString("last_name"));
        item.setAddress(resultSet.getString("address"));
        item.setPhone(resultSet.getInt("phone"));
        item.setEmailAddress(resultSet.getString("email_address"));
        item.setPassword(resultSet.getString("password"));
        item.setLoyaltyLevel(resultSet.getInt("loyalty_level"));
        item.setMembership_type(resultSet.getInt("membership_name"));
        return item;
    }
}
