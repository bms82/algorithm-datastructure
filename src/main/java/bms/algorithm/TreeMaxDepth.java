package bms.algorithm;

import bms.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * LeetCode # 104. Maximum Depth of Binary Tree
 */
public class TreeMaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Constraint
    // C1. number of nodes range from 0 to 10,000
    // C2. node.val ranges from -100 to 100
    // Procedure
    // P1. change the root val to 1.
    // P2. change all the node.val to depth.
    // P3. return the value with max val.
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> treeNodeStack = new ArrayDeque<>();
        root.val = 1;
        treeNodeStack.add(root);
        int depth = 1;
        while(!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.poll();
            if (node.left != null) {
                node.left.val = node.val+1;
                treeNodeStack.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val+1;
                treeNodeStack.add(node.right);
            }
            depth = Math.max(node.val, depth);
        }


        return depth;
    }




    @Test
    public void checkTree() {


        TreeNode DNode = new TreeNode(8);
        TreeNode ENode = new TreeNode(9);
        TreeNode FNode = new TreeNode(5);
        TreeNode GNode = new TreeNode(1);
        TreeNode ANode = new TreeNode(7);
        TreeNode BNode = new TreeNode(6);
        TreeNode CNode = new TreeNode(4);

        BNode.left = DNode;
        BNode.right = ENode;
        CNode.left = FNode;
        CNode.right = GNode;
        ANode.left = BNode;
        ANode.right = CNode;

        assert maxDepth(ANode) == 3;


    }


}