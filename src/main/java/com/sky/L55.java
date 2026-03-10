package com.sky;

import java.util.ArrayDeque;
import java.util.Deque;

public class L55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 0, 2, 0, 2, 0, 0, 2, 0};
        L55 l22 = new L55();
        System.out.println(l22.canJump(nums));
    }
}
