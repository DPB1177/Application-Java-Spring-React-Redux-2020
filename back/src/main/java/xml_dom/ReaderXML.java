package xml_dom;

import models.tree.DataTree;
import models.tree.TreeNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;

public class ReaderXML {
    private DataTree tree;


    private File file;
    private Document document;
    private ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<TreeNode>();

    /**
     * Constructor.
     *
     * @param file The file from which the tree will be formed.
     */
    public ReaderXML(File file) {
        this.file = file;
    }

    /**
     * Constructor.
     */
    public ReaderXML() {
        this.file = new File("src/main/resources/default.xml");
    }

    /**
     * Reading a file and creating a tree.
     */
    public void readXML() {
        this.tree = new DataTree();
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node root = document.getDocumentElement();
        stepThrough(root);
    }

    /**
     * Reading a file and creating a tree.
     *
     * @param file Reading file.
     */
    public void readXML(File file) {
        this.tree = new DataTree();
        if (file == null) {
            this.file = new File("src/main/resources/default.xml");
        } else {
            this.file = file;
        }
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Node root = document.getDocumentElement();
        stepThrough(root);
    }

    private void stepThrough(Node start) {
        Element element = (Element) start;
        if (TagNodeNames.initTegNode.containsKey(element.getTagName())) {
            TreeNode node = ElementParser.parseElement(element);
            if (element.getTagName().equals("root")) {
                TreeNode nodeDataBase = new TreeNode();
                nodeDataBase.setData(node.getData());
                tree.addRoot(nodeDataBase);
                arrayDeque.push(nodeDataBase);
            } else {
                tree.addNodeWithDataToCurrentNode(node.getData(), arrayDeque.element());
                TreeNode nodeDataBase = tree.getCurrentNode();
                arrayDeque.push(nodeDataBase);
            }
            for (Node child = start.getFirstChild(); child != null; child = child.getNextSibling()) {
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    stepThrough(child);
                }
            }
            arrayDeque.pop();
        }
    }

    public DataTree getTree() {
        return tree;
    }

    public File getFile() {
        return file;
    }

}
