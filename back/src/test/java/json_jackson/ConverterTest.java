package json_jackson;

import models.data.Information;
import models.tree.DataTree;
import models.tree.TreeNode;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static json_jackson.Converter.*;
import static org.junit.Assert.*;

public class ConverterTest {
    private DataTree tree;
    private Information information;
    private TreeNode node;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void toJSON_TreeTest() {
        this.tree = new DataTree();
        information = new Information();
        information.setValue("key", "0");
        TreeNode root = new TreeNode(information);

        information = new Information();
        information.setValue("key", "1");
        root.addChild(information);
        information = new Information();
        information.setValue("key", "2");
        root.addChild(information);
        information = new Information();
        information.setValue("key", "3");
        root.addChild(information);

        List<TreeNode> children = root.getChildren();
        information = new Information();
        information.setValue("key", "4");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "5");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "6");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("key", "7");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("key", "8");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("key", "9");
        children.get(2).addChild(information);
        information = new Information();
        information.setValue("key", "10");
        children.get(2).addChild(information);

        List<TreeNode> child0L1 = children.get(0).getChildren();
        information = new Information();
        information.setValue("key", "11");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "12");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "13");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "14");
        child0L1.get(0).addChild(information);
        this.tree.addRoot(root);
        try {
            toJSON_Tree(this.tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = "";
        try(FileInputStream inputStream = new FileInputStream(baseFile)) {
            string = IOUtils.toString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotEquals(string,"");
    }

    @Test
    public void toJSON_NodeTest() {
        this.tree = new DataTree();
        information = new Information();
        information.setValue("key", "0");
        TreeNode root = new TreeNode(information);

        information = new Information();
        information.setValue("key", "1");
        root.addChild(information);
        information = new Information();
        information.setValue("key", "2");
        root.addChild(information);
        information = new Information();
        information.setValue("key", "3");
        root.addChild(information);

        List<TreeNode> children = root.getChildren();
        information = new Information();
        information.setValue("key", "4");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "5");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "6");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("key", "7");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("key", "8");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("key", "9");
        children.get(2).addChild(information);
        information = new Information();
        information.setValue("key", "10");
        children.get(2).addChild(information);

        List<TreeNode> child0L1 = children.get(0).getChildren();
        information = new Information();
        information.setValue("key", "11");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "12");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "13");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "14");
        child0L1.get(0).addChild(information);
        this.tree.addRoot(root);
        try {
            toJSON_Node(this.tree.getRoot());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = "";
        try(FileInputStream inputStream = new FileInputStream(file_json_node)) {
            string = IOUtils.toString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotEquals(string,"");
    }
}