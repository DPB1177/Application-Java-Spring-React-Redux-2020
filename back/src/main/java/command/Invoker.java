package command;

//import database.datastructure.AbstractData;
//import database.formertreefromdb.LoadingTreeWithDateBase;
//import database.tree.TreeDataBase;

/**
 * The Invoker class.
 */
public class Invoker {

    private Invoker() {
        throw new IllegalStateException("Invoker class");
    }
//    private Command<Boolean> createConnect;
//    private Command<Boolean> closeConnect;
//    private Command<Boolean> saveXMLFile;
//    private Command<TreeDataBase<AbstractData>> uploadXML;
//    private Command<TreeDataBase<AbstractData>> lazyLoading;
//
//    /**
//     * Method test.
//     */
//    public void work() {
//        // CreateConnectDataBaseCommand
//        String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
//        String user = "userfull";
//        String password = "12345";
//        createConnect = new CreateConnectDataBaseCommand(url, user, password);
//        createConnect.execute();
//
//        // LazyLoadingCommand
//        LoadingTreeWithDateBase former = new LoadingTreeWithDateBase();
//        TreeDataBase<AbstractData> tree = former.getTree();
//        lazyLoading = new LazyLoadingCommand(0, tree);
//        tree = lazyLoading.execute();
//        lazyLoading = new LazyLoadingCommand(1, tree);
//        tree = lazyLoading.execute();
//        lazyLoading = new LazyLoadingCommand(2, tree);
//        tree = lazyLoading.execute();
//        lazyLoading = new LazyLoadingCommand(6, tree);
//        tree = lazyLoading.execute();
//        lazyLoading = new LazyLoadingCommand(7, tree);
//        tree = lazyLoading.execute();
//
//        // CloseConnectDataBaseCommand
//        closeConnect = new CloseConnectDataBaseCommand();
//        closeConnect.execute();
//
//        // SaveXMLFileCommand
//        String nameFile = "src/main/resources/xml_file_test_01userfull.xml";
//        saveXMLFile = new SaveXMLFileCommand(nameFile, tree);
//        saveXMLFile.execute();
//
//        // UploadXMLFileCommand
//        uploadXML = new UploadXMLFileCommand(nameFile);
//        uploadXML.execute();
//
//        // SaveXMLFileCommand
//        nameFile = "src/main/resources/xml_file_test_02userfull.xml";
//        saveXMLFile = new SaveXMLFileCommand(nameFile, tree);
//        saveXMLFile.execute();
//
//
//    }
}

