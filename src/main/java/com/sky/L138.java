package com.sky;

public class L138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node newHead = new Node(cur.val);
            Node newNode = cur.next;
            cur.next = newHead;
            newHead.next = newNode;
            cur = newNode;
        }
        Node RandomCur = head;
        while (RandomCur != null) {
            RandomCur.next.random = RandomCur.random == null ? null : RandomCur.random.next;
            RandomCur = RandomCur.next.next;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
