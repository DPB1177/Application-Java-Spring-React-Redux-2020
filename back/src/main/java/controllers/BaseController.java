package controllers;

import database.DataBaseManager;
import database.parametrs.*;
import loading.LoadingTreeWithDateBase;
import models.tree.DataTree;
import models.tree.TreeNode;
import org.springframework.web.bind.annotation.*;
import xml_dom.ReaderXML;
import xml_dom.WriterXML;

import java.io.File;

import static constants.ConstantsForXMLFile.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class BaseController {
    private LoadingTreeWithDateBase former;
    private DataTree tree = new DataTree();
    private DataTree treeForReturn = new DataTree();
    private ParametersForConnectionBD parametersForConnectionBD;
    private ParametersWithNode parametersWithNode;
    private ParameterStringXML parameterStringXML;
    private ParametersForSaveXML parametersForSaveXML;
    private ParametersForSaveXML parametersForSaveXMLForOfflineMode;
    private ParametersForLoadNodeXML parametersForLoadNodeXML;
    private ParametersForLoadNodeXML parametersForLoadNodeXMLForOfflineMode;
    private ParametersForOfflineMode parametersForOfflineMode;

    @RequestMapping(value = "/parameters", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ParametersWithNode parameters(@RequestBody ParametersForConnectionBD parameters) {

        System.out.println("/parameters/: " + parameters);
        parametersForConnectionBD = parameters;
        DataBaseManager.instanceDataBaseManager(parametersForConnectionBD.getUrl(),parametersForConnectionBD.getUser(),parametersForConnectionBD.getPassword());
        former = new LoadingTreeWithDateBase();
        tree = former.getTree();
        TreeNode root = tree.getRoot();
        parametersWithNode = new ParametersWithNode();
        parametersWithNode.setParameters(parameters);
        parametersWithNode.setTreeNode(root);
        parametersWithNode.setIndex_was_one_click(new String[]{});
        parametersWithNode.setIndex_minus(new String[]{});
        parametersWithNode.setIndex_plus(new String[]{});
        parametersWithNode.setIndex_zero(new String[]{});

        return parametersWithNode;
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public TreeNode load(@RequestBody ParameterID parameter) {
        System.out.println("/load/: " + parameter);
        long id;
        if (parameter.getId().equals("null") || parameter.getId() == null || parameter.getId().equals("-1")) {
            //DataBaseManager.instanceDataBaseManager(parametersForConnectionBD.getUrl(), parametersForConnectionBD.getUser(), parametersForConnectionBD.getPassword());
            DataBaseManager.instanceDataBaseManager();
            parameter.setId("0");
            former = new LoadingTreeWithDateBase();
        }
        id = Long.parseLong(parameter.getId());
        former.loadChildren(id);

        tree = former.getTree();
        TreeNode node = tree.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("id")) == 0);

        return node;
    }

    @RequestMapping(value = "/saveXML", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ParameterStringXML saveXML(@RequestBody ParametersForSaveXML parameter) {
        System.out.println("/saveXML: " + parameter);
        parametersForSaveXML = parameter;
        parametersForSaveXMLForOfflineMode = parameter;
        System.out.println("parametersForSaveXML: " + parametersForSaveXML);
        System.out.println("parametersForSaveXMLForOfflineMode: " + parametersForSaveXMLForOfflineMode);

        File fileWrite = new File(NAME_XML_FILE_FOR_FRONT);
        if (tree == null) {
            former = new LoadingTreeWithDateBase();
            tree = former.getTree();
        }
        WriterXML domWriterXML = new WriterXML(fileWrite, tree);
        domWriterXML.writeXML();
        // Out String value of XML-file to front
        parameterStringXML = new ParameterStringXML();
        parameterStringXML.setString(domWriterXML.getString());
        return parameterStringXML;
    }

    @RequestMapping(value = "/loadXML", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ParametersForLoadNodeXML loadXML(@RequestBody ParameterID parameter) {
        System.out.println("/loadXML: " + parameter);
        System.out.println("/loadXML: " + parametersForSaveXML);
        if (parametersForSaveXML == null) {
            parametersForSaveXML = new ParametersForSaveXML();
            parametersForSaveXML.setIndex_was_one_click(new String[]{});
            parametersForSaveXML.setIndex_minus(new String[]{});
            parametersForSaveXML.setIndex_plus(new String[]{});
            parametersForSaveXML.setIndex_zero(new String[]{});
        }
        File fileRead = new File(NAME_XML_FILE_FOR_FRONT);
        ReaderXML domReaderXML = new ReaderXML(fileRead);
        domReaderXML.readXML();
        DataTree treeXML = domReaderXML.getTree();
        // tree = treeXML;
        TreeNode node = treeXML.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("id")) == 0);

        parametersForLoadNodeXML = new ParametersForLoadNodeXML();
        parametersForLoadNodeXML.setParameters(parametersForConnectionBD);
        parametersForLoadNodeXML.setIndex_was_one_click(parametersForSaveXML.getIndex_was_one_click());
        parametersForLoadNodeXML.setIndex_minus(parametersForSaveXML.getIndex_minus());
        parametersForLoadNodeXML.setIndex_plus(parametersForSaveXML.getIndex_plus());
        parametersForLoadNodeXML.setIndex_zero(parametersForSaveXML.getIndex_zero());
        parametersForLoadNodeXML.setTreeNode(node);

        return parametersForLoadNodeXML;
    }

    @RequestMapping(value = "/offlineMode", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ParametersForLoadNodeXML offlineMode(@RequestBody ParametersForOfflineMode parameters) {

        // 0. parameters for tree of base page. (for return)
        parametersForOfflineMode = parameters;
        System.out.println("/offlineMode: " + parameters);
        System.out.println("parametersForOfflineMode: " + parametersForOfflineMode.toString());

        // 1. save tree in xml-file of base page. (for return)
        File fileWrite = new File(NAME_XML_FILE_FOR_OFFLINE_MODE_OF_BASE_PAGE);
        if (tree == null) {
            former = new LoadingTreeWithDateBase();
            tree = former.getTree();
            treeForReturn = tree;
        }
        WriterXML domWriterXML = new WriterXML(fileWrite, tree);
        domWriterXML.writeXML();
        treeForReturn = tree;

        // 2. load xml-file which was saved in past.
        File fileRead = new File(NAME_XML_FILE_FOR_FRONT);
        TreeNode node = null;
        if (fileRead.exists()){
            ReaderXML domReaderXML = new ReaderXML(fileRead);
            domReaderXML.readXML();
            DataTree treeXML = domReaderXML.getTree();
            //tree = treeXML;
            node = treeXML.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("id")) == 0);
        } else {
            return new ParametersForLoadNodeXML();
        }

        // 3. Create value for sending to front (value: Class ParametersForLoadNodeXML)
        if (parametersForSaveXMLForOfflineMode == null) {
            parametersForSaveXMLForOfflineMode = new ParametersForSaveXML();
            parametersForSaveXMLForOfflineMode.setIndex_was_one_click(new String[]{});
            parametersForSaveXMLForOfflineMode.setIndex_minus(new String[]{});
            parametersForSaveXMLForOfflineMode.setIndex_plus(new String[]{});
            parametersForSaveXMLForOfflineMode.setIndex_zero(new String[]{});
        }

        parametersForLoadNodeXMLForOfflineMode = new ParametersForLoadNodeXML();
        parametersForLoadNodeXMLForOfflineMode.setParameters(parametersForConnectionBD);
        parametersForLoadNodeXMLForOfflineMode.setIndex_was_one_click(parametersForSaveXMLForOfflineMode.getIndex_was_one_click());
        parametersForLoadNodeXMLForOfflineMode.setIndex_minus(parametersForSaveXMLForOfflineMode.getIndex_minus());
        parametersForLoadNodeXMLForOfflineMode.setIndex_plus(parametersForSaveXMLForOfflineMode.getIndex_plus());
        parametersForLoadNodeXMLForOfflineMode.setIndex_zero(parametersForSaveXMLForOfflineMode.getIndex_zero());
        parametersForLoadNodeXMLForOfflineMode.setTreeNode(node);

        return parametersForLoadNodeXMLForOfflineMode;
    }

    @RequestMapping(value = "/backOfflineMode", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ParametersForLoadNodeXML backOfflineMode(@RequestBody ParameterID parameter) {
        System.out.println("/backOfflineMode: " + parameter);
        System.out.println("/backOfflineMode: " + parametersForSaveXMLForOfflineMode);
        if (parametersForSaveXMLForOfflineMode == null) {
            parametersForSaveXMLForOfflineMode = new ParametersForSaveXML();
            parametersForSaveXMLForOfflineMode.setIndex_was_one_click(new String[]{});
            parametersForSaveXMLForOfflineMode.setIndex_minus(new String[]{});
            parametersForSaveXMLForOfflineMode.setIndex_plus(new String[]{});
            parametersForSaveXMLForOfflineMode.setIndex_zero(new String[]{});
        }
        File fileRead = new File(NAME_XML_FILE_FOR_OFFLINE_MODE_OF_BASE_PAGE);
        ReaderXML domReaderXML = new ReaderXML(fileRead);
        domReaderXML.readXML();
        DataTree treeXML = domReaderXML.getTree();
        //tree = treeXML;
        treeForReturn = treeXML;
        TreeNode node = treeXML.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("id")) == 0);

        parametersForLoadNodeXMLForOfflineMode = new ParametersForLoadNodeXML();
        parametersForLoadNodeXMLForOfflineMode.setParameters(parametersForConnectionBD);
        parametersForLoadNodeXMLForOfflineMode.setIndex_was_one_click(parametersForOfflineMode.getIndex_was_one_click());
        parametersForLoadNodeXMLForOfflineMode.setIndex_minus(parametersForOfflineMode.getIndex_minus());
        parametersForLoadNodeXMLForOfflineMode.setIndex_plus(parametersForOfflineMode.getIndex_plus());
        parametersForLoadNodeXMLForOfflineMode.setIndex_zero(parametersForOfflineMode.getIndex_zero());
        parametersForLoadNodeXMLForOfflineMode.setTreeNode(node);
        System.out.println("/backOfflineMode: parametersForLoadNodeXMLForOfflineMode: " + "\n" + parametersForLoadNodeXMLForOfflineMode);
        return parametersForLoadNodeXMLForOfflineMode;
    }

}
