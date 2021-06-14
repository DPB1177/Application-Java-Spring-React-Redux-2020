package xml_dom;


import java.util.HashMap;
import java.util.Map;

/**
 * Description for node data classes and node data constructors.
 */
final class TagNodeNames {

    private TagNodeNames() {
        throw new IllegalStateException("DataClasses");
    }

    public static Map<String, String> initTegNode;

    static {
        initTegNode = new HashMap<>();

        initTegNode.put("root", "root");
        initTegNode.put("schemas", "schemas");
        initTegNode.put("schema", "schema");
        initTegNode.put("tables", "tables");
        initTegNode.put("table", "table");
        initTegNode.put("column", "column");
        initTegNode.put("columns", "columns");
        initTegNode.put("functions", "functions");
        initTegNode.put("function", "function");
        initTegNode.put("procedures", "procedures");
        initTegNode.put("procedure", "procedure");
        initTegNode.put("views", "views");
        initTegNode.put("view", "view");
        initTegNode.put("triggers", "triggers");
        initTegNode.put("trigger", "trigger");
    }
}
