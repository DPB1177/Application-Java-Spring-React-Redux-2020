package command;

import database.DataBaseManager;
import java.sql.SQLException;

/**
 * CreateConnectDataBaseCommand.
 */
public class CreateConnectDataBaseCommand implements Command<Boolean> {
    private String url;
    private String user;
    private String password;
    /**
     * Constructor CreateConnectDataBaseCommand.
     *
     * @param url      String.
     * @param user     String.
     * @param password String.
     */
    public CreateConnectDataBaseCommand(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Boolean execute() {
        DataBaseManager.instanceDataBaseManager(url, user, password);
        try {
            if (DataBaseManager.getConnection() != null && !DataBaseManager.getConnection().isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
