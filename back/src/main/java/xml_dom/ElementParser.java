package xml_dom;

import constants.Constants;
import models.data.Information;
import models.tree.TreeNode;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 * Parsing an XML DOM element to form a tree node.
 */
final class ElementParser {
    private ElementParser() {
        throw new IllegalStateException("ElementParser");
    }

    static TreeNode parseElement(Element currentElement) {
        Information information = new Information();
        String tagName = currentElement.getTagName();
        information.setValue(Constants.KEY_NAME_NODE, tagName);
        // get a map containing the attributes of this node
        NamedNodeMap attributes = currentElement.getAttributes();
        // get the number of nodes in this map
        int numAttrs = attributes.getLength();
        for (int i = 0; i < numAttrs; i++) {
            Attr attr = (Attr) attributes.item(i);
            String attrName = attr.getNodeName();
            String attrValue = attr.getNodeValue();
            information.setValue(attrName, attrValue);
            //System.out.println("Found attribute: " + attrName + " with value: " + attrValue);
        }
        return new TreeNode(information);
    }
}
