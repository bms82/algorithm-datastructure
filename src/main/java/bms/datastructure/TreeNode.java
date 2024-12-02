package bms.datastructure;

public class TreeNode {
    public String val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(String val) {
        this.val = val;
    }

    TreeNode(String val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int number) {
        this.val = String.valueOf(number);
        this.left = null;
        this.right = null;
    }

    public void visit() {

        System.out.println(this.val);
    }
}
