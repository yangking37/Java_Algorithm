package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L113 {
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

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        List<Integer> res = new ArrayList<>();
        Dfs(root, targetSum, res);
        return result;
    }

    public void Dfs(TreeNode root, int targetSum, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val)
                result.add(new ArrayList<>(res));
            return;
        }
        if (root.left != null) {
            Dfs(root.left, targetSum - root.val, res);
            res.remove(res.size() - 1);
        }
        if (root.right != null) {
            Dfs(root.right, targetSum - root.val, res);
            res.remove(res.size() - 1);
        }
    }
}
