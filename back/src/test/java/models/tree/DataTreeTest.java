package models.tree;

import models.data.Information;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DataTreeTest {
    private DataTree tree;
    private Information information;
    private TreeNode node;

    @Before
    public void setUp() throws Exception {
        information = new Information();
        information.setValue("key", "value");
        node = new TreeNode(information);
        tree = new DataTree();
        tree.addRoot(node);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRoot() {
        assertTrue(tree.getRoot().isRoot());
        tree = new DataTree(node);
        assertTrue(tree.getRoot().isRoot());
    }

    @Test
    public void getCurrentNode() {
        TreeNode currentNode = tree.getCurrentNode();
        assertNotNull(currentNode);
        assertSame(currentNode, tree.getRoot());
    }

    @Test
    public void addRoot() {
        tree = new DataTree();
        tree.addRoot(information);
        assertTrue(tree.getRoot().isRoot());
        assertEquals(tree.getRoot().getData().getValue("key"), "value");
    }

    @Test
    public void testAddRoot() {
        assertTrue(tree.getRoot().isRoot());
        assertEquals(tree.getRoot().getData().getValue("key"), "value");
    }

    @Test
    public void addNodeWithDataToCurrentNode() {
        Information information = new Information();
        information.setValue("key2", "value2");
        tree.addNodeWithDataToCurrentNode(information);
        assertNotNull(tree.getCurrentNode());
        assertEquals(tree.getCurrentNode().getData().getValue("key2"), "value2");
    }

    @Test
    public void testAddNodeWithDataToCurrentNode() {
        Information information = new Information();
        information.setValue("keyNode", "valueNode");
        TreeNode node = new TreeNode(information);
        Information information2 = new Information();
        information2.setValue("key2", "value2");
        tree.addNodeWithDataToCurrentNode(information2, node);
        assertNotNull(tree.getCurrentNode());
        assertEquals(tree.getCurrentNode().getData().getValue("key2"), "value2");
    }

    @Test
    public void treeTraversalDFS() {
        tree = new DataTree();
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
        tree.addRoot(root);

        List<TreeNode> nodesDFS = tree.treeTraversalDFS();
        StringBuilder stringBuilder = new StringBuilder();
        for (TreeNode node : nodesDFS) {
            stringBuilder.append(node.getData().getValue("key"));
            stringBuilder.append("_");
        }
        // System.out.println(stringBuilder);
        String string = "0_1_4_11_12_13_14_5_2_6_7_8_3_9_10_";
        assertEquals(string, stringBuilder.toString());
    }

    @Test
    public void treeTraversalBFS() {
        tree = new DataTree();
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
        tree.addRoot(root);

        List<TreeNode> nodesDFS = tree.treeTraversalBFS();
        StringBuilder stringBuilder = new StringBuilder();
        for (TreeNode node : nodesDFS) {
            stringBuilder.append(node.getData().getValue("key"));
            stringBuilder.append("_");
        }
        // System.out.println(stringBuilder);
        String string = "0_1_2_3_4_5_6_7_8_9_10_11_12_13_14_";
        assertEquals(string, stringBuilder.toString());
    }

    @Test
    public void findBFS() {
        tree = new DataTree();
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
        tree.addRoot(root);

        TreeNode findNode = tree.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("key")) == 14);
        assertNotNull(findNode);
        assertEquals(findNode.getData().getValue("key"),"14");
        findNode = tree.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("key")) == 0);
        assertNotNull(findNode);
        assertEquals(findNode.getData().getValue("key"),"0");
        findNode = tree.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("key")) == 77);
        assertNull(findNode);

    }

    @Test
    public void findBFSofList() {
        tree = new DataTree();
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
        information.setValue("key", "14");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("key", "14");
        child0L1.get(0).addChild(information);
        tree.addRoot(root);
        List<TreeNode> listFindNodes = tree.findBFSofList(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("key")) == 14);
        assertEquals(listFindNodes.size(),2);
        assertEquals(listFindNodes.get(0).getData().getValue("key"),"14");
        assertEquals(listFindNodes.get(1).getData().getValue("key"),"14");
    }

    @Test
    public void findDFS() {
        tree = new DataTree();
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
        tree.addRoot(root);

        TreeNode findNode = tree.findDFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("key")) == 10);
        assertNotNull(findNode);
        assertEquals(findNode.getData().getValue("key"),"10");
        findNode = tree.findDFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("key")) == 0);
        assertNotNull(findNode);
        assertEquals(findNode.getData().getValue("key"),"0");
        findNode = tree.findDFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("key")) == 77);
        assertNull(findNode);
    }

    @Test
    public void amountNodes() {
        tree = new DataTree();
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
        tree.addRoot(root);

        assertEquals(tree.amountNodes(), 15L);
    }
}