package com.sky;

import java.util.Arrays;
import java.util.List;

public class L300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public static void main(String[] args) {
        L300 l139 = new L300();
        System.out.println(l139.lengthOfLIS(new int[]{2,3,-2,4}));
    }
}
