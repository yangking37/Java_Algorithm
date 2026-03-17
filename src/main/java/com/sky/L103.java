package com.sky;

import java.util.*;

public class L103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        boolean flag = true;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size1 = Math.max(queue1.size(), queue2.size());
            for (int i = 0; i < size1; i++) {
                if (flag) { // 按照左右进行进栈
                    TreeNode node = queue1.pop();
                    if (node != null)
                        list.add(node.val);
                    if (node != null && node.left != null)
                        queue2.push(node.left);
                    if (node != null && node.right != null)
                        queue2.push(node.right);
                } else { // 按照右左进行进栈
                    TreeNode node = queue2.pop();
                    if (node != null)
                        list.add(node.val);
                    if (node != null && node.right != null)
                        queue1.push(node.right);
                    if (node != null && node.left != null)
                        queue1.push(node.left);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }
}
