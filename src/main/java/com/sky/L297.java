package com.sky;

import java.util.*;

public class L297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    // 使用前序遍历序列化，避免索引爆炸问题
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        return sb.toString();
    }

    private void rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            rserialize(root.left, sb);
            rserialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] nodes = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(nodes));
        return rdeserialize(dataList);
    }

    private TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }
}
