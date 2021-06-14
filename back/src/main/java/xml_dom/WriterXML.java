package xml_dom;

import constants.Constants;
import models.tree.DataTree;
import models.tree.TreeNode;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WriterXML {
    private File file;
    private DataTree tree;
    private Document document;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private TransformerFactory transformerFactory;
    private Transformer transformer;
    private DOMSource domSource;

    //private static final Logger log = Logger.getLogger(WriterXML.class);

    /**
     * The constructor with parameters.
     *
     * @param file The name of file for XML-file.
     * @param tree tree - TreeDataBase.
     */
    public WriterXML(File file, DataTree tree) {
        this.file = file;
        this.tree = tree;
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        if (builder != null) {
            document = builder.newDocument();
        } else {
            throw new IllegalStateException("WriterXML: builder == null!");
        }

        transformerFactory = TransformerFactory.newInstance();
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Without the control list.
     */
    private void stepThrough(Element startElement, TreeNode nodeDataBase) {
        Element element = document.createElement(nodeDataBase.getData().getValue(Constants.KEY_NAME_NODE));
        if (nodeDataBase.getData().getValue(Constants.KEY_NAME_NODE).equals("root")) {
            element = startElement;
        } else {
            startElement.appendChild(element);
        }
        parseNode(nodeDataBase, element);
        if (nodeDataBase.getChildren().size() != 0) {
            for (TreeNode child : nodeDataBase.getChildren()) {
                stepThrough(element, child);
            }
        }
    }

    /**
     * With the control list.
     */
    private void stepThrough(Element startElement, TreeNode nodeDataBase,
                             List<TreeNode> result) {
        Element element = document.createElement(nodeDataBase.getData().getValue(Constants.KEY_NAME_NODE));
        if (nodeDataBase.getData().getValue(Constants.KEY_NAME_NODE).equals("root")) {
            element = startElement;
        } else {
            startElement.appendChild(element);
        }
        // ...
        parseNode(nodeDataBase, element);
        // ...
        result.add(nodeDataBase);
        if (nodeDataBase.getChildren().size() != 0) {
            for (TreeNode child : nodeDataBase.getChildren()) {
                stepThrough(element, child, result);
            }
        }
    }

    /**
     * The example of the realise.
     *
     * @param currentNode the node.
     * @return The element of DOM.
     */
//    private Element parseNode(TreeNode currentNode) {
//        Element result = document.createElement(currentNode.getData().getValue(Constants.KEY_NAME_NODE));
//        for (Map.Entry<String, String> each : currentNode.getData().getMap().entrySet()) {
//            result.setAttribute(each.getKey(), each.getValue());
//        }
//        return result;
//    }

    /**
     * The working realise.
     *
     * @param currentNode the node for the this project.
     */
    private void parseNode(TreeNode currentNode, Element result) {
        for (Map.Entry<String, String> each : currentNode.getData().getMap().entrySet()) {
            result.setAttribute(each.getKey(), each.getValue());
        }
    }

    /**
     * Writing the tree in the Date Base without the control list.
     */
    public void write() {
        TreeNode root = tree.getRoot();
        Element element = document.createElement(root.getData().getValue(Constants.KEY_NAME_NODE));
        document.appendChild(element);

        stepThrough(element, root);

        domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(file);
        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writing the tree in the Date Base.
     */
    public void writeXML() {
        TreeNode root = tree.getRoot();
        // The checklist (left from depth-first search traversal).
        List<TreeNode> result = new ArrayList<>();
        Element element = document.createElement(root.getData().getValue(Constants.KEY_NAME_NODE));
        document.appendChild(element);

        stepThrough(element, root, result);

        domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(file);
        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public String getString()  {
        String string = "";
        try(FileInputStream inputStream = new FileInputStream(getFile())) {
            string = IOUtils.toString(inputStream);
            // do something with everything string
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
