package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L94 {
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

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        SortTree(root);
        return res;
    }

    private void SortTree(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            SortTree(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            SortTree(root.right);
        }
    }
}
