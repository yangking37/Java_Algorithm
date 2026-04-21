package com.sky;

public class L530 {
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

    int val = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return val;
    }

    public int dfs(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int m = Math.min(Math.abs(root.val - left), Math.abs(root.val - right));
        val = Math.min(val, m);
        return root.val;
    }
}
