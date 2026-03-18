package com.sky;

public class L143 {
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) { // 找中点
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode prev = null; // 翻转
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        ListNode pre = head.next;
        while (prev != null && pre != null) { // 拼接
            ListNode prevNext = prev.next;
            ListNode preNext = pre.next;
            pre.next = prev;
            prev.next = preNext;
            pre = preNext;
            prev = prevNext;
        }
    }
}
