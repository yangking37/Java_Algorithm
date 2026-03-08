package com.sky;

public class L124 {
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

    int val = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return val;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left)); // 左边或者右边取大的那一边，注意不能够取负值
        int right = Math.max(0, dfs(root.right));
        int sum = root.val + left + right; // 合并左中右，更新答案
        val = Math.max(val, sum);
        return root.val + Math.max(left, right); // 返回数值最大的那条边
    }
}
