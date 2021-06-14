package models.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class InformationTest {
    private Information information;
    @Before
    public void setUp() throws Exception {
        information = new Information();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getValue() {
        information.setValue("key","value");
        assertEquals(information.getValue("key"),"value");
        Map<String,String> map = new HashMap<>();
        map.put("key","value");
        information = new Information(map);
        assertEquals(information.getValue("key"),"value");
    }

    @Test
    public void setValue() {
        information = new Information();
        information.setValue("key","value");
        assertNotNull(information);
        Map<String,String> map = new HashMap<>();
        map.put("key","value");
        information = new Information(map);
        assertNotNull(information);

    }

    @Test
    public void getMap() {
        information = new Information();
        information.setValue("key","value");
        Map<String,String> testMap = information.getMap();
        assertNotNull(testMap);
        assertEquals(testMap.get("key"),"value");
        assertTrue(testMap.containsKey("key"));
        assertTrue(testMap.containsValue("value"));
        Map<String,String> map = new HashMap<>();
        map.put("key","value");
        information = new Information(map);
        assertNotNull(testMap);
        assertEquals(testMap.get("key"),"value");
        assertTrue(testMap.containsKey("key"));
        assertTrue(testMap.containsValue("value"));
    }
}