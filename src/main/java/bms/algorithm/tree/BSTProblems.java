package bms.algorithm.tree;

import bms.datastructure.TreeNode;

public class BSTProblems {

    // BST가 맞는지 확인
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && Integer.parseInt(root.val) <= Integer.parseInt(min.val)) return false;
        if (max != null && Integer.parseInt(root.val) >= Integer.parseInt(max.val)) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, max, root);
    }


    // 특정 값이 있는지 확인 여부
    boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (Integer.parseInt(root.val) == target) return true;

        if (Integer.parseInt(root.val) > target)
            return isInBST(root.right, target);
        else
            return isInBST(root.left, target);
    }

    // BST에 수 삽입
    TreeNode insertInBST(TreeNode root, int number) {
        if (root == null) return new TreeNode(number);
        if (Integer.parseInt(root.val) == number) return root;
        if (Integer.parseInt(root.val) < number)
            root.right = insertInBST(root.right, number);
        if (Integer.parseInt(root.val) > number)
            root.left = insertInBST(root.left, number);
        return root;
    }

    // BST에서 수 제거
    TreeNode deleteNode(TreeNode root, int key) {
        if (Integer.parseInt(root.val) == key) {
            // 이 노드 삭제.
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, Integer.parseInt(minNode.val));
        } else if (Integer.parseInt(root.val) > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    // 가장 작은 수 찾기.
    TreeNode getMin(TreeNode node) {
        // 가장 왼쪽 BST가 가장 작아서 가장 왼쪽 BST를 가져옴
        while (node.left != null) node = node.left;
        return node;
    }
}
