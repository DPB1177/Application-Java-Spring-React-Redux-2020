package database;

import models.data.Information;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.Assert.*;

public class DataBaseMySQLQueriesTest {
    private String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
    private String user = "root";
    private String password = "root";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getTypeOfColumnOfTable() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();

        String string = DataBaseMySQLQueries.getTypeOfColumnOfTable("sakila","city","city");
        assertEquals(string, "VARCHAR" );
    }

    @Test
    public void getTypeOfColumn() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = DataBaseMySQLQueries.getTypeOfColumn("sakila","city","city");
        assertEquals(string, "varchar" );
    }

    @Test
    public void getColumnsOfTable() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getColumnsOfTable("sakila","city"));
        assertEquals(string, "city_id city country_id last_update" );

    }

    @Test
    public void getNamesOfColumns() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getNamesOfColumns("sakila","city"));
        assertEquals(string, "city_id city country_id last_update" );
    }

    @Test
    public void getFunctionDDL() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = DataBaseMySQLQueries.getFunctionDDL("sakila","inventory_in_stock");
        assertEquals(string, "CREATE DEFINER=`root`@`localhost` FUNCTION `inventory_in_stock`(p_inventory_id INT) RETURNS tinyint(1)\n" +
                "    READS SQL DATA\n" +
                "BEGIN\n" +
                "    DECLARE v_rentals INT;\n" +
                "    DECLARE v_out     INT;\n" +
                "\n" +
                "    #AN ITEM IS IN-STOCK IF THERE ARE EITHER NO ROWS IN THE rental TABLE\n" +
                "    #FOR THE ITEM OR ALL ROWS HAVE return_date POPULATED\n" +
                "\n" +
                "    SELECT COUNT(*) INTO v_rentals\n" +
                "    FROM rental\n" +
                "    WHERE inventory_id = p_inventory_id;\n" +
                "\n" +
                "    IF v_rentals = 0 THEN\n" +
                "      RETURN TRUE;\n" +
                "    END IF;\n" +
                "\n" +
                "    SELECT COUNT(rental_id) INTO v_out\n" +
                "    FROM inventory LEFT JOIN rental USING(inventory_id)\n" +
                "    WHERE inventory.inventory_id = p_inventory_id\n" +
                "    AND rental.return_date IS NULL;\n" +
                "\n" +
                "    IF v_out > 0 THEN\n" +
                "      RETURN FALSE;\n" +
                "    ELSE\n" +
                "      RETURN TRUE;\n" +
                "    END IF;\n" +
                "END" );
    }

    @Test
    public void getFunctionsOfSchema() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getFunctionsOfSchema("sakila"));
        assertEquals(string, "get_customer_balance inventory_held_by_customer inventory_in_stock" );
    }

    @Test
    public void getProcedureDDL() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = DataBaseMySQLQueries.getProcedureDDL("sakila","film_in_stock");
        assertEquals(string, "CREATE DEFINER=`root`@`localhost` PROCEDURE `film_in_stock`(IN p_film_id INT, IN p_store_id INT, OUT p_film_count INT)\n" +
                "    READS SQL DATA\n" +
                "BEGIN\n" +
                "     SELECT inventory_id\n" +
                "     FROM inventory\n" +
                "     WHERE film_id = p_film_id\n" +
                "     AND store_id = p_store_id\n" +
                "     AND inventory_in_stock(inventory_id);\n" +
                "\n" +
                "     SELECT FOUND_ROWS() INTO p_film_count;\n" +
                "END" );
    }

    @Test
    public void getProceduresOfSchema() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getProceduresOfSchema("sakila"));
        assertEquals(string, "film_in_stock film_not_in_stock rewards_report" );

    }


    @Test
    public void getProductName() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string =DataBaseMySQLQueries.getProductName();
        assertEquals(string, "MySQL 5.7.22-log" );
    }

    @Test
    public void getSchemas() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getSchemas());
        assertNotEquals(string, "" );
    }

    @Test
    public void getAllSchemas() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getAllSchemas());
        assertNotEquals(string, "" );

    }


    @Test
    public void getAllSchemasV2() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getAllSchemasV2());
        assertNotEquals(string, "" );
    }

    @Test
    public void getTableDDL() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getTableDDL("sakila","city"));
        assertNotEquals(string, "" );

    }

    @Test
    public void getTablesOfSchema() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getTablesOfSchema("sakila"));
        assertNotEquals(string, "" );

    }

    @Test
    public void getTables() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getTables("sakila"));
        assertNotEquals(string, "" );

    }

    @Test
    public void getCreateTimeOfTable() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getCreateTimeOfTable("sakila","city"));
        assertNotEquals(string, "" );

    }


    @Test
    public void getTableRowsOfTable() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getTableRowsOfTable("sakila","city"));
        assertNotEquals(string, "" );

    }

    @Test
    public void getTableAvgRowLengthOfTable() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getTableAvgRowLengthOfTable("sakila","city"));
        assertNotEquals(string, "" );

    }


    @Test
    public void getVersionOfTable() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getVersionOfTable("sakila","city"));
        assertNotEquals(string, "" );

    }

    @Test
    public void getTriggerDDL() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getTriggerDDL("sakila","customer_create_date"));
        assertNotEquals(string, "" );
    }

    @Test
    public void getTriggers() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getTriggers("sakila"));
        assertNotEquals(string, "" );
    }

    @Test
    public void getViewDDL() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getViewDDL("sakila", "film_list"));
        assertNotEquals(string, "" );

    }

    @Test
    public void getViews() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        instance.createConnection();
        String string = String.join(" ",DataBaseMySQLQueries.getViews("sakila"));
        assertNotEquals(string, "" );

    }

    @Test
    public void privateDataBaseMySQLQueriesTest() throws Exception {
        final Constructor<?>[] constructors = DataBaseMySQLQueries.class.getDeclaredConstructors();
        // check that all constructors are 'private':
        for (final Constructor<?> constructor : constructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
        // call the private constructor:
        try {
            constructors[0].setAccessible(true);
            constructors[0].newInstance((Object[]) null);

            //Assert.fail("Expected IllegalStateException");
        } catch (IllegalStateException | IllegalAccessException | InvocationTargetException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }


}