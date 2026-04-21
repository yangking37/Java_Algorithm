package com.sky;

public class L25 {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            if(cur == null) return head;
            cur = cur.next;
        }

        ListNode dummy = new ListNode();
        dummy.next = reverseKGroup(cur, k);
        for(int i = 0; i < k; i++){
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
