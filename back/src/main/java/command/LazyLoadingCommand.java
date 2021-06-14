package command;

import loading.LoadingTreeWithDateBase;
import models.tree.DataTree;

/**
 * LazyLoadingCommand.
 */
public class LazyLoadingCommand implements Command<DataTree> {
    private long id;
//     private LoadingTreeWithDateBase former;
    private DataTree tree;

    public LazyLoadingCommand(long id, DataTree tree) {
        this.id = id;
        this.tree = tree;
    }

    @Override
    public DataTree execute() {
        LoadingTreeWithDateBase former = new LoadingTreeWithDateBase(tree);
        former.loadChildren(id);
        return former.getTree();
    }

}
