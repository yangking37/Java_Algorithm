package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class ATreeNode {
        ATreeNode ancestor = null;
        int val;
        int depth;
        ATreeNode left;
        ATreeNode right;

        ATreeNode(int val) {
            this.val = val;
        }
    }

    // 方法一
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ATreeNode ancestor = copyTree(root, 1);
        ATreeNode aP = findval(ancestor, p);
        ATreeNode aQ = findval(ancestor, q);
        // 使两节点深度一致
        while (aP.depth > aQ.depth) aP = aP.ancestor;
        while (aQ.depth > aP.depth) aQ = aQ.ancestor;
        // 同时上移至相遇
        while (aP != aQ) {
            aP = aP.ancestor;
            aQ = aQ.ancestor;
        }
        return findTreeval(root, aP.val);
    }

    public ATreeNode copyTree(TreeNode root, int depth) {
        if (root == null) return null;
        ATreeNode node = new ATreeNode(root.val);
        node.depth = depth;
        if (root.left != null) {
            node.left = copyTree(root.left, depth + 1);
            node.left.ancestor = node;
        }
        if (root.right != null) {
            node.right = copyTree(root.right, depth + 1);
            node.right.ancestor = node;
        }
        return node;
    }

    public ATreeNode findval(ATreeNode root, TreeNode p) {
        Deque<ATreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            ATreeNode node = stack.poll();
            if (node.val == p.val) {
                return node;
            }
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode findTreeval(TreeNode root, int val) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (node.val == val) {
                return node;
            }
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
        }
        return root;
    }

    //方法二 ，直接使用递归,
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        return null;
    }
}
