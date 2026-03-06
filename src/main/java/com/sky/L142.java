package com.sky;

import java.util.HashSet;
import java.util.Set;

public class L142 {
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

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode detect = head;
        Set<ListNode> set = new HashSet<ListNode>();
        if (fast == slow) {
            set.add(slow);
            fast = fast.next;
            while (fast != slow) {
                set.add(fast);
                if (fast != null) {
                    fast = fast.next;
                }
            }
            while (!set.contains(detect)) {
                detect = detect.next;
            }
            return detect;
        } else
            return null;
    }
}
