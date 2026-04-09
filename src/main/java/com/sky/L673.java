package com.sky;

import java.util.Arrays;

public class L673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1; // 找到了更长的子序列
                        cnt[i] = cnt[j]; // 重置计数，因为找到了更长的子序列，所以计数重新开始
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j]; // 累加计数，因为找到了相同长度的子序列，所以计数累加
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L673 obj = new L673();
        int[] nums = new int[] {1, 3, 5, 4, 7};
        System.out.println(obj.findNumberOfLIS(nums));
    }
}
