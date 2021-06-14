package database;

// import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class for organizing a queries to a database and obtaining a result.
 */
public final class DataBaseManager {
    // private static final Logger log = Logger.getLogger(DataBaseManager.class);
    private static DataBaseManager instance;
    private static Connection connection = null;
//    private String url = "jdbc:mysql://localhost:3306/?useUnicode=true"
//            + "&useJDBCCompliantTimezoneShift=true"
//            + "&useLegacyDatetimeCode=false"
//            + "&serverTimezone=UTC";

    private String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
    private String user = "root";
    private String password = "root";

    private DataBaseManager() {
        createConnection();
    }

    private DataBaseManager(String url, String user, String password) {
        if (!createConnection(url, user, password)){
            connection = null;
        };

    }

    /**
     * The static method returns an instance of this class. Singleton pattern.
     *
     * @return DataBaseManager.
     */
    public static synchronized DataBaseManager instanceDataBaseManager() {
        if (instance == null) {
            instance = new DataBaseManager();
        }
        return instance;
    }


    /**
     * The static method returns an instance of this class. Singleton pattern.
     *
     * @return DataBaseManager.
     */
    public static synchronized DataBaseManager instanceDataBaseManager(String url, String user, String password) {
        if (instance == null) {
            instance = new DataBaseManager(url, user, password);
        }
        return instance;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Set parameters for Connection.
     *
     * @param url      String.
     * @param user     String.
     * @param password String.
     */
    public void setUrlUserPassword(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Returns a DataBase connection.
     */
    public void createConnection() {
        boolean connectIsClosed = false;
        if (connection != null) {
            try {
                // Returns 'true' if connection is closed.
                connectIsClosed = connection.isClosed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection == null || connectIsClosed) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(url, user, password);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a DataBase connection.
     */
    public boolean createConnection(String url, String user, String password) {
        setUrlUserPassword(url, user, password);
        boolean connectIsClosed = false;
        if (connection != null) {
            try {
                // Returns 'true' if connection is closed.
                connectIsClosed = connection.isClosed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection == null || connectIsClosed) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(url, user, password);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    public static Connection getConnection() {
        return connection;
    }

    /**
     * Close the given connection.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
