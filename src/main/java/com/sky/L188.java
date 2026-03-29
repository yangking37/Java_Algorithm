package com.sky;

public class L188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][0] = -prices[0]; // 0是买
            dp[i][1] = 0; // 1是卖
        }
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    dp[i][0] = Math.max(dp[i][0], -price);
                    dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
                } else {
                    dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - price);
                    dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
                }
            }
        }
        return dp[k - 1][1];
    }

    public static void main(String[] args) {
        L188 l188 = new L188();
        System.out.println(l188.maxProfit(2, new int[]{2,4,1}));
    }
}
