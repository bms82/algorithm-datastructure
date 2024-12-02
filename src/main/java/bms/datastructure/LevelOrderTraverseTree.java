package bms.datastructure;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
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

    String SEP = ",";
    String NULL = "#";

    String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);

            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < nodes.length; ) {
            TreeNode parent = q.poll();
            String left  = nodes[i++];
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null;
            }

            String right = nodes[i++];
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }


}
