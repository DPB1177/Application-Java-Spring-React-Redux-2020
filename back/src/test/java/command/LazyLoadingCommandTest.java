package command;

import constants.Constants;
import models.data.Information;
import models.tree.DataTree;
import models.tree.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LazyLoadingCommandTest {
    private LazyLoadingCommand  lazyLoadingCommand;
    private Information information;

    @Before
    public void setUp() throws Exception {

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
        lazyLoadingCommand = new LazyLoadingCommand(0, tree);
    }
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void execute() {
        DataTree treeLoading = lazyLoadingCommand.execute();
        assertNotNull(treeLoading);
    }


}