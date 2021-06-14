package xml_dom;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TagNodeNamesTest {
    @Test
    public void privateTagNodeNamesConstructorTest() throws Exception {
        final Constructor<?>[] constructors = TagNodeNames.class.getDeclaredConstructors();
        // check that all constructors are 'private':
        for (final Constructor<?> constructor : constructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
        // call the private constructor:
        try {
            constructors[0].setAccessible(true);
            constructors[0].newInstance((Object[]) null);

            Assert.fail("Expected IllegalStateException");
        } catch (IllegalStateException | IllegalAccessException | InvocationTargetException e) {
            Assert.assertNotEquals("", e.getMessage());
        }

    }
}