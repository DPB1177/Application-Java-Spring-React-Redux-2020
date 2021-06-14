package models.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.data.Information;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DataTree {
    private TreeNode root;
    @JsonIgnore
    private TreeNode currentNode;

    public DataTree() {
    }

    public DataTree(TreeNode root) {
        this.root = root;
        this.currentNode = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getCurrentNode() {
        return currentNode;
    }

    public void addRoot(TreeNode root) {
        this.root = root;
        this.currentNode = root;
    }

    public void addRoot(Information date) {
        root = new TreeNode(date);
        this.currentNode = root;
    }

    /*
     * The method receives the parameter new information creates a new node with this information and adds the current
     * node as a parent to this new node and makes the new node the current node.
     */
    public void addNodeWithDataToCurrentNode(Information date) {
        currentNode = new TreeNode(date, currentNode);
    }

    /*
     * The method receives parameters - information and the node after creates a new node with this information
     * and adds the received node as a parent to this new node. The new node becomes the current node.
     */
    public void addNodeWithDataToCurrentNode(Information date, TreeNode node) {
        if (date != null && node != null) {
            currentNode = new TreeNode(date, node);
        }
    }

    public List<TreeNode> treeTraversalDFS() {
        List<TreeNode> result = new ArrayList<TreeNode>();
        traversalDFS(root, result);
        return result;
    }

    private void traversalDFS(TreeNode node, List<TreeNode> result) {
        result.add(node);
        if (node.getChildren().size() != 0) {
            for (TreeNode child : node.getChildren()) {
                traversalDFS(child, result);
            }
        }
    }

    public List<TreeNode> treeTraversalBFS() {
        List<TreeNode> result = new ArrayList<TreeNode>();
        ArrayDeque<TreeNode> temp = new ArrayDeque<TreeNode>();
        temp.add(root);
        while (temp.size() > 0) {
            TreeNode currentMyNode = temp.getFirst();
            temp.addAll(currentMyNode.getChildren());
            temp.removeFirst();
            result.add(currentMyNode);
        }
        return result;
    }

    public TreeNode findBFS(Predicate<TreeNode> predicate) {
        TreeNode result = null;
        ArrayDeque<TreeNode> temp = new ArrayDeque<TreeNode>();
        temp.add(root);
        // System.out.println("root.getData().getValue(\"id\"):" + root.getData().getValue("id"));
        if (predicate.test(root)) {
            result = root;
            return result;
        }
        while (temp.size() > 0) {
            TreeNode currentNode = temp.getFirst();
            temp.addAll(currentNode.getChildren());
            temp.removeFirst();
            if (predicate.test(currentNode)) {
                result = currentNode;
                return result;
            }
        }
        return null;
    }

    /**
     * Predicate search in the tree.
     *
     * @param predicate predicate.
     * @return List node.
     */
    public List<TreeNode> findBFSofList(Predicate<TreeNode> predicate) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        ArrayDeque<TreeNode> temp = new ArrayDeque<TreeNode>();
        temp.add(root);
        while (temp.size() > 0) {
            TreeNode currentMyNode = temp.getFirst();
            temp.addAll(currentMyNode.getChildren());
            temp.removeFirst();
            if (predicate.test(currentMyNode)) {
                result.add(currentMyNode);
            }
        }
        return result;
    }

    public TreeNode findDFS(Predicate<TreeNode> predicate) {

        TreeNode[] foundNode = new TreeNode[1];
        if (predicate.test(root)) {
            return root;
        } else {
             findNodeDFS(root, foundNode, predicate);
        }
        System.out.println(foundNode[0]);
        return foundNode[0];
    }

    private void findNodeDFS(TreeNode node, TreeNode[] foundNode, Predicate<TreeNode> predicate) {
        if (node.getChildren().size() != 0) {
            for (TreeNode child : node.getChildren()) {
                if (predicate.test(child)) {
                    foundNode[0] = child;
                } else {
                    findNodeDFS(child, foundNode, predicate);
                }
            }
        }
    }

    public long amountNodes() {
        long[] amount = new long[1];
        amountOfNodesTreeTraversalOfDFS(root, amount);
        return amount[0];
    }

    private void amountOfNodesTreeTraversalOfDFS(TreeNode node, long[] amount) {
        amount[0]++;
        if (node.getChildren().size() != 0) {
            for (TreeNode child : node.getChildren()) {
                amountOfNodesTreeTraversalOfDFS(child, amount);
            }
        }
    }
}
