package DatabaseManager.Repository;

public class DBConfig {

    private static DBConfig DBConfigInstance;

    private String hostName;
    private String portNumber;
    private String databaseName;
    private String userName;
    private String password;

    public DBConfig(){

    }

    public void setDatabaseConfigInstance(DBConfig config){
        this.DBConfigInstance = config;
    }

    public static DBConfig getDatabaseConfig(){
        return DBConfigInstance;
    }

    public String getServerName() {
        return hostName;
    }

    public void setServerName(String serverName) {
        this.hostName = serverName;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
