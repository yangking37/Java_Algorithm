package com.sky;

public class L494 {

    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        find(nums, target, 0);
        return count;
    }

    public void find(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }
        find(nums, target + nums[index], index + 1);
        find(nums, target - nums[index], index + 1);
    }

    // 动态规划，将问题转化为背包问题
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    public static void main(String[] args) {
        L494 l = new L494();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(l.findTargetSumWays(nums, target));
    }
}
