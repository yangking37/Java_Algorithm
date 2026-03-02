package com.sky;

public class L206 {
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

    public ListNode reverseList(ListNode head) {
        ListNode p, r, q;
        if (head == null) {
            return head;
        }
        p = head;
        q = p.next;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
    }
}
