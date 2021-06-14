package database.parametrs;

import models.tree.TreeNode;

import java.util.Arrays;

public class ParametersForLoadNodeXML {

    private ParametersForConnectionBD parameterConnection;
    private TreeNode treeNode;

    private String[] index_was_one_click;
    private String[] index_minus;
    private String[] index_plus;
    private String[] index_zero;

    public ParametersForConnectionBD getParameterConnection() {
        return parameterConnection;
    }

    public void setParameters(ParametersForConnectionBD parameterConnection) {
        this.parameterConnection = parameterConnection;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public String[] getIndex_was_one_click() {
        return index_was_one_click;
    }

    public void setIndex_was_one_click(String[] index_was_one_click) {
        this.index_was_one_click = index_was_one_click;
    }

    public String[] getIndex_minus() {
        return index_minus;
    }

    public void setIndex_minus(String[] index_minus) {
        this.index_minus = index_minus;
    }

    public String[] getIndex_plus() {
        return index_plus;
    }

    public void setIndex_plus(String[] index_plus) {
        this.index_plus = index_plus;
    }

    public String[] getIndex_zero() {
        return index_zero;
    }

    public void setIndex_zero(String[] index_zero) {
        this.index_zero = index_zero;
    }

    @Override
    public String toString() {
        return "ParametersForLoadNodeXML{" +
                "parameterConnection=" + parameterConnection +
                ", treeNode=" + treeNode +
                ", index_was_one_click=" + Arrays.toString(index_was_one_click) +
                ", index_minus=" + Arrays.toString(index_minus) +
                ", index_plus=" + Arrays.toString(index_plus) +
                ", index_zero=" + Arrays.toString(index_zero) +
                '}';
    }
}
