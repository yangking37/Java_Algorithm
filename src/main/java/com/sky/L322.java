package com.sky;

import java.util.Arrays;

public class L322 {


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                if (coins[j] <= i) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        L322 l = new L322();
        int[] coins = {2};
        System.out.println(l.coinChange(coins, 3));
    }
}
