package com.sky;

import java.util.HashMap;
import java.util.Map;

public class L105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (inLength == 0 || preLength != inLength) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return BuildTree(preorder, 0, preLength - 1, map, 0, inLength - 1);
    }

    public TreeNode BuildTree(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> map, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(rootVal);
        root.left = BuildTree(preorder, preStart + 1, preStart + rootIndex - inStart, map, inStart, rootIndex - 1);
        root.right = BuildTree(preorder, preStart - inStart + rootIndex + 1, preEnd, map, rootIndex + 1, inEnd);
        return root;
    }
}
