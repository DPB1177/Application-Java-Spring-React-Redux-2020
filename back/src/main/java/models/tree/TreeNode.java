package models.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.data.Information;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    @JsonIgnore
    private TreeNode parent = null;
    private List<TreeNode> children = new ArrayList<TreeNode>();
    private Information data = null;

    public TreeNode() {
    }

    public TreeNode(Information data) {
        this.data = data;
    }

    public TreeNode(Information data, TreeNode parent) {
        this.parent = parent;
        this.data = data;
        parent.addChild(this);
    }

    public TreeNode(TreeNode parent) {
        this.parent = parent;
        parent.addChild(this);
    }


    public void addChild(Information data) {
        TreeNode child = new TreeNode(data);
        addChild(child);
        child.setParent(this);
        // this.children.add(child);
    }

    private void addChild(TreeNode child) throws IllegalArgumentException {
        if (child == this) {
            throw new IllegalArgumentException("The child links to yourself.");
        }
        this.children.add(child);
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        if ((this.children == null || this.children.size() == 0) && children != null ) {
            this.children = children;
            for (TreeNode child : children) {
                // change of parent
                if (child.getParent() != this) {
                    child.setParent(this);
                }
            }
        } else {
            throw new RuntimeException("This node has children!");
        }
    }

    public Information getData() {
        return data;
    }

    public void setData(Information data) {
        this.data = data;
    }

    public void removeChildNode(TreeNode node) {
        if (node.getParent() == this) {
            children.remove(node);
        } else {
            throw new RuntimeException("This node!");
        }
    }

    public void removeChildrenNode() {
        this.children.clear();
    }
    @JsonIgnore
    public boolean isRoot() {
        return (this.parent == null);
    }
    @JsonIgnore
    public boolean isLeaf() {
        return this.children.size() == 0;
    }

}
