package com.sky;

import java.util.HashMap;

public class L1658 {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int target = sum - x;
        if (target < 0)
            return -1;
        int left = 0, right = 0;
        int cur = 0;
        int res = Integer.MIN_VALUE;
        while (right < nums.length) {
            cur += nums[right];
            while (cur > target) {
                cur -= nums[left];
                left++;
            }
            if (cur == target)
                res = Math.max(res, right - left + 1);
            right++;
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 4, 2, 3};
        int x = 5;
        L1658 l1658 = new L1658();
        System.out.println(l1658.minOperations(a, x));
    }
}
