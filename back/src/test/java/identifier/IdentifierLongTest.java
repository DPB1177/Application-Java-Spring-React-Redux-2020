package identifier;

import models.data.Information;
import models.tree.DataTree;
import models.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

public class IdentifierLongTest {

    @Before
    public void setUp() throws Exception {
        IdentifierLong.setValueLongID(0);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createID() {
        String string = IdentifierLong.createID();
        assertEquals(string, "0");
        AtomicLong atomicLong = IdentifierLong.getLongID();
        assertEquals(atomicLong.longValue(), 1);

    }

    @Test
    public void createLongID() {
        long value = IdentifierLong.createLongID();
        assertEquals(value, 0);
        AtomicLong atomicLong = IdentifierLong.getLongID();
        assertEquals(atomicLong.longValue(), 1);

    }

    @Test
    public void getLongID() {
        AtomicLong atomicLong = IdentifierLong.getLongID();
        assertEquals(atomicLong.longValue(), 0);
    }

    @Test
    public void newValueLongID() {
        IdentifierLong.newValueLongID(7);
        AtomicLong atomicLong = IdentifierLong.getLongID();
        assertEquals(atomicLong.longValue(), 8);
    }

    @Test
    public void setValueLongID() {
        IdentifierLong.setValueLongID(7);
        AtomicLong atomicLong = IdentifierLong.getLongID();
        assertEquals(atomicLong.longValue(), 7);

    }

    @Test
    public void getLastIDFromTree() {
        DataTree tree;
        tree = new DataTree();
        Information information = new Information();
        information.setValue("id", "0");
        TreeNode root = new TreeNode(information);

        information = new Information();
        information.setValue("id", "1");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "2");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "3");
        root.addChild(information);

        List<TreeNode> children = root.getChildren();
        information = new Information();
        information.setValue("id", "4");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "5");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "6");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "7");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "8");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "9");
        children.get(2).addChild(information);
        information = new Information();
        information.setValue("id", "10");
        children.get(2).addChild(information);

        List<TreeNode> child0L1 = children.get(0).getChildren();
        information = new Information();
        information.setValue("id", "11");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "12");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "13");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "14");
        child0L1.get(0).addChild(information);
        tree.addRoot(root);

        assertEquals(IdentifierLong.getLastIDFromTree(tree), 15);
        assertEquals(IdentifierLong.getLastIDFromTree(null), 0);
    }

    @Test
    public void  privateIdentifierLongConstructorTest() throws Exception {
        final Constructor<?>[] constructors = IdentifierLong.class.getDeclaredConstructors();
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
//        catch (IllegalAccessException | InvocationTargetException e){
//            e.printStackTrace();
//        }
    }
}