package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCR_174 {

    //    Definition for a binary tree node.
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

    public int findTargetNode(TreeNode root, int cnt) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            cnt--;
            if (cnt == 0)
                return root.val;
            if (root.left == null || root.left == prev) {
                prev = root;
                root = null;
            }else {
                root = root.left;
            }
        }
        return 0;
    }


}
