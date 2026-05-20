package com.sky;

public class L86 {
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

    // 想复杂了
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = null;
        // 找到第一个大于等于x的节点
        while (curr.next != null) {
            if (curr.next.val < x) {
                curr = curr.next;
            } else {
                prev = curr;
                break;
            }
        }
        if (prev == null)
            return dummy.next;
        // 将curr 之后小于x的节点都移动到prev之后
        ListNode next = curr.next;
        ListNode temp = curr.next;
        while (next != null) {
            if (next.next != null && next.next.val < x) {
                prev.next = next.next;
                ListNode t = prev.next;
                while (t.next != null && t.next.val < x) {
                    t = t.next;
                }
                prev = t;
                next.next = t.next;
                next = next.next;
            } else {
                next = next.next;
            }
        }
        prev.next = temp;
        return dummy.next;
    }
    // 双指针法，一个指针用于遍历链表，另一个指针用于构建新的链表，时间复杂度O(n)，空间复杂度O(1)
    //直观来说我们只需维护两个链表 small 和 large 即可，
    // small 链表按顺序存储所有小于 x 的节点，large 链表按顺序存储所有大于等于 x 的节点。
    // 遍历完原链表后，我们只要将 small 链表尾节点指向 large 链表的头节点即能完成对链表的分隔
    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

}
