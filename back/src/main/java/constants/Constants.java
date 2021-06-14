package constants;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Constants class");
    }

    // BASIC
    public static final String KEY_ID = "id";
    public static final String KEY_NAME_DATA_BASE = "nameDataBase";
    public static final String KEY_NAME = "name";
    public static final String KEY_NAME_NODE = "nameNode";
    // SCHEMA
    public static final String KEY_SCHEMA_LIST = "schemaList";
    public static final String KEY_NAME_SCHEMA = "nameSchema";
    // TABLE
    public static final String KEY_TABLE_LIST = "tableList";
    public static final String KEY_NAME_TABLE = "nameTable";
    public static final String KEY_TABLE_CREATE_TIME = "tableCreateTime";
    public static final String KEY_TABLE_TABLE_ROWS = "tableRows";
    public static final String KEY_TABLE_AVG_ROW_LENGTH = "tableAvgRowLength";
    public static final String KEY_TABLE_VERSION = "tableVersion";
    public static final String KEY_DDL_TABLE = "createTableDLL";
    // COLUMN
    public static final String KEY_COLUMN_LIST = "columnList";
    public static final String KEY_COLUMN_TYPE_LIST = "nameColumnType";
    // FUNCTION
    public static final String KEY_FUNCTION_LIST = "functionList";
    public static final String KEY_NAME_FUNCTION = "nameFunction";
    public static final String KEY_DDL_FUNCTION = "createFunctionDLL";

    public static final String KEY_PROCEDURE_LIST = "procedureList";
    public static final String KEY_NAME_PROCEDURE = "nameProcedure";
    public static final String KEY_DDL_PROCEDURE = "createProcedureDLL";
    public static final String KEY_TRIGGER_LIST = "triggerList";
    public static final String KEY_NAME_TRIGGER = "nameTrigger";
    public static final String KEY_DDL_TRIGGER = "createTriggerDLL";
    public static final String KEY_VIEW_LIST = "viewList";
    public static final String KEY_NAME_VIEW = "nameView";
    public static final String KEY_DDL_VIEW = "createViewDLL";
    public static final String KEY_ALREADY_CLICKED = "alreadyClicked";
}
