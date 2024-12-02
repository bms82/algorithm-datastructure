package bms.datastructure;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class PreOrderTraverseTree {

    void traverse(TreeNode node) {

        node.visit();
        if (node.left != null) {
            traverse(node.left);
        }
        if (node.right != null) {
            traverse(node.right);
        }
    }

    @Test
    public void checkTree() {


        TreeNode DNode = new TreeNode("D");
        TreeNode ENode = new TreeNode("E");
        TreeNode FNode = new TreeNode("F");
        TreeNode GNode = new TreeNode("G");
        TreeNode ANode = new TreeNode("A");
        TreeNode BNode = new TreeNode("B");
        TreeNode CNode = new TreeNode("C");

        BNode.left = DNode;
        BNode.right = ENode;
        CNode.left = FNode;
        CNode.right = GNode;
        ANode.left = BNode;
        ANode.right = CNode;

        traverse(ANode);


    }

    String SEP = ",";
    String NULL = "#";

    StringBuilder sb = new StringBuilder();


    void serialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


}
