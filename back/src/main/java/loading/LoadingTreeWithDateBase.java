package loading;

import constants.Constants;
import models.tree.DataTree;
import models.tree.TreeNode;

import java.util.List;

/**
 * LoadingTreeWithDateBase.
 */
public class LoadingTreeWithDateBase {
    private DataTree tree;

    /**
     * Constructor.
     */
    public LoadingTreeWithDateBase() {
        this.tree = new DataTree(new TreeNode(LoadingInformation.LoadingRoot()));
    }

    /**
     * Constructor.
     */
    public LoadingTreeWithDateBase(DataTree tree) {
        this.tree = tree;
    }

    public DataTree getTree() {
        return tree;
    }

    public List<TreeNode> findID(long id) {
        return tree.findBFSofList(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("id")) == id);
    }

    /**
     * Search for nodes by id.
     *
     * @param id long.
     * @return NodeDataBase.
     */
    private TreeNode findNodeForID(long id) {
        TreeNode node = tree.findBFS(nodeDataBase -> Long.parseLong(nodeDataBase.getData().getValue("id")) == id);
        if (node == null) {
            System.out.println("The node with id = " + id + " is not exist!");
        }
        return node;
    }

    /**
     * Search for nodes by id.
     *
     * @param id long.
     * @return NodeDataBase.
     */
    public TreeNode findNodeID(long id) {
        return findNodeForID(id);
    }

    public TreeNode findNodeRoot() {
        return tree.findBFS(nodeDataBase -> nodeDataBase.getData().getValue(Constants.KEY_NAME_NODE).equals("root"));
    }

    /**
     * Loading children node.
     *
     * @param id id Data of node.
     */
    public void loadChildren(long id) {
        if (tree != null) {
            TreeNode node = findNodeForID(id);
            if (node == null) {
                System.out.println("It is not node with id = " + id);
                return;
            }
//            if (node.getData().getValue(Constants.KEY_ALREADY_CLICKED).equals("yes")) {
//                return;
//            } else {
//                node.getData().setValue(Constants.KEY_ALREADY_CLICKED, "yes");
//            }
            switch (node.getData().getValue(Constants.KEY_NAME_NODE)) {
                case "root":
                    // Schemas
                    tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingSchemas(), node);
                    break;
                case "schemas":
                    String[] listSchema = node.getData().getValue(Constants.KEY_SCHEMA_LIST).split(" ");
                    if (listSchema.length != 0) {
                        for (String nameSchema : listSchema) {
                            // Schema
                            if (!nameSchema.equals("")) {
                                tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingSchema(nameSchema), node);
                            }
                        }
                    }
                    break;
                case "schema":
                    String nameSchema = node.getData().getValue(Constants.KEY_NAME_SCHEMA);
                    // Tables
                    tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingTables(nameSchema), node);
                    // Views
                    tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingViews(nameSchema), node);
                    // Procedures
                    tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingProcedures(nameSchema), node);
                    // Functions
                    tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingFunctions(nameSchema), node);
                    // Triggers
                    tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingTriggers(nameSchema), node);
                    break;
                case "tables":
                    String[] listTable = node.getData().getValue(Constants.KEY_TABLE_LIST).split(" ");
                    if (listTable.length != 0) {
                        for (String nameTable : listTable) {
                            // Table
                            if (!nameTable.equals("")) {
                                tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingTable(node.getData().getValue(Constants.KEY_NAME_SCHEMA), nameTable), node);
                            }
                        }
                    }
                    break;
                case "views":
                    String[] listView = node.getData().getValue(Constants.KEY_VIEW_LIST).split(" ");
                    if (listView.length != 0) {
                        for (String nameView : listView) {
                            // View
                            if (!nameView.equals("")) {
                                tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingView(node.getData().getValue(Constants.KEY_NAME_SCHEMA), nameView), node);
                            }
                        }
                    }
                    break;
                case "table":
                    String nameSchemaForTable = node.getData().getValue(Constants.KEY_NAME_SCHEMA);
                    String nameTable = node.getData().getValue(Constants.KEY_NAME_TABLE);
                    // Columns
                    tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingColumns(nameSchemaForTable, nameTable), node);
                    break;
                case "columns":
                    String[] listColumn = node.getData().getValue(Constants.KEY_COLUMN_LIST).split(" ");
                    if (listColumn.length != 0) {
                        for (String nameColumn : listColumn) {
                            // Column
                            if (!nameColumn.equals("")) {
                                tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingColumn(node.getData().getValue(Constants.KEY_NAME_SCHEMA), node.getData().getValue(Constants.KEY_NAME_TABLE), nameColumn), node);
                            }
                        }
                    }
                    break;
                case "procedures":
                    String[] listProcedure = node.getData().getValue(Constants.KEY_PROCEDURE_LIST).split(" ");
                    if (listProcedure.length != 0) {
                        for (String nameProcedure : listProcedure) {
                            // Procedure
                            if (!nameProcedure.equals("")) {
                                tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingProcedure(node.getData().getValue(Constants.KEY_NAME_SCHEMA), nameProcedure), node);
                            }
                        }
                    }
                    break;
                case "functions":
                    String[] listFunction = node.getData().getValue(Constants.KEY_FUNCTION_LIST).split(" ");
                    if (listFunction.length != 0) {
                        for (String nameFunction : listFunction) {
                            // Function
                            if (!nameFunction.equals("")) {
                                tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingFunction(node.getData().getValue(Constants.KEY_NAME_SCHEMA), nameFunction), node);
                            }
                        }
                    }
                    break;
                case "triggers":
                    String[] listTrigger = node.getData().getValue(Constants.KEY_TRIGGER_LIST).split(" ");
                    if (listTrigger.length != 0) {
                        for (String nameTrigger : listTrigger) {
                            // Trigger
                            if (!nameTrigger.equals("")) {
                                tree.addNodeWithDataToCurrentNode(LoadingInformation.LoadingTrigger(node.getData().getValue(Constants.KEY_NAME_SCHEMA), nameTrigger), node);
                            }
                        }
                    }
                    break;
                default:
            }
        }
    }

    /**
     * Loading all tree.
     */
    public void loadAllTree() {
        long index = 0L;
        if (tree != null) {
            TreeNode node = findNodeRoot();
            index = Long.parseLong(node.getData().getValue("id"));
        }
        while (findNodeForID(index) != null) {
            loadChildren(index);
            index++;
        }
    }
}
