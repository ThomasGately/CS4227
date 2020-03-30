package DatabaseManager.Factory.Models;

import DatabaseManager.DBConfig;
import DatabaseManager.Factory.IModel;
import DatabaseManager.Factory.ModelFactory;
import DatabaseManager.Repository.IRepository;
import DatabaseManager.Repository.RepositoryFactory;
import Models.UserModel;

import java.sql.ResultSet;

public class UserFactory extends ModelFactory implements IModel<UserModel> {

    private IRepository repository;
    private ResultSet resultSet;
    private String query;

    @Override
    public void add(UserModel item) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public UserModel findById(int id) {
        return null;
    }

    @Override
    public UserModel findByParameters(String... parameters) throws Exception {
        resultSet = null;
        repository = RepositoryFactory.getRepository(DBConfig.getDatabaseConfig());
        query = "SELECT user_name, password, first_name, last_name, email_address, loyalty_level FROM User " +
                "WHERE user_name = '" + parameters[0] + "' AND password = '" + parameters[1] + "';";
        try{
            resultSet = repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        UserModel user = new UserModel();
        while (resultSet.next()){
            user.setUserName(parameters[0]);
            user.setPassword(parameters[1]);
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmailAddress(resultSet.getString("email_address"));
            user.setLoyaltyLevel(Integer.valueOf(resultSet.getString("loyalty_level")));
        }
        return user;
    }
}
