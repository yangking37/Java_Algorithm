package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= k)
                ans = Math.min(ans, i - deque.pollFirst());
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : (int) ans;
    }
}
