package database;

import identifier.IdentifierLong;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class RequestsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void  privateRequestsConstructorTest() throws Exception {
        final Constructor<?>[] constructors = Requests.class.getDeclaredConstructors();
        // check that all constructors are 'private':
        for (final Constructor<?> constructor : constructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
        // call the private constructor:
        try {
            constructors[0].setAccessible(true);
            constructors[0].newInstance((Object[]) null);

            Assert.fail("Expected IllegalStateException");
        }
        catch (IllegalStateException|IllegalAccessException | InvocationTargetException e)
        {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

}