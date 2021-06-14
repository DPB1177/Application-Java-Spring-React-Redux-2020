package database;

/**
 * Constants with requests for Date Base.
 */
public final class Requests {
    private Requests() {
        throw new IllegalStateException("Requests class");
    }

    // TABLE
    public static final String TABLE_NAMES = "SELECT TABLE_NAME FROM information_schema.TABLES "
            + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ?;";
    public static final String TABLE_CREATE_TIME = "SELECT CREATE_TIME FROM information_schema.TABLES "
            + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? AND TABLE_NAME = ?;";
    public static final String TABLE_TABLE_ROWS = "SELECT TABLE_ROWS FROM information_schema.TABLES "
            + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? AND TABLE_NAME = ?;";
    public static final String TABLE_AVG_ROW_LENGTH = "SELECT AVG_ROW_LENGTH FROM information_schema.TABLES "
            + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? AND TABLE_NAME = ?;";
    public static final String TABLE_VERSION = "SELECT VERSION FROM information_schema.TABLES "
            + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = ? AND TABLE_NAME = ?;";
    public static final String DDL_OF_TABLE = "SHOW CREATE TABLE ";

    // VIEW
    public static final String VIEWS = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES "
            + "WHERE TABLE_TYPE LIKE 'VIEW' AND TABLE_SCHEMA LIKE ? ;";
    public static final String DDL_OF_VIEW = "SHOW CREATE VIEW ";

    // PROCEDURE
    public static final String PROCEDURES = " SELECT ROUTINE_NAME FROM INFORMATION_SCHEMA.ROUTINES "
            + "WHERE ROUTINE_TYPE='PROCEDURE' AND ROUTINE_SCHEMA= ?;";
    public static final String DDL_OF_PROCEDURE = "SHOW CREATE PROCEDURE ";

    // FUNCTION
    public static final String FUNCTIONS = " SELECT ROUTINE_NAME FROM INFORMATION_SCHEMA.ROUTINES "
            + "WHERE ROUTINE_TYPE='FUNCTION' AND ROUTINE_SCHEMA= ?;";
    public static final String DDL_OF_FUNCTION = "SHOW CREATE FUNCTION ";

    // TRIGGER
    public static final String TRIGGERS = " SELECT TRIGGER_NAME FROM INFORMATION_SCHEMA.TRIGGERS "
            + "WHERE TRIGGER_SCHEMA = ?;";
    public static final String DDL_OF_TRIGGER = "SHOW CREATE TRIGGER ";

    // COLUMN
    public static final String COLUMN_TYPE = "SELECT DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS "
            + " WHERE  TABLE_SCHEMA = ?  AND TABLE_NAME = ?  AND COLUMN_NAME LIKE ?;";
    public static final String COLUMNS_NAME = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS "
            + " WHERE  TABLE_SCHEMA = ?  AND TABLE_NAME = ?  ;";

    // SCHEMA
    public static final String SCHEMAS_ALL = " SELECT SCHEMA_NAME as DATABASE_NAME FROM INFORMATION_SCHEMA.SCHEMATA "
            + " ORDER BY SCHEMA_NAME;";
}
