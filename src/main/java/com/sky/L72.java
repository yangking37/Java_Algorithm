package com.sky;

public class L72 {

    public int minDistance(String word1, String word2) {
        // dp[i][j]表示的是word1的[0,i-1]和word2的[0,j-1]所需要的最小编辑距离
       int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;  // 表示word1的子串到空字符串的最小编辑距离
        for (int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;  // 同理
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 如果两个字符相同，那么最小编辑距离与dp[i-1][j-1]是相等的
                } else {
                    // 如果不相等，那么最小编辑距离就是dp[i - 1][j],dp[i][j - 1],dp[i - 1][j - 1]三个的最小值加一
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        L72 solution = new L72();
        System.out.println(solution.minDistance("horse", "ros"));
    }
}
