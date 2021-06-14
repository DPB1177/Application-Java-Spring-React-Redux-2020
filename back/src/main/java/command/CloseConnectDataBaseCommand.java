package command;

import database.DataBaseManager;

import java.sql.SQLException;

/**
 * CloseConnectDataBaseCommand.
 */
public class CloseConnectDataBaseCommand implements Command<Boolean> {
    @Override
    public Boolean execute() {
        DataBaseManager.closeConnection();
        try {
            return DataBaseManager.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
