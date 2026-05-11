package com.sky;

public class L647 {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (i + 1 < n && j - 1 >= 0 && j - i > 1) ? dp[i + 1][j - 1] : true;
                }
                ans += dp[i][j] ? 1 : 0;
            }
        }
        return ans + n;
    }

    public static void main(String[] args) {
        L647 l647 = new L647();
        System.out.println(l647.countSubstrings("abc"));
    }
}
