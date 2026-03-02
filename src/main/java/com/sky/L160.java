package com.sky;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L160 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public  ListNode getIntersectionNode(ListNode headA, ListNode headB){
//        Set<ListNode> set = new HashSet<>();
//        ListNode temp = headA;
//        while (temp !=null){
//            set.add(temp);
//            temp = temp.next;
//        }
//        temp = headB;
//        while (temp != null){
//            if (set.contains(temp))
//                return temp;
//            temp = temp.next;
//        }
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
    }
}
