package com.sky;

public class L129 {
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
    long sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return (int) sum;
    }

    public void dfs(TreeNode cur, int num) {
        num = num * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            sum += num;
            return;
        }
        if (cur.left != null) {
            dfs(cur.left, num);
        }
        if (cur.right != null) {
            dfs(cur.right, num);
        }
    }
}
