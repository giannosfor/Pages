package Beans;

public class DatabaseBean {

    private static final String driver = "com.mysql.jdbc.Driver";
    private String username, password, database;

    public DatabaseBean(String usr, String pass, String dbase) {
        username = usr;
        password = pass;
        database = "jdbc:mysql://" + database + ":3306/articles";
    }

    public DatabaseBean(String usr, String pass) {
        username = usr;
        password = pass;
        database = "jdbc:mysql://localhost:3306/articles";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernmame) {
        this.username = usernmame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public static String getDriver() {
        return driver;
    }
}
