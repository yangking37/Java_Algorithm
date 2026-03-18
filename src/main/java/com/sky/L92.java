package com.sky;

public class L92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) { //找到左边的前面一个
            prev = prev.next;
        }
        ListNode Next = prev.next;
        for (int j = 0; j < right - left + 1; j++) { // 找到右边的后面一个
            Next = Next.next;
        }
        ListNode cur = prev.next;
        for (int i = 0; i < right - left + 1; i++) { //反转
            ListNode temp = cur.next;
            cur.next = Next;
            Next = cur;
            cur = temp;
        }
        prev.next = Next;
        return dummy.next;
    }

    // 方法二
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
