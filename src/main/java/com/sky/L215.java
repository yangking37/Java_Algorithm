package com.sky;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L215 {

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // o2-o1为大顶堆，o1-o2为小顶堆
            }
        });
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        L215 l215 = new L215();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(l215.findKthLargest(nums, 2));
    }
}
