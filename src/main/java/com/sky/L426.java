package com.sky;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L426 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = root;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        List<Node> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            while (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            list.add(root);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.right;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            head = list.get(i);
            head.right = list.get(i + 1);
        }
        for (int i = 1; i < list.size(); i++) {
            head = list.get(i);
            head.left = list.get(i - 1);
        }
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = list.get(0);
        return list.get(0);
    }


    //记录头结点，用来最后返回的
    private Node head = null;
    //记录遍历的当前节点的前一个节点,
    //用来把当前节点给串起来的
    private Node pre = null;
    // 递归写法
    public Node treeToDoublyList2(Node root) {
        if (root == null)
            return root;
        inorder(root);
        //注意，上面的方法中，我们只是把第一个接点到
        //最后一个节点串了起来，但并没有把第一个节点
        //和最后一个节点串起来连成一个环形，所以这里
        //还要把链表的首尾连接起来（这里pre已经是尾节点了）
        head.left = pre;
        pre.right = head;
        return head;
    }

    //二叉树的中序遍历
    private void inorder(Node root) {
        //边界条件的判断
        if (root == null)
            return;
        //先遍历左子节点
        inorder(root.left);

        //下面是对当前节点的操作
        if (pre == null) {
            //这行代码只会执行一次，就是root是树的左子节点的
            //左子节点的……,一直没有左子节点为止,实际上就是中
            //序遍历结果的第一个节点
            head = root;
        } else {
            //串起来的结果就是前一个节点pre的right指向当前节点，
            //然后当前节点的left指向前一个节点pre
            pre.right = root;
        }
        root.left = pre;
        //前一个节点和当前节点串起来之后，就让当前节点变成前一个节点
        pre = root;

        //最后在遍历右子节点
        inorder(root.right);
    }
}

