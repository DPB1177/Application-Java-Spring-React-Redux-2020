package models.tree;

import models.data.Information;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TreeNodeTest {
    private Information information;
    private TreeNode node;

    @Before
    public void setUp() throws Exception {
        information = new Information();
        information.setValue("key", "value");
        node = new TreeNode();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addChild() {
        assertEquals(node.getChildren().size(), 0);
        Information information2 = new Information();
        information2.setValue("key2", "value2");
        assertTrue(node.getChildren().isEmpty());
        node.addChild(information2);
        assertFalse(node.getChildren().isEmpty());
        List<TreeNode> listChildren = node.getChildren();
        for (TreeNode children : listChildren
        ) {
            for (Map.Entry<String, String> entry : children.getData().getMap().entrySet()) {
                assertEquals(entry.getKey(), "key2");
                assertEquals(entry.getValue(), "value2");
            }
        }
        assertEquals(node.getChildren().size(), 1);
    }

    @Test
    public void addChildException()  {

        Information information2 = new Information();
        information2.setValue("key2", "value2");
        TreeNode node2 = new TreeNode(information2);
        Method method = null;
        try {
            method = TreeNode.class.getDeclaredMethod("addChild", TreeNode.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assert method != null;
        method.setAccessible(true);
        try {
            method.invoke(node, node2);
        } catch (InvocationTargetException|IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            method.invoke(node, node);
            Assert.fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException |IllegalAccessException | InvocationTargetException e)
        {
            Assert.assertNotEquals("", e.getMessage());
        }
//        catch (IllegalAccessException | InvocationTargetException e){
//            e.printStackTrace();
//        }
    }

    @Test
    public void getParent() {
        Information informationParent = new Information();
        informationParent.setValue("keyParent", "valueParent");
        TreeNode nodeParent = new TreeNode(informationParent);
        node = new TreeNode(information, nodeParent);
        assertSame(node.getParent(),nodeParent);
        node = new TreeNode(nodeParent);
        assertSame(node.getParent(),nodeParent);
    }

    @Test
    public void getChildren() {
        assertEquals(node.getChildren().size(), 0);
        Information information2 = new Information();
        information2.setValue("key2", "value2");
        assertTrue(node.getChildren().isEmpty());
        node.addChild(information2);
        assertFalse(node.getChildren().isEmpty());
        List<TreeNode> listChildren = node.getChildren();
        for (TreeNode children : listChildren
        ) {
            for (Map.Entry<String, String> entry : children.getData().getMap().entrySet()) {
                assertEquals(entry.getKey(), "key2");
                assertEquals(entry.getValue(), "value2");
            }
        }
        assertEquals(node.getChildren().size(), 1);
    }

    @Test
    public void setChildren() {
        Information informationChild = new Information();
        informationChild.setValue("keyChildren", "valueChildren");
        TreeNode nodeChild = new TreeNode(informationChild);
        Information informationChild2 = new Information();
        informationChild2.setValue("keyChildren2", "valueChildren2");
        TreeNode nodeChild2 = new TreeNode(informationChild2);
        List<TreeNode> children = new ArrayList<>();
        children.add(nodeChild);
        children.add(nodeChild2);
        node.setChildren(children);
        assertFalse(node.getChildren().isEmpty());
        assertEquals(node.getChildren().size(), 2);
        for (TreeNode child : children
        ) {
            for (Map.Entry<String, String> entry : child.getData().getMap().entrySet()) {
                if(entry.getKey().equals("keyChildren"))
                {
                    assertEquals(entry.getKey(), "keyChildren");
                    assertEquals(entry.getValue(), "valueChildren");
                } else if (entry.getKey().equals("keyChildren2")){
                    assertEquals(entry.getKey(), "keyChildren2");
                    assertEquals(entry.getValue(), "valueChildren2");
                }
            }
        }
        try {
            node.setChildren(null);
            Assert.fail("Expected RuntimeException");
        }
        catch (RuntimeException e)
        {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void getData() {
        node = new TreeNode(this.information);
        Information information = node.getData();
        assertEquals(information.getValue("key"), "value");
    }

    @Test
    public void setData() {
        node.setData(information);
        assertEquals(information.getValue("key"), "value");
    }

    @Test
    public void removeChildNode() {
        Information informationChild = new Information();
        informationChild.setValue("keyChildren", "valueChildren");
        TreeNode nodeChild = new TreeNode(informationChild);
        List<TreeNode> children = new ArrayList<>();
        children.add(nodeChild);
        node.setChildren(children);
        node.removeChildNode(nodeChild);
        assertTrue(node.getChildren().isEmpty());
        children.add(nodeChild);
        assertFalse(node.getChildren().isEmpty());
        try {
            nodeChild.removeChildNode(node);
            Assert.fail("Expected RuntimeException");
        }
        catch (RuntimeException e)
        {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void removeChildrenNode() {
        Information informationChild = new Information();
        informationChild.setValue("keyChildren", "valueChildren");
        TreeNode nodeChild = new TreeNode(informationChild);
        Information informationChild2 = new Information();
        informationChild2.setValue("keyChildren2", "valueChildren2");
        TreeNode nodeChild2 = new TreeNode(informationChild2);
        List<TreeNode> children = new ArrayList<>();
        children.add(nodeChild);
        children.add(nodeChild2);
        node.setChildren(children);
        node.removeChildrenNode();
        assertTrue(node.getChildren().isEmpty());
    }

    @Test
    public void isRoot() {
        assertTrue(node.isRoot());
    }

    @Test
    public void isLeaf() {
        assertTrue(node.isLeaf());
    }
}