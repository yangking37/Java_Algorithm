package com.sky;

import java.util.Arrays;

public class L518 {
    // 使用dfs解决，但是会超时
//    int ans = 0;
//
//    public int change(int amount, int[] coins) {
//        if (amount == 0) return 1;
//        Arrays.sort(coins);
//        for (int i = 0; i < coins.length; i++) {
//            if (amount >= coins[i]) {
//                dfs(amount - coins[i], coins, i);
//            }
//        }
//        return ans;
//    }
//
//    public void dfs(int amount, int[] coins, int index) {
//        if (amount <= 0) {
//            if (amount == 0)
//                ans++;
//            return;
//        }
//        for (int i = index; i < coins.length; i++) {
//            if (amount >= coins[i]) {
//                dfs(amount - coins[i], coins, i);
//            }
//        }
//    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        L518 l518 = new L518();
        System.out.println(l518.change(10, new int[]{1, 2, 3, 4, 5}));
    }
}
