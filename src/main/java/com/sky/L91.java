package com.sky;

public class L91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' && s.charAt(i) != '0')
                dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
            else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6' && s.charAt(i) > '0')
                dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
            else if (s.charAt(i) == '0')// 如果是0, 只能和前面的字符组成一个整体
                dp[i] = (i - 2 >= 0 ? dp[i - 2] : 1);
            else
                dp[i] = dp[i - 1];
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        L91 l = new L91();
        System.out.println(l.numDecodings("21"));
    }
}
