package loading;

import identifier.IdentifierLong;
import models.data.Information;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class LoadingInformationTest {
    private Information information;
    @Before
    public void setUp() throws Exception {
        information = new Information();
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void loadingRoot() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingRoot();
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(testMap.get("id"),"0");
        assertTrue(testMap.containsKey("id"));
        assertTrue(testMap.containsValue("0"));
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"root");
    }

    @Test
    public void loadingSchemas() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingSchemas();
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"schemas");
    }

    @Test
    public void loadingSchema() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingSchema("sakila");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"schema");

    }

    @Test
    public void loadingTables() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingTables("sakila");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"tables");

    }

    @Test
    public void loadingTable() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingTable("sakila","city");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"table");
    }

    @Test
    public void loadingColumns() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingColumns("sakila","city");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"columns");
    }

    @Test
    public void loadingColumn() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingColumn("sakila","city","city");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"column");
    }

    @Test
    public void loadingFunctions() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingFunctions("sakila");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"functions");
    }

    @Test
    public void loadingFunction() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingFunction("sakila", "inventory_in_stock");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"function");
    }

    @Test
    public void loadingProcedures() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingProcedures("sakila");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"procedures");
    }

    @Test
    public void loadingProcedure() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingProcedure("sakila","film_in_stock");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"procedure");
    }

    @Test
    public void loadingTriggers() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingTriggers("sakila");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"triggers");
    }

    @Test
    public void loadingTrigger() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingTrigger("sakila","customer_create_date");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"trigger");
    }

    @Test
    public void loadingViews() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingViews("sakila");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"views");
    }

    @Test
    public void loadingView() {
        IdentifierLong.newValueLongID(-1);
        information = LoadingInformation.LoadingView("sakila","film_list");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(information.getValue("id"),"0");
        assertEquals(information.getValue("nameNode"),"view");

    }
}