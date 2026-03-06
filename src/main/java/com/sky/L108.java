package com.sky;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L108 {
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

    TreeNode root = null;

    public TreeNode sortedArrayToBST(int[] nums) {
        root = BuildBST(0, nums.length - 1, nums);
        return root;
    }

    public TreeNode BuildBST(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        if (right - left == 1) {
            TreeNode node = new TreeNode(nums[left]);
            node.right = new TreeNode(nums[right]);
            return node;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = BuildBST(left, mid - 1, nums);
        node.right = BuildBST(mid + 1, right, nums);
        return node;
    }
}
