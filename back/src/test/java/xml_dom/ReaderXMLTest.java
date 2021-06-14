package xml_dom;

import loading.LoadingTreeWithDateBase;
import models.tree.DataTree;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;


public class ReaderXMLTest {

    @Before
    public void setUp() throws Exception {
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreWhitespace(true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readXML() throws IOException, SAXException {
        LoadingTreeWithDateBase former = new LoadingTreeWithDateBase();
        former.loadAllTree();
        DataTree tree = former.getTree();

        File fileWrite = new File("src/main/resources/xml_file_DB.xml");
        // create XML-file from object "Tree"
        WriterXML domWriterXML = new WriterXML(fileWrite, tree);
        domWriterXML.writeXML();
        File fileRead = new File("src/main/resources/xml_file_DB_reader.xml");
        ReaderXML domReaderXML = new ReaderXML(fileWrite);
        domReaderXML.readXML();
        DataTree treeXML = domReaderXML.getTree();
        domWriterXML = new WriterXML(fileRead, treeXML);
        domWriterXML.writeXML();

        String stringWrite = "";
        try(FileInputStream inputStream = new FileInputStream(fileWrite)) {
            stringWrite = IOUtils.toString(inputStream);
            // do something with everything string
        } catch (IOException e) {
            e.printStackTrace();
        }
        String stringRead = "";
        try(FileInputStream inputStream = new FileInputStream(fileRead)) {
            stringRead = IOUtils.toString(inputStream);
            // do something with everything string
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertXMLEqual("Comparing test xml to control xml",stringWrite, stringRead);
    }

    @Test
    public void readXMLTest() throws IOException, SAXException {
        LoadingTreeWithDateBase former = new LoadingTreeWithDateBase();
        former.loadAllTree();
        DataTree tree = former.getTree();

        File fileWrite = new File("src/main/resources/xml_file_DB.xml");
        // create XML-file from object "Tree"
        WriterXML domWriterXML = new WriterXML(fileWrite, tree);
        domWriterXML.writeXML();
        File fileRead = new File("src/main/resources/xml_file_DB_reader.xml");
        ReaderXML domReaderXML = new ReaderXML();
        domReaderXML.readXML(fileWrite);
        DataTree treeXML = domReaderXML.getTree();
        domWriterXML = new WriterXML(fileRead, treeXML);
        domWriterXML.writeXML();

        String stringWrite = "";
        try(FileInputStream inputStream = new FileInputStream(fileWrite)) {
            stringWrite = IOUtils.toString(inputStream);
            // do something with everything string
        } catch (IOException e) {
            e.printStackTrace();
        }
        String stringRead = "";
        try(FileInputStream inputStream = new FileInputStream(fileRead)) {
            stringRead = IOUtils.toString(inputStream);
            // do something with everything string
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertXMLEqual("Comparing test xml to control xml",stringWrite, stringRead);
    }

    @Test
    public void readXMLDefaultTest() throws IOException, SAXException {
        LoadingTreeWithDateBase former = new LoadingTreeWithDateBase();
        former.loadAllTree();
        DataTree tree = former.getTree();

        // File fileWrite = new File("src/main/resources/xml_file_DB.xml");
        File fileWrite = new File("src/main/resources/default.xml");
        // create XML-file from object "Tree"
        WriterXML domWriterXML = new WriterXML(fileWrite, tree);
        domWriterXML.writeXML();
        ReaderXML domReaderXML = new ReaderXML();
        domReaderXML.readXML(null);
        File fileRead = domReaderXML.getFile();
        DataTree treeXML = domReaderXML.getTree();
        domWriterXML = new WriterXML(fileRead, treeXML);
        domWriterXML.writeXML();

        String stringWrite = "";
        try(FileInputStream inputStream = new FileInputStream(fileWrite)) {
            stringWrite = IOUtils.toString(inputStream);
            // do something with everything string
        } catch (IOException e) {
            e.printStackTrace();
        }
        String stringRead = "";
        try(FileInputStream inputStream = new FileInputStream(fileRead)) {
            stringRead = IOUtils.toString(inputStream);
            // do something with everything string
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertXMLEqual("Comparing test xml to control xml",stringWrite, stringRead);
    }
//    @Rule
//    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void readXMLExceptionTest(){
//        thrown.expect(FileNotFoundException.class);
//        thrown.expectMessage(not(equalTo("")));
//        File file = new File("src/main/resources/defaultFalse.xml");
//        ReaderXML domReaderXML;
//        domReaderXML = new ReaderXML();
//        domReaderXML.readXML(file);
//        thrown = ExpectedException.none();

//        File file = new File("src/main/resources/defaultFalse.xml");
//        ReaderXML domReaderXML;
//        domReaderXML = new ReaderXML();
//        try {
//            domReaderXML.readXML(file);
//            fail("Expected Exception");
//        }
//        catch (Exception e)
//        {
//            // System.out.println(e);
//            assertNotEquals("", e.getMessage());
//        }

    }



    @Test
    public void getTree() {
    }
}