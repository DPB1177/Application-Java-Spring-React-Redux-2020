package database.parametrs;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterForSaveXMLTest {
    private ParameterForSaveXML parameterForSaveXML;
    @Before
    public void setUp() throws Exception {
        parameterForSaveXML = new ParameterForSaveXML();
        parameterForSaveXML.setIndex_load_node(new String[]{"0", "1"});
        parameterForSaveXML.setIndex_minus(new String[]{"0", "1"});
        parameterForSaveXML.setIndex_visible_children(new String[]{"0", "1"});
        parameterForSaveXML.setIndex_zero(new String[]{"0", "1"});
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getIndex_minus() {
        String[] parameters = parameterForSaveXML.getIndex_minus();
        assertEquals(parameters[0],"0");
        assertEquals(parameters[1],"1");
    }

    @Test
    public void setIndex_minus() {
    }

    @Test
    public void getIndex_visible_children() {
        String[] parameters = parameterForSaveXML.getIndex_visible_children();
        assertEquals(parameters[0],"0");
        assertEquals(parameters[1],"1");
    }

    @Test
    public void setIndex_visible_children() {
    }

    @Test
    public void getIndex_load_node() {
        String[] parameters = parameterForSaveXML.getIndex_load_node();
        assertEquals(parameters[0],"0");
        assertEquals(parameters[1],"1");

    }

    @Test
    public void setIndex_load_node() {
    }

    @Test
    public void getIndex_zero() {
        String[] parameters = parameterForSaveXML.getIndex_zero();
        assertEquals(parameters[0],"0");
        assertEquals(parameters[1],"1");

    }

    @Test
    public void setIndex_zero() {
    }

    @Test
    public void testToString() {
        String string = parameterForSaveXML.toString();
        System.out.println(string);
        assertEquals(string,"ParameterForSaveXML{index_minus=[0, 1], index_visible_children=[0, 1], index_load_node=[0, 1], index_zero=[0, 1]}");
    }
}