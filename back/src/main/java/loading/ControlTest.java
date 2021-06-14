package loading;


import json_jackson.Converter;
import models.data.Information;
import models.tree.DataTree;
import models.tree.TreeNode;
import xml_dom.ReaderXML;
import xml_dom.WriterXML;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ControlTest {
    public static void main(String[] args) {
//        LoadingTree loadingTree = new LoadingTree();
//        DataTree tree = loadingTree.getTree();
//        Map<String ,String> map = tree.getRoot().getData().getMap();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//        try {
//            Converter.toJSON_Tree(tree);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Information data = LoadingInformation.LoadingProcedure("sakila", "film_in_stock");
//        Map<String ,String> map = data.getMap();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }


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






//        try {
//            Converter.toJSON_Tree(tree);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
// --------------------------------------------------------------------------------------------
//        TreeNode node = tree.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("id")) == 5);
//        Information information = node.getData();
//        Map<String, String> map = information.getMap();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//
//        try {
//            Converter.toJSON_Node(node);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
// --------------------------------------------------------------------------------------------

//        DataTree tree = former.getTree();
//        Map<String ,String> map = tree.getRoot().getData().getMap();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }


    }
}
