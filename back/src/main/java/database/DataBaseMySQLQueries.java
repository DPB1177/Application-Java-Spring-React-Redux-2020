package database;

//import database.requests.Requests;
// import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class for organizing a queries to a database and obtaining a result.
 */
public final class DataBaseMySQLQueries {
    // private static final Logger log = Logger.getLogger(DataBaseMySQLQueries.class);

    private DataBaseMySQLQueries() {
        throw new IllegalStateException("DataBaseMySQLQueries");
    }

    /**
     * Getting the type of the schema columns with the table name and with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     * @param tableName  name of Table.
     */
    public static String getTypeOfColumnOfTable(String schemaName, String tableName, String columnName) {

        ResultSet resultSet = null;
        String type = null;
        try {
            // Current connection metadata.
            DatabaseMetaData metaData = DataBaseManager.getConnection().getMetaData();
            // pull all the type of column with column with name 'columnName' from the table 'tableName' of the scheme 'schemaName'
            resultSet = metaData.getColumns(schemaName, "%", tableName, columnName);
            while (resultSet.next()) {
                type = resultSet.getString("TYPE_NAME");
            }
            // System.out.println();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    /**
     * Getting the type of the schema columns with the table name and with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     * @param tableName  name of Table.
     */
    public static String getTypeOfColumn(String schemaName, String tableName, String columnName) {
        String resultString = null;
        ResultSet result;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.COLUMN_TYPE);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            preparedStatement.setString(2, tableName);
            preparedStatement.setString(3, columnName);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                resultString = result.getString(1);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * Getting the name of the columns with the schema name 'schemaName' and the table name 'tableName'.
     *
     * @param schemaName schemaName.
     * @param tableName  tableName.
     * @return List columns.
     */
    public static List<String> getColumnsOfTable(String schemaName, String tableName) {
        List<String> resultList = new ArrayList<String>();
        ResultSet resultSet = null;
        try {
            // Current connection metadata
            DatabaseMetaData metaData = DataBaseManager.getConnection().getMetaData();
            resultSet = metaData.getColumns(schemaName, "%", tableName, "%");
            while (resultSet.next()) {
                String name = resultSet.getString("COLUMN_NAME");
                resultList.add(name);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Getting the name of the columns with the schema name 'schemaName' and the table name 'tableName'.
     *
     * @param schemaName schemaName.
     * @param tableName  tableName.
     * @return List columns.
     */
    public static List<String> getNamesOfColumns(String schemaName, String tableName) {

        List<String> resultList = new ArrayList<String>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.COLUMNS_NAME);
            // Set the values of a certain type to the desired position
            preparedStatement.setString(1, schemaName);
            preparedStatement.setString(2, tableName);
            result = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int column = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = result.getString(i);
                    resultList.add(string);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Getting DDL of Function.
     *
     * @param schemaName   schemaName.
     * @param functionName functionName.
     * @return result.
     */
    public static String getFunctionDDL(String schemaName, String functionName) {

        Statement statement = null;
        String result = null;
        ResultSet resultSet = null;
        try {
            statement = DataBaseManager.getConnection().createStatement();
            // Execute the query.
            resultSet = statement.executeQuery(Requests.DDL_OF_FUNCTION + schemaName + "." + functionName + ";");
            while (resultSet.next()) {
                result = resultSet.getString("Create Function");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Getting the name of the vies with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     */
    public static List<String> getFunctionsOfSchema(String schemaName) {
        List<String> resultList = new ArrayList<String>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.FUNCTIONS);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            result = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int column = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = result.getString(i);
                    resultList.add(string);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Getting DDL of Procedure.
     *
     * @param schemaName    schemaName.
     * @param procedureName procedureName.
     * @return result.
     */
    public static String getProcedureDDL(String schemaName, String procedureName) {

        Statement statement = null;
        String result = null;
        ResultSet resultSet = null;
        try {
            statement = DataBaseManager.getConnection().createStatement();
            // Execute the query.
            resultSet = statement.executeQuery(Requests.DDL_OF_PROCEDURE + schemaName + "." + procedureName + ";");
            while (resultSet.next()) {
                result = resultSet.getString("Create Procedure");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Getting the name of the vies with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     */
    public static List<String> getProceduresOfSchema(String schemaName) {
        List<String> resultList = new ArrayList<String>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.PROCEDURES);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            result = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int column = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = result.getString(i);
                    resultList.add(string);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Method The Product and Version Name.
     *
     * @return The string information about the product name.
     */
    public static String getProductName() {
        String productName = null;
        try {
            // Current connection metadata.
            DatabaseMetaData metaData = DataBaseManager.getConnection().getMetaData();
            productName = metaData.getDatabaseProductName();
            productName += " " + metaData.getDatabaseProductVersion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productName;
    }

    /**
     * Method that returns Schema names.
     *
     * @return List String name.
     */
    public static List<String> getSchemas() {

        List<String> resultList = new ArrayList<String>();
        ResultSet resultSet = null;
        try {
            DatabaseMetaData metaData = DataBaseManager.getConnection().getMetaData();
            resultSet = metaData.getCatalogs();
            // ResultSetMetaData to get strings
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = resultSet.getString(i);
                    // exclude system Schemas
                    if ((!string.equals("information_schema"))
                            && (!string.equals("performance_schema"))
                            && (!string.equals("mysql"))) {
                        resultList.add(string);
                    }
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            //log.error(e);
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Method that returns Schema names.
     *
     * @return List String name.
     */
    public static List<String> getAllSchemas() {

        List<String> resultList = new ArrayList<String>();
        ResultSet resultSet = null;
        try {
            DatabaseMetaData metaData = DataBaseManager.getConnection().getMetaData();
            resultSet = metaData.getCatalogs();
            // ResultSetMetaData to get strings
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = resultSet.getString(i);
                    resultList.add(string);
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Method that returns Schema names.
     *
     * @return List String name.
     */
    public static List<String> getAllSchemasV2() {
        List<String> resultList = new ArrayList<String>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.SCHEMAS_ALL);
            result = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int column = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = result.getString(i);
                    resultList.add(string);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Getting DDL of Table.
     *
     * @param schemaName schemaName.
     * @param tableName  tableName.
     * @return result.
     */
    public static String getTableDDL(String schemaName, String tableName) {

        Statement statement = null;
        String result = null;
        ResultSet resultSet = null;
        try {
            statement = DataBaseManager.getConnection().createStatement();
            resultSet = statement.executeQuery(Requests.DDL_OF_TABLE + schemaName + "." + tableName + ";");
            while (resultSet.next()) {
                result = resultSet.getString("Create Table");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Getting the name of the tables with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     */
    public static List<String> getTablesOfSchema(String schemaName) {
        List<String> resultList = new ArrayList<String>();
        ResultSet resultSet = null;
        try {
            DatabaseMetaData metaData = DataBaseManager.getConnection().getMetaData();
            String[] types = {"TABLE"};
            resultSet = metaData.getTables(schemaName, "%", "%", types);
            while (resultSet.next()) {
                String string = resultSet.getString("TABLE_NAME");
                resultList.add(string);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Getting the name of the tables with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     */
    public static List<String> getTables(String schemaName) {
        List<String> resultList = new ArrayList<String>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.TABLE_NAMES);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            result = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int column = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = result.getString(i);
                    resultList.add(string);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static String getCreateTimeOfTable(String schemaName, String tableName) {
        String resultString = null;
        ResultSet result;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.TABLE_CREATE_TIME);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            preparedStatement.setString(2, tableName);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                resultString = result.getString(1);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static String getTableRowsOfTable(String schemaName, String tableName) {
        String resultString = null;
        ResultSet result;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.TABLE_TABLE_ROWS);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            preparedStatement.setString(2, tableName);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                resultString = result.getString(1);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static String getTableAvgRowLengthOfTable(String schemaName, String tableName) {
        String resultString = null;
        ResultSet result;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.TABLE_AVG_ROW_LENGTH);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            preparedStatement.setString(2, tableName);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                resultString = result.getString(1);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static String getVersionOfTable(String schemaName, String tableName) {
        String resultString = null;
        ResultSet result;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.TABLE_VERSION);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            preparedStatement.setString(2, tableName);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                resultString = result.getString(1);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * Getting DDL of Trigger.
     *
     * @param schemaName  schemaName.
     * @param triggerName triggerName.
     * @return result.
     */
    public static String getTriggerDDL(String schemaName, String triggerName) {

        Statement statement = null;
        String result = null;
        ResultSet resultSet = null;
        try {
            statement = DataBaseManager.getConnection().createStatement();
            // Execute the query.
            resultSet = statement.executeQuery(Requests.DDL_OF_TRIGGER + schemaName + "." + triggerName + ";");
            while (resultSet.next()) {
                result = resultSet.getString("SQL Original Statement");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //log.error(e);
        }
        return result;
    }

    /**
     * Getting the name of the trigger with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     */
    public static List<String> getTriggers(String schemaName) {
        List<String> resultList = new ArrayList<String>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.TRIGGERS);
            // Set the values of a certain type to the desired position.
            preparedStatement.setString(1, schemaName);
            result = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int column = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = result.getString(i);
                    resultList.add(string);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Getting DDL of View.
     *
     * @param schemaName schemaName.
     * @param viewName   viewName.
     * @return result.
     */
    public static String getViewDDL(String schemaName, String viewName) {
        Statement statement = null;
        String result = null;
        ResultSet resultSet = null;
        try {
            statement = DataBaseManager.getConnection().createStatement();
            //System.out.println(viewName);
            //System.out.println(Requests.DDL_OF_VIEW + schemaName + "." + viewName + ";");
            resultSet = statement.executeQuery(Requests.DDL_OF_VIEW + schemaName + "." + viewName + ";");
            while (resultSet.next()) {
                result = resultSet.getString("Create View");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //log.error(e);
        }
        return result;
    }

    /**
     * Getting the name of the vies with the schema name 'schemaName'.
     *
     * @param schemaName name of Schema.
     */
    public static List<String> getViews(String schemaName) {
        List<String> resultList = new ArrayList<String>();
        ResultSet result = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DataBaseManager.getConnection().prepareStatement(Requests.VIEWS);
            preparedStatement.setString(1, schemaName);
            result = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int column = rsmd.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= column; i++) {
                    String string = result.getString(i);
                    resultList.add(string);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
