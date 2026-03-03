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
        if (head == null || head.next == null)
            return head;
        ListNode First = null, FirstTail = null;
        ListNode Second = null, SecondTail = null;
        First = FirstTail = new ListNode(head.val);
        Second = SecondTail = new ListNode(head.next.val);
        ListNode temp = head.next.next;
        while (temp != null) {
            FirstTail.next = new ListNode(temp.val);
            FirstTail = FirstTail.next;
            temp = temp.next;
            if (temp == null) break;
            SecondTail.next = new ListNode(temp.val);
            SecondTail = SecondTail.next;
            temp = temp.next;
        }
        ListNode F = First, S = Second, FN = First.next, SN = Second.next;
        while (FN != null && SN != null) {
            S.next = F;
            F.next = SN;
            S = SN;
            F = FN;
            SN = SN.next;
            FN = FN.next;
        }
        S.next = F; // 最后一步要执行
        return Second;
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
