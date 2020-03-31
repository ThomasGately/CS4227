package DatabaseManager.Repository;

import java.sql.*;

public interface IRepository {

    Connection getConnection() throws Exception;

    void closeConnection();

    void closeStatement() throws SQLException;

    ResultSet queryDatabaseStatement(String query);

    ResultSet queryDatabaseUpdate(String query);

    void executeStatement(String query);

    boolean executeUpdate(String query);

    //String getDriver();

    //String getURLStub();

    String getDatabaseURL();

}
