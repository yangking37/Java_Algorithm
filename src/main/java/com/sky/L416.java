package com.sky;

import java.util.Arrays;

public class L416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0;
        int MaxNum = 0;
        for (int num : nums) {
            sum += num;
            MaxNum = Math.max(MaxNum, num);
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        if (MaxNum > target) return false;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }


    public static void main(String[] args) {
        L416 l139 = new L416();
        System.out.println(l139.canPartition(new int[]{2, 4, 2, 4}));
    }
}
