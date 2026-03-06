package com.sky;

public class L114 {
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
    // 方法一
    public void flatten(TreeNode root) {
        if (root == null)  return;
        DFS(root);
    }

    public void DFS(TreeNode root) {
        if (root == null) return;
        DFS(root.left);
        DFS(root.right);
        if (root.left != null) {
            if (root.right != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                while (root.right != null) {
                    root = root.right;
                }
                root.right = temp;

            }else {
                root.right = root.left;
                root.left = null;
            }
        }
    }

    //方法二 ,找前驱节点
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
