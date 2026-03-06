package com.sky;

public class L543 {
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

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depthOfBinaryTree(root);
        return res;
    }

    public int depthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = depthOfBinaryTree(root.left);
        int right = depthOfBinaryTree(root.right);
        if (left + right > res)
            res = left + right;
        return Math.max(left, right) + 1;
    }
}
