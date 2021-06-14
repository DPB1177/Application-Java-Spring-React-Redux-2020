package xml_dom;

import models.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;

import java.io.ByteArrayInputStream;
import java.io.StringBufferInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class ElementParserTest {
    String string = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<root alreadyClicked=\"yes\" id=\"0\" name=\"root\" nameDataBase=\"MySQL 5.7.22-log\" nameNode=\"root\">" +
            "</root>";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parseElement() {
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(string.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert document != null;
        Element root = document.getDocumentElement();
        TreeNode node = ElementParser.parseElement(root);
        assertNotNull(node);
        assertEquals(node.getData().getValue("nameDataBase"), "MySQL 5.7.22-log");
    }

    @Test
    public void  privateElementParserConstructorTest() throws Exception {
        final Constructor<?>[] constructors = ElementParser.class.getDeclaredConstructors();
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