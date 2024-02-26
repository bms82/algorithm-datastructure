package bms.datastructure;

import org.junit.jupiter.api.Test;

public class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(String val) {
        this.val = val;
    }

    TreeNode(String val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void visit() {

        System.out.println(this.val);
    }
}
