package com.sky;

public class L279 {


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        L279 l = new L279();
        System.out.println(l.numSquares(999));
    }
}
