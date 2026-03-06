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

    // 方法二 Morris 中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        while (root != null) {
            if (root.left != null) {
                TreeNode predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    ans.add(root.val);
                    root = root.right;
                    predecessor.right = null;
                }
            } else {
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
