package bms.datastructure;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class LevelOrderTraverseTree {

    Queue<TreeNode> levelQueue = new PriorityQueue<>();
    void traverse(TreeNode node) {
        levelQueue.add(node);
        while (!levelQueue.isEmpty()) {
            node = levelQueue.poll();
            if (node.left != null) {
                levelQueue.add(node.left);
            }
            if (node.right != null) {
                levelQueue.add(node.right);
            }
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
}
