package com.sky;

public class L152 {
    public int maxProduct(int[] nums) {
        // 暴力解法，内存太大了
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        long[][] dp = new long[nums.length + 1][nums.length + 1];
//        dp[1][1] = 1;
//        for (int i = 1; i <= nums.length; i++) {
//            for (int j = i; j <= nums.length; j++) {
//                if (i == j) {
//                    dp[i][j] = nums[j - 1];
//                } else {
//                    dp[i][j] = dp[i][j - 1] * nums[j - 1];
//                }
//            }
//        }
//        int res = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            for (int j = i; j <= nums.length; j++) {
//                res = (int) Math.max(res,dp[i][j]);
//            }
//        }
//        return res;
        int len = nums.length;
        int[] minDp = new int[len + 1];
        int[] maxDp = new int[len + 1];
        // dp数组的0位置默认空序列，初始化为1(不参与最大值的更新)
        minDp[0] = 1;
        maxDp[0] = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            // 乘正数，不变号，0也算进去
            if (nums[i] >= 0) {
                minDp[i + 1] = Math.min(minDp[i] * nums[i], nums[i]);
                maxDp[i + 1] = Math.max(maxDp[i] * nums[i], nums[i]);
            } else {
                minDp[i + 1] = Math.min(maxDp[i] * nums[i], nums[i]);
                maxDp[i + 1] = Math.max(minDp[i] * nums[i], nums[i]);
            }
            // 比较更新最大值
            ans = Math.max(ans, maxDp[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-2,-3,-2,-4};
        L152 obj = new L152();
        System.out.println(obj.maxProduct(a));
    }
}
