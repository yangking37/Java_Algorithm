package com.sky;

public class L82 {
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

    // 维护三个节点，pre指向空节点，cur指向pre下一个节点，next指向cur下一个节点
    // 分两种情况，
    // 第一种情况是cur.val == next.val 那么就将next向后移，找到最后一个与cur值相等的节点，然后pre指向next的下一个节点，
    // 第二种情况是cur.val != next.val 那么pre向前移一个节点
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            ListNode cur = prev.next;
            ListNode next = cur.next;
            if (next != null && next.val == cur.val)
                while (next.next != null && next.next.val == next.val)
                    next = next.next;
            if (next != null && next.val == cur.val)
                prev.next = next.next;
            else
                prev = prev.next;
        }
        return dummy.next;
    }
}
