package com.sky;

import java.util.Arrays;
import java.util.List;

public class L139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        L139 l139 = new L139();
        System.out.println(l139.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
