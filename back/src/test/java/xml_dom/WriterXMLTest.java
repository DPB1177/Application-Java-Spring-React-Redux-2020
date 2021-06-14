package xml_dom;

import loading.LoadingTreeWithDateBase;
import models.tree.DataTree;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.mockito.Mockito.*;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(MockitoJUnitRunner.class)
// @PrepareForTest(WriterXML.class)
public class WriterXMLTest {
    //private WriterXML powerMockWriterXML = mock(WriterXML.class);
    @Before
    public void setUp() throws Exception {
        XMLUnit.setIgnoreComments(true);
        XMLUnit.setIgnoreWhitespace(true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void write() throws IOException, SAXException {
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
        domWriterXML.write();

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
        assertXMLEqual("Comparing test xml to control xml",domWriterXML.getString(), stringRead);
    }

    @Test
    public void writeXML() throws IOException, SAXException {
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


//    @Test
////    @Test (expected = TransformerException.class)
//    public void testWriteXML() throws TransformerException {
//        DocumentBuilder Mockbuilder = Mockito.mock(DocumentBuilder.class);
//        //WriterXML powerMockWriterXML = Mockito.mock(WriterXML.class);
//        Mockito.doThrow(new TransformerException("TransformerException")).when(Mockbuilder).newDocument(); // PowerMockito.doThrow(new ParserConfigurationException()).when(WriterXML.class);
////        Mockito.verify(powerMockWriterXML).write();
//        //verify(mcalc).divide(15.0, 0);
//
//    }

    @Test
    public void getFile() {
    }

    @Test
    public void getString() {
    }
}