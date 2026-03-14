package com.sky;

import java.util.Arrays;

public class L5 {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, false);
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int index = 0;
        int MaxLength = 0;
        // 注意要从后先前进行判断，从前向后的话会误判，应为我们初始化的时候为false
        // dp[i][j]的递推式为dp[i + 1][j - 1]，也就是前面的判断要依赖后面的值
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (b && (i + 1 <= j - 1)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else if (b && j - i == 1)
                        dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > MaxLength) {
                    MaxLength =  j - i + 1;
                    index = i;
                }
            }
        }
        return s.substring(index, index + MaxLength);
    }

    // 解法二，使用一维数组进行存储
    public String longestPalindrome2(String s) {
        int ans1 = 0, ans2 = 0;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 当前dp含义：以i为后缀的是否回文
            // 初始化：单个字符是回文
            dp[i] = true;
            for (int j = 0; j < i; j++) {
                // 字符j和i相等看内部是不是回文
                // 内部没有，即i -j = 1, 下面式子也是兼容的。
                // dp[j] ，表示[j,i]这个子串是否回文，而i每加一，dp[j]的含义就变成了[j+1,i-1]是否回文
                // 所以每次循环都会覆盖上一个，因为下一个字串只需要判断上个字串的值就行了
                dp[j] = s.charAt(j) == s.charAt(i) && dp[j+1];
                if (dp[j] && i - j > ans2 - ans1) {
                    ans2 = i;
                    ans1 = j;
                }
            }
        }
        return s.substring(ans1, ans2 + 1);
    }

    public static void main(String[] args) {
        L5 solution = new L5();
        System.out.println(solution.longestPalindrome("aaaa"));
    }
}
