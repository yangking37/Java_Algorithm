package com.sky;

import java.util.Arrays;

public class L198 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);  //初始的状态很重要
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        // 不使用数组进行存储,使用两个变量来代替数组，因为第i间房子是否偷取只跟前两个有关
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
//        return dp[n - 1];

    }



    public static void main(String[] args) {
        int[] a = {2,7,9,3,1};
        L198 l = new L198();
        System.out.println(l.rob(a));
    }
}
