package com.sky;

public class L44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (equals(i, j, s, p))
                        dp[i][j] = dp[i - 1][j - 1]; // 当前字符匹配，继承上一个字符的状态
                } else {
                    if (i == 0)
                        dp[i][j] = dp[i][j - 1]; // 当字符串的长度为零时，只能选择不用
                    else
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];// *号可以匹配零个或多个字符
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean equals(int x, int y, String s, String p) {
        if (x == 0) return false;
        if (p.charAt(y - 1) == '?') return true;
        return s.charAt(x - 1) == p.charAt(y - 1);
    }

    public static void main(String[] args) {
        L44 l = new L44();
        System.out.println(l.isMatch("abcabczzzde", "*abc???de*"));
    }
}
