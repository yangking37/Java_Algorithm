package com.sky;

public class LCR_143 {

//    Definition for a binary tree node.
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
    // 与L572类似
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B) || isSubStructureCore(A, B);
    }

    private boolean isSubStructureCore(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && isSubStructureCore(A.left, B.left) && isSubStructureCore(A.right, B.right);
    }
}
