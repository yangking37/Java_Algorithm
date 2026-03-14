package com.sky;

import java.util.*;

public class L32 {

    // 使用栈 + 暴力
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
//        List<int[]> ans = new ArrayList<>(); // 空间太大了，可以使用bool数组
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    dp[stack.pop()] = true;
                    dp[i] = true;
//                    ans.add(new int[]{stack.pop(), i});
                }
            }
        }
//        ans.sort((o1, o2) -> o1[0] - o2[0]);
//        for (int i = 0; i < ans.size() - 1; i++) {
//            int[] arr1 = ans.get(i);
//            for (int j = i + 1; j < ans.size(); j++) {
//                int[] arr2 = ans.get(j);
//                if (arr1[1] + 1 == arr2[0]) {
//                    arr1[1] = arr2[1];
//                }
//            }
//        }
//        for (int[] an : ans) {
//            res = Math.max(res, an[1] - an[0] + 1);
//        }
        int maxLen = 0;
        int curLen = 0;
        for (boolean b : dp) {
            if (b) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else
                curLen = 0;
        }
//        return res;
        return maxLen;
    }

    // 方法二 动态规划
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        // 这个表达式有两种，首先是比较简单的连续的单括号，
        // 递推公式为dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2
        // 另外一个就是中间是连续的单括号了，
        // 首先需要加上dp[i-1]也就是中间包含的括号，在加上2，最后还需要再加上左括号的左边的值（如果是')'的话）
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        L32 l32 = new L32();
        System.out.println(l32.longestValidParentheses(""));
    }
}
