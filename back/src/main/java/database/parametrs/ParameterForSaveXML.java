package database.parametrs;


import java.util.Arrays;

public class ParameterForSaveXML {
    private String[] index_minus;
    private String[] index_visible_children;
    private String[] index_load_node;
    private String[] index_zero;

    public String[] getIndex_minus() {
        return index_minus;
    }

    public void setIndex_minus(String[] index_minus) {
        this.index_minus = index_minus;
    }

    public String[] getIndex_visible_children() {
        return index_visible_children;
    }

    public void setIndex_visible_children(String[] index_visible_children) {
        this.index_visible_children = index_visible_children;
    }

    public String[] getIndex_load_node() {
        return index_load_node;
    }

    public void setIndex_load_node(String[] index_load_node) {
        this.index_load_node = index_load_node;
    }

    public String[] getIndex_zero() {
        return index_zero;
    }

    public void setIndex_zero(String[] index_zero) {
        this.index_zero = index_zero;
    }

    @Override
    public String toString() {
        return "ParameterForSaveXML{" +
                "index_minus=" + Arrays.toString(index_minus) +
                ", index_visible_children=" + Arrays.toString(index_visible_children) +
                ", index_load_node=" + Arrays.toString(index_load_node) +
                ", index_zero=" + Arrays.toString(index_zero) +
                '}';
    }
}
