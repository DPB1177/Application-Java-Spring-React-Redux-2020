package loading;

import constants.Constants;
import database.DataBaseManager;
import database.DataBaseMySQLQueries;
import identifier.IdentifierLong;
import models.data.Information;

import java.util.HashMap;
import java.util.Map;

public class LoadingInformation {

    public static Information LoadingRoot() {
        // DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "root");
        map.put(Constants.KEY_NAME, "root");
        IdentifierLong.setValueLongID(0);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingSchemas() {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "schemas");
        map.put(Constants.KEY_NAME, "schemas");
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_SCHEMA_LIST, String.join(" ", DataBaseMySQLQueries.getSchemas()));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingSchema(String nameSchema) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "schema");
        map.put(Constants.KEY_NAME, nameSchema);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingTables(String nameSchema) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "tables");
        map.put(Constants.KEY_NAME, "tables");
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_TABLE_LIST, String.join(" ", DataBaseMySQLQueries.getTables(nameSchema)));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingTable(String nameSchema, String nameTable) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "table");
        map.put(Constants.KEY_NAME, nameTable);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_NAME_TABLE, nameTable);
        map.put(Constants.KEY_TABLE_CREATE_TIME, DataBaseMySQLQueries.getCreateTimeOfTable(nameSchema, nameTable));
        map.put(Constants.KEY_TABLE_TABLE_ROWS, DataBaseMySQLQueries.getTableRowsOfTable(nameSchema, nameTable));
        map.put(Constants.KEY_TABLE_AVG_ROW_LENGTH, DataBaseMySQLQueries.getTableAvgRowLengthOfTable(nameSchema, nameTable));
        map.put(Constants.KEY_TABLE_VERSION, DataBaseMySQLQueries.getVersionOfTable(nameSchema, nameTable));
        map.put(Constants.KEY_DDL_TABLE, DataBaseMySQLQueries.getTableDDL(nameSchema, nameTable));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingColumns(String nameSchema, String nameTable) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "columns");
        map.put(Constants.KEY_NAME, "columns");
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_NAME_TABLE, nameTable);
        map.put(Constants.KEY_COLUMN_LIST, String.join(" ", DataBaseMySQLQueries.getColumnsOfTable(nameSchema, nameTable)));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingColumn(String nameSchema, String nameTable, String nameColumn) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "column");
        map.put(Constants.KEY_NAME, nameColumn);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_NAME_TABLE, nameTable);
        map.put(Constants.KEY_COLUMN_TYPE_LIST, DataBaseMySQLQueries.getTypeOfColumnOfTable(nameSchema, nameTable, nameColumn));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingFunctions(String nameSchema) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "functions");
        map.put(Constants.KEY_NAME, "functions");
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_FUNCTION_LIST, String.join(" ", DataBaseMySQLQueries.getFunctionsOfSchema(nameSchema)));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingFunction(String nameSchema, String nameFunction) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "function");
        map.put(Constants.KEY_NAME, nameFunction);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_NAME_FUNCTION, nameFunction);
        map.put(Constants.KEY_DDL_FUNCTION, DataBaseMySQLQueries.getFunctionDDL(nameSchema, nameFunction));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingProcedures(String nameSchema) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "procedures");
        map.put(Constants.KEY_NAME, "procedures");
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_PROCEDURE_LIST, String.join(" ", DataBaseMySQLQueries.getProceduresOfSchema(nameSchema)));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingProcedure(String nameSchema, String nameProcedure) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "procedure");
        map.put(Constants.KEY_NAME, nameProcedure);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);

        map.put(Constants.KEY_DDL_PROCEDURE, DataBaseMySQLQueries.getProcedureDDL(nameSchema, nameProcedure));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingTriggers(String nameSchema) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "triggers");
        map.put(Constants.KEY_NAME, "triggers");
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_TRIGGER_LIST, String.join(" ", DataBaseMySQLQueries.getTriggers(nameSchema)));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingTrigger(String nameSchema, String nameTrigger) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "trigger");
        map.put(Constants.KEY_NAME, nameTrigger);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_NAME_TRIGGER, nameTrigger);
        map.put(Constants.KEY_DDL_TRIGGER, DataBaseMySQLQueries.getTriggerDDL(nameSchema, nameTrigger));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingViews(String nameSchema) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "views");
        map.put(Constants.KEY_NAME, "views");
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_VIEW_LIST, String.join(" ", DataBaseMySQLQueries.getViews(nameSchema)));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }

    public static Information LoadingView(String nameSchema, String nameView) {
        DataBaseManager.instanceDataBaseManager();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.KEY_NAME_DATA_BASE, DataBaseMySQLQueries.getProductName());
        map.put(Constants.KEY_NAME_NODE, "view");
        map.put(Constants.KEY_NAME, nameView);
        map.put(Constants.KEY_ID, IdentifierLong.createID());
        map.put(Constants.KEY_NAME_SCHEMA, nameSchema);
        map.put(Constants.KEY_NAME_VIEW, nameView);
        map.put(Constants.KEY_DDL_VIEW, DataBaseMySQLQueries.getViewDDL(nameSchema, nameView));
        map.put(Constants.KEY_ALREADY_CLICKED, "no");
        return new Information(map);
    }
}
