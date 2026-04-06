package com.sky;

public class L572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSubtreeCore(root, subRoot);
    }

    private boolean isSubtreeCore(TreeNode A, TreeNode B) {
        if (B == null && A == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        return A.val == B.val && isSubtreeCore(A.left, B.left) && isSubtreeCore(A.right, B.right);
    }
}
