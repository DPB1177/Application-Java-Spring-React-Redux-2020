package database.parametrs;

import constants.Constants;
import models.data.Information;
import models.tree.DataTree;
import models.tree.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParametersWithNodeTest {

    private ParametersWithNode parametersWithNode;
    private Information information;
    private DataTree tree;
    private ParametersForConnectionBD parameterConnection;

    @Before
    public void setUp() throws Exception {

        parametersWithNode = new ParametersWithNode();

        parametersWithNode.setIndex_was_one_click(new String[]{"0", "1"});
        parametersWithNode.setIndex_minus(new String[]{"0", "1"});
        parametersWithNode.setIndex_plus(new String[]{"0", "1"});
        parametersWithNode.setIndex_zero(new String[]{"0", "1"});

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

        parametersWithNode.setTreeNode(tree.getRoot());

        parameterConnection = new ParametersForConnectionBD();
        parameterConnection.setUser("");
        parameterConnection.setUrl("");
        parameterConnection.setPort("");
        parameterConnection.setPassword("");

        parametersWithNode.setParameters(parameterConnection);

        parametersWithNode.setIndex_was_one_click(new String[]{""});

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getParameterConnection() {
        ParametersForConnectionBD parameters = parametersWithNode.getParameterConnection();
        assertNotNull(parameters);
    }

    @Test
    public void setParameters() {
    }

    @Test
    public void getTreeNode() {
        TreeNode treeNode = parametersWithNode.getTreeNode();
        assertNotNull(treeNode);
    }

    @Test
    public void setTreeNode() {
    }

    @Test
    public void getIndex_minus() {
        String[] strings = parametersWithNode.getIndex_minus();
        assertNotNull(strings);
    }

    @Test
    public void setIndex_minus() {
    }

    @Test
    public void getIndex_visible_children() {
        String[] strings = parametersWithNode.getIndex_was_one_click();
        assertNotNull(strings);
    }

    @Test
    public void setIndex_visible_children() {
    }

    @Test
    public void getIndex_load_node() {
        String[] strings = parametersWithNode.getIndex_plus();
        assertNotNull(strings);
    }

    @Test
    public void setIndex_load_node() {
    }

    @Test
    public void getIndex_zero() {

        String[] strings = parametersWithNode.getIndex_zero();
        assertNotNull(strings);

    }

    @Test
    public void setIndex_zero() {
    }
}