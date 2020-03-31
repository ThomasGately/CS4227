package DatabaseManager.Repository;


public class RepositoryFactory {

    public static IRepository getRepository(DBConfig databaseConfig) {
        return new MySQLRepository(databaseConfig);
    }
}
