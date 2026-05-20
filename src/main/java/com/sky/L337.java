package com.sky;

public class L337 {
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

    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }
    public int[] robTree(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        int rob = root.val + left[0] + right[0]; // 偷当前节点 + 左子树不偷 + 右子树不偷
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不偷当前节点 + 左子树偷 + 右子树偷
        return new int[]{notRob, rob};
    }
}
