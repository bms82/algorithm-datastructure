package bms.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class InOrderTraverseTree {

    Stack<TreeNode> order = new Stack<>();
    void traverse(TreeNode node) {

        if (node.right != null) {
            traverse(node.right);
        }
        order.push(node);
        if (node.left != null) {
            traverse(node.left);
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
        while(!order.isEmpty())
            System.out.println(order.pop().val);

    }



}
