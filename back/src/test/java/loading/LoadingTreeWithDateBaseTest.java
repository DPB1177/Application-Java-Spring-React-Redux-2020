package loading;

import constants.Constants;
import models.data.Information;
import models.tree.DataTree;
import models.tree.TreeNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class LoadingTreeWithDateBaseTest {
    private Information information;

    private LoadingTreeWithDateBase former;


    @Before
    public void setUp() throws Exception {
        former = new LoadingTreeWithDateBase();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getTree() {
        DataTree tree = former.getTree();
        assertNotNull(tree);
        assertEquals(tree.getClass().getSimpleName(),"DataTree");
        tree = new DataTree();
        former = new LoadingTreeWithDateBase(tree);
        assertEquals(former.getTree().getClass().getSimpleName(),"DataTree");
    }

    @Test
    public void findID() {
        DataTree tree;
        tree = new DataTree();
        information = new Information();
        information.setValue("id", "0");
        TreeNode root = new TreeNode(information);

        information = new Information();
        information.setValue("id", "1");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "2");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "3");
        root.addChild(information);

        List<TreeNode> children = root.getChildren();
        information = new Information();
        information.setValue("id", "4");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "5");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "6");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "7");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "8");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "9");
        children.get(2).addChild(information);
        information = new Information();
        information.setValue("id", "10");
        children.get(2).addChild(information);

        List<TreeNode> child0L1 = children.get(0).getChildren();
        information = new Information();
        information.setValue("id", "11");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "12");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "14");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "14");
        child0L1.get(0).addChild(information);
        tree.addRoot(root);
        former = new LoadingTreeWithDateBase(tree);
        List<TreeNode> list = former.findID(14);
        assertThat(list, hasSize(2));
        assertEquals(list.get(0).getData().getValue("id"),"14");
        assertEquals(list.get(1).getData().getValue("id"),"14");
    }

    @Test
    public void findNodeID() {
        DataTree tree;
        tree = new DataTree();
        information = new Information();
        information.setValue("id", "0");
        TreeNode root = new TreeNode(information);

        information = new Information();
        information.setValue("id", "1");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "2");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "3");
        root.addChild(information);

        List<TreeNode> children = root.getChildren();
        information = new Information();
        information.setValue("id", "4");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "5");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "6");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "7");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "8");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "9");
        children.get(2).addChild(information);
        information = new Information();
        information.setValue("id", "10");
        children.get(2).addChild(information);

        List<TreeNode> child0L1 = children.get(0).getChildren();
        information = new Information();
        information.setValue("id", "11");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "12");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "13");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "14");
        child0L1.get(0).addChild(information);
        tree.addRoot(root);
        former = new LoadingTreeWithDateBase(tree);
        TreeNode findNode = former.findNodeID(14);

        assertEquals(findNode.getData().getValue("id"),"14");
    }
    @Test
    public void FindNodeForID(){
        former = new LoadingTreeWithDateBase();
        assertNull(former.findNodeID(7));
//        try {
//            former.findID(0);
//            Assert.fail("Expected RuntimeException");
//        }
//        catch (RuntimeException e)
//        {
//            Assert.assertNotEquals("", e.getMessage());
//        }
    }
    @Test
    public void findNodeRoot() {
        DataTree tree;
        tree = new DataTree();
        information = new Information();
        information.setValue("id", "0");
        information.setValue(Constants.KEY_NAME_NODE, "root");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        TreeNode root = new TreeNode(information);

        information = new Information();
        information.setValue("id", "1");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "2");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        root.addChild(information);
        information = new Information();
        information.setValue("id", "3");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        root.addChild(information);

        List<TreeNode> children = root.getChildren();
        information = new Information();
        information.setValue("id", "4");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "5");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        children.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "6");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "7");
        children.get(1).addChild(information);
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        information = new Information();
        information.setValue("id", "8");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        children.get(1).addChild(information);
        information = new Information();
        information.setValue("id", "9");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        children.get(2).addChild(information);
        information = new Information();
        information.setValue("id", "10");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        children.get(2).addChild(information);

        List<TreeNode> child0L1 = children.get(0).getChildren();
        information = new Information();
        information.setValue("id", "11");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "12");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");
        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "13");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");

        child0L1.get(0).addChild(information);
        information = new Information();
        information.setValue("id", "14");
        information.setValue(Constants.KEY_ALREADY_CLICKED,"yes");

        child0L1.get(0).addChild(information);
        tree.addRoot(root);
        former = new LoadingTreeWithDateBase(tree);
        TreeNode findNode = former.findNodeRoot();

        assertEquals(findNode.getData().getValue(Constants.KEY_NAME_NODE),"root");
    }

    @Test
    public void loadChildren() {
        LoadingTreeWithDateBase former = new LoadingTreeWithDateBase();
        DataTree tree = former.getTree();
        former.loadChildren(10);
        assertNotNull(tree);
    }

    @Test
    public void loadAllTree() {
        LoadingTreeWithDateBase former = new LoadingTreeWithDateBase();
        former.loadAllTree();
        DataTree tree = former.getTree();
        assertNotNull(tree);

    }
}