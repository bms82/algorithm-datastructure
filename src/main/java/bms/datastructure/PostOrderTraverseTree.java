package bms.datastructure;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class PostOrderTraverseTree {

    void traverse(TreeNode node) {

        if (node.left != null) {
            traverse(node.left);
        }
        if (node.right != null) {
            traverse(node.right);
        }
        node.visit();
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

    String NULL = "#";
    String SEP = ",";
    StringBuilder sb = new StringBuilder();


    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        serialize(root.left, sb);
        serialize(root.right, sb);

        sb.append(root.val).append(SEP);
    }

    TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        String last = nodes.removeLast();
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(last);
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);
        return root;
    }
}
