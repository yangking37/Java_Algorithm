package com.sky;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L958 {
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

    public boolean isCompleteTree(TreeNode root) {
//        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
//        deque.offer(new Pair<>(root, 1));
//        int size;
//        int h = 0;
//        while (!deque.isEmpty()) {
//            size = deque.size();
//            if (size != (1 << h))
//                break;
//            for (int i = 0; i < size; i++) {
//                Pair<TreeNode, Integer> node = deque.poll();
//                if (node.getKey().left != null)
//                    deque.offer(new Pair<>(node.getKey().left, 2 * node.getValue()));
//                if (node.getKey().right != null)
//                    deque.offer(new Pair<>(node.getKey().right, 2 * node.getValue() + 1));
//                if (node.getKey().left == null && node.getKey().right != null) {
//                    return false;
//                }
//            }
//            h += 1;
//        }
//        int last = 1 << h;
//        while (!deque.isEmpty()) { // 遍历剩余节点,避免剩余节点中存在非空节点
//            Pair<TreeNode, Integer> node = deque.poll();
//            if (node.getKey().left != null || node.getKey().right != null)
//                return false;
//            if (node.getValue() == last)
//                last += 1;
//            else return false;
//        }
//        return true;
        List<Pair<TreeNode, Integer>> list = new ArrayList<>();
        list.add(new Pair<>(root, 1));
        int index = 0;
        while (index < list.size()) {
            Pair<TreeNode, Integer> node = list.get(index);
            if (node.getKey() != null){
                list.add(new Pair<>(node.getKey().left, 2 * node.getValue()));
                list.add(new Pair<>(node.getKey().right, 2 * node.getValue() + 1));
            }
            index++;
        }
        return list.get(index - 1).getValue() == list.size();
    }

    public static void main(String[] args) {
        L958 l958 = new L958();
        TreeNode root = l958.new TreeNode(1);
        TreeNode left = l958.new TreeNode(2);
        TreeNode right = l958.new TreeNode(3);
        root.left = left;
        root.right = right;
//        left.left = l958.new TreeNode(4);
//        left.right = l958.new TreeNode(5);
        right.left = l958.new TreeNode(6);
        right.right = l958.new TreeNode(7);
        System.out.println(l958.isCompleteTree(root));

    }
}
