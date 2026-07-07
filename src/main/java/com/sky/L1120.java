package com.sky;

public class L1120 {
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

    double max = 0;
    public float maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return (float) max;
    }

    public float dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        float sum = root.val + dfs(root.left) + dfs(root.right);
        float count = 1 + dfs(root.left) + dfs(root.right);
        max = Math.max(max, sum / (double) count);
        return sum;
    }

}
