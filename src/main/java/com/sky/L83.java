package com.sky;

public class L83 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        while (prev.next != null) {
            ListNode cur = prev.next;
            if (cur.val == prev.val)
                prev.next = cur.next;
            else
                prev = prev.next;
        }
        return head;
    }
}
