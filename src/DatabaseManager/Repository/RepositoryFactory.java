package DatabaseManager.Repository;

import DatabaseManager.DBConfig;
import DatabaseManager.Repository.MySQLRepository;
import DatabaseManager.Repository.IRepository;


public class RepositoryFactory {

    public static IRepository getRepository(DBConfig databaseConfig) {
        return new MySQLRepository(databaseConfig);
    }
}
