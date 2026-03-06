package com.sky;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L199 {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int size = 0;
        stack.offer(root);
        while (!stack.isEmpty()) {
            size = stack.size();
            while (size > 0) {
                if (size == 1) {
                    TreeNode node = stack.poll();
                    if (node.left != null) {
                        stack.offer(node.left);
                    }
                    if (node.right != null) {
                        stack.offer(node.right);
                    }
                    list.add(node.val);
                    break;
                }
                TreeNode node = stack.poll();
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
                size--;
            }
        }
        return list;
    }
}
