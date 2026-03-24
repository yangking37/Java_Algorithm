package com.sky;

public class L24 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        return reverseList(head, 2);
    }

    public ListNode reverseList(ListNode cur, int k) {
        ListNode current = cur;
        for (int i = 0; i < k; i++) {
            if (current == null)
                return cur;
            current = current.next;
        }
        ListNode temp = new ListNode();
        temp.next = reverseList(current, k);
        for (int i = 0; i < k; i++) {
            ListNode tmp = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = tmp;
        }
        return temp.next;
    }

    // 第二种解法，加入一个哑节点
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    // 第三种解法，递归
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
