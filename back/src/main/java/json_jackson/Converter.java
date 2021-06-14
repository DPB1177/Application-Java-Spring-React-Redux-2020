package json_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.tree.DataTree;
import models.tree.TreeNode;

import java.io.File;
import java.io.IOException;

public class Converter {

    public final static String baseFile = "dataTree.json";
    public final static String file_json_node = "treeNode.json";

    public static void toJSON_Tree(DataTree dataTree) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), dataTree);
        System.out.println("json of the dataTree created!");
    }
    public static void toJSON_Node(TreeNode node) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file_json_node), node);
        System.out.println("json of the node created!");
    }


//    public static User toJavaObject() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(new File(baseFile), User.class);
//    }

}