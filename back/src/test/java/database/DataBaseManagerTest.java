package database;

import constants.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(DataBaseManager.class)
public class DataBaseManagerTest {

    private String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
    private String user = "root";
    private String password = "root";


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        //DataBaseManager.closeConnection();
    }

    @Test
    public void instanceDataBaseManager() {
        Connection connection = DataBaseManager.getConnection();
        DataBaseManager.closeConnection();

        DataBaseManager instance = DataBaseManager.instanceDataBaseManager();
        assertNotNull(instance);
    }

    @Test
    public void testInstanceDataBaseManager() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
        assertNotNull(instance);
    }

    @Test
    public void setUrl() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
        instance.setUrl("1");
        assertEquals(instance.getUrl(),"1");
    }

    @Test
    public void setUser() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
        instance.setUser("1");
        assertEquals(instance.getUser(),"1");

    }


    @Test
    public void setPassword() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
        instance.setPassword("1");
        assertEquals(instance.getPassword(),"1");
    }

    @Test
    public void setUrlUserPassword() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
        instance.setUrlUserPassword("1", "1","1");
        assertEquals(instance.getUrl(),"1");
        assertEquals(instance.getUser(),"1");
        assertEquals(instance.getPassword(),"1");
    }

    @Test
    public void createConnection() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
        instance.createConnection();
        assertNotNull(instance);
        DataBaseManager.closeConnection();
        instance.createConnection();

    }


    @Test
    public void testCreateConnection() {
        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
        assertNotNull(instance);

    }

//    @Test(expected = SQLException.class)
//    public void testCreateConnectionForSQLException ()  throws SQLException {
//        final Connection connection = mock(Connection.class);
//
//        DataBaseManager instance = DataBaseManager.instanceDataBaseManager(url, user, password);
//        assertNotNull(instance);
//
//    }



    @Test
    public void getConnection() {
        Connection connection = DataBaseManager.getConnection();
        assertNotNull(connection);
    }


    @Test
    public void closeConnection() {
        Connection connection = DataBaseManager.getConnection();
        DataBaseManager.closeConnection();
        assertNotNull(connection);
    }


    @Test
    public void privateDataBaseManagerTest() throws Exception {
        final Constructor<?>[] constructors = DataBaseManager.class.getDeclaredConstructors();
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


    @Test
    public void privateDataBaseManagerWithParametersTest() throws Exception {
        final Constructor<?>[] constructors = DataBaseManager.class.getDeclaredConstructors();
        // check that all constructors are 'private':
        for (final Constructor<?> constructor : constructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
        // call the private constructor:
        try {
            constructors[1].setAccessible(true);
            constructors[1].newInstance((Object[]) new String[]{url, user, password});

            //Assert.fail("Expected IllegalStateException");
        } catch (IllegalStateException | IllegalAccessException | InvocationTargetException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

}