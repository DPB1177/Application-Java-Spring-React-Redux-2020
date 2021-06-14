package database.parametrs;

import models.tree.TreeNode;

public class ParametersWithNode {

    private ParametersForConnectionBD parameterConnection;
    private TreeNode treeNode;

//    private String[] index_minus;
//    private String[] index_visible_children;
//    private String[] index_load_node;
//    private String[] index_zero;

    private String[] index_was_one_click;
    private String[] index_minus;
    private String[] index_plus;
    private String[] index_zero;

    public String[] getIndex_was_one_click() {
        return index_was_one_click;
    }

    public void setIndex_was_one_click(String[] index_was_one_click) {
        this.index_was_one_click = index_was_one_click;
    }

    public String[] getIndex_plus() {
        return index_plus;
    }

    public void setIndex_plus(String[] index_plus) {
        this.index_plus = index_plus;
    }

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

    public String[] getIndex_minus() {
        return index_minus;
    }

    public void setIndex_minus(String[] index_minus) {
        this.index_minus = index_minus;
    }

//    public String[] getIndex_visible_children() {
//        return index_visible_children;
//    }
//
//    public void setIndex_visible_children(String[] index_visible_children) {
//        this.index_visible_children = index_visible_children;
//    }
//
//    public String[] getIndex_load_node() {
//        return index_load_node;
//    }
//
//    public void setIndex_load_node(String[] index_load_node) {
//        this.index_load_node = index_load_node;
//    }

    public String[] getIndex_zero() {
        return index_zero;
    }

    public void setIndex_zero(String[] index_zero) {
        this.index_zero = index_zero;
    }


}
