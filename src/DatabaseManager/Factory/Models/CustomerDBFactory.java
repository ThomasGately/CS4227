package DatabaseManager.Factory.Models;

import DatabaseManager.Repository.DBConfig;
import DatabaseManager.Factory.IModelDB;
import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.RepositoryFactory;
import Models.CustomerModel;

public class CustomerDBFactory extends ModelDBFactory<CustomerModel> implements IModelDB<CustomerModel> {

    public CustomerDBFactory() throws Exception {
        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        tableName = "customer";
        modelInfo = "user_name, first_name, last_name, address, phone, " +
                        "email_address, password, loyalty_level, membership_type";
        dQuery = "SELECT " + modelInfo + " " +
                 "FROM "   + tableName + " " +
                 "INNER JOIN customer_membership " +
                 "ON customer.membership_type = customer_membership.membership_type ";
    }

    @Override
    public CustomerModel findByParameters(String... parameters) throws Exception {
        query = "SELECT " + modelInfo + " " +
                "FROM customer " +
                "WHERE user_name = '" + parameters[0] +
                "' AND password = '" + parameters[1] + "';";
        try{
            resultSet = repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        CustomerModel customer = new CustomerModel();
        return resultSetToModel(customer);
    }

    @Override
    protected CustomerModel resultSetToModel(CustomerModel item) throws Exception {
        while (resultSet.next()){
            item.setUserName(resultSet.getString("user_name"));
            item.setFirstName(resultSet.getString("first_name"));
            item.setLastName(resultSet.getString("last_name"));
            item.setAddress(resultSet.getString("address"));
            item.setPhone(resultSet.getInt("phone"));
            item.setEmailAddress(resultSet.getString("email_address"));
            item.setPassword(resultSet.getString("password"));
            item.setLoyaltyLevel(resultSet.getInt("loyalty_level"));
            item.setMembership_type(resultSet.getInt("membership_name"));
        }
        return item;
    }
}
