package com.sky;

import java.util.ArrayList;
import java.util.List;

public class L144 {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Dfs(root,list);
        return list;
    }

    private void Dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        Dfs(root.left,list);
        Dfs(root.right,list);
    }

}
