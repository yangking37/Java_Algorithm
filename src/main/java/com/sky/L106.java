package com.sky;

import java.util.HashMap;
import java.util.Map;

public class L106 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postLength = postorder.length;
        int inLength = inorder.length;
        if (inLength == 0 || postLength != inLength) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return BuildTree(postorder, 0, postLength - 1, map, 0, inLength - 1);
    }

    public TreeNode BuildTree(int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = map.get(rootVal);
        root.left = BuildTree(postorder, postStart, postStart + rootIndex - inStart - 1, map, inStart, rootIndex - 1);
        root.right = BuildTree(postorder, postStart - inStart + rootIndex, postEnd - 1, map, rootIndex + 1, inEnd);
        return root;
    }
}
